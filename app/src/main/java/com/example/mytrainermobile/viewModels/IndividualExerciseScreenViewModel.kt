package com.example.mytrainermobile.viewModels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytrainermobile.data.network.repository.CycleExercisesRepository
import com.example.mytrainermobile.data.network.repository.RoutineCyclesRepository
import com.example.mytrainermobile.screenStates.IndividualExerciseScreenState
import kotlinx.coroutines.launch
import okhttp3.internal.wait

class IndividualExerciseScreenViewModel(
    private val cycleExercisesRepository: CycleExercisesRepository,
    private val routinesCyclesRepository: RoutineCyclesRepository,
): ViewModel() {
    var uiState by mutableStateOf(IndividualExerciseScreenState())
        private set

    fun getCycleExercises(cycleId: Int, next: Boolean, prev: Boolean) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            cycleExercisesRepository.getCycleExercises(cycleId = cycleId, refresh = true)
        }.onSuccess { response ->
            uiState = uiState.copy(
                isFetching = false,
                cycleExercises = response,
            )
            if(next) {
                nextExercise2()
            }
            else if(prev){
                prevExercise2()
            }else {
                execute2()
            }
        }.onFailure {  e ->
            uiState = uiState.copy(
                message = e.message,
                isFetching = false
            )
        }
    }

    fun getRoutineCycles(routineId: Int) = viewModelScope.launch {
        uiState = uiState.copy(
            isFetching = true,
            message = null
        )
        runCatching {
            routinesCyclesRepository.getRoutineCycles(routineId = routineId, refresh = true)
        }.onSuccess { response ->
            uiState = uiState.copy(
                isFetching = false,
                cycles = response
            )
            execute()
        }.onFailure {  e ->
            uiState = uiState.copy(
                message = e.message,
                isFetching = false
            )
        }
    }

    fun execute() {

        uiState = uiState.copy(cycleIndex = 0, exerciseIndex = 0)

        getCycleExercises(uiState.cycles[uiState.cycleIndex].id, false,false)

    }

    fun execute2() {
        uiState = uiState.copy(
            cycle = uiState.cycles[uiState.cycleIndex],
            exercise = uiState.cycleExercises[uiState.exerciseIndex])

        //uiState = uiState.copy(exerciseTime = uiState.exercise!!.duration!!.toLong())
        if(uiState.cycle != null) {
            uiState = uiState.copy(cycleReps = uiState.cycle!!.repetitions)
        }
    }

    fun nextExercise() {
        if( uiState.exerciseIndex < uiState.cycleExercises.size - 1) {
            uiState = uiState.copy( exerciseIndex = uiState.exerciseIndex + 1 )
            uiState = uiState.copy( exercise = uiState.cycleExercises[uiState.exerciseIndex] )
        }
        //termine ejecucion de ejercicios de un ciclo
        else {
            // ya no se repite mas el ciclo
            if( uiState.cycleReps == 1){
                // hay otro ciclo
                if(uiState.cycleIndex < uiState.cycles.size - 1) {
                    uiState = uiState.copy( cycleIndex = uiState.cycleIndex + 1 )
                    uiState = uiState.copy( exerciseIndex = 0)
                    // actualizo lista de ejercicios
                    getCycleExercises(uiState.cycles[uiState.cycleIndex].id, true, false)

                }
                // no hay mas ciclos
                else {
                    uiState = uiState.copy( finished = true )
                }
                uiState = uiState.copy( cycleReps = uiState.cycleReps - 1)
            }
            // sigue el mismo ciclo
            else{
                uiState = uiState.copy( exerciseIndex = 0 )
                uiState = uiState.copy( exercise = uiState.cycleExercises[uiState.exerciseIndex] )
            }
        }
    }

    fun nextExercise2(){
        uiState = uiState.copy(
            cycle = uiState.cycles[uiState.cycleIndex],
            exercise = uiState.cycleExercises[uiState.exerciseIndex]
        )
        uiState = uiState.cycle?.let { uiState.copy(cycleReps = it.repetitions) }!!
    }

    fun prevExercise() {
        // puedo volver atras
        if(uiState.exerciseIndex > 0){
            uiState = uiState.copy( exerciseIndex = uiState.exerciseIndex - 1 )
            uiState = uiState.copy( exercise = uiState.cycleExercises[uiState.exerciseIndex] )
        }
        // no puedo volver para atras
        else{
            // tengo que volver hasta la maxima cantidad de repeticiones
            if(uiState.cycle!!.repetitions > uiState.cycleReps && uiState.cycleReps != 0){
                uiState = uiState.copy( exerciseIndex = uiState.cycleExercises.size - 1 )
                uiState = uiState.copy( exercise = uiState.cycleExercises[uiState.exerciseIndex] )
                uiState = uiState.copy( cycleReps = uiState.cycleReps + 1 )
            }
            // si no, vuelvo al ciclo anterior
            else if(uiState.cycleIndex != 0){
                uiState = uiState.copy( cycleIndex = uiState.cycleIndex - 1)
                // actualizo lista de ejercicios
                getCycleExercises(uiState.cycles[uiState.cycleIndex].id, false, true)

            }
        }
    }

    fun prevExercise2(){
        uiState = uiState.copy( exerciseIndex = uiState.cycleExercises.size - 1 )
        uiState = uiState.copy( cycle = uiState.cycles[uiState.cycleIndex] )
        uiState = uiState.copy( exercise = uiState.cycleExercises[uiState.exerciseIndex] )
        uiState = uiState.copy( cycleReps = 1 )
    }


    fun refresh() {
        uiState = uiState.copy( refresh = !uiState.refresh)
    }
}
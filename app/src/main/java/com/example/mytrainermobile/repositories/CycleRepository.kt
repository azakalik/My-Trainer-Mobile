package com.example.mytrainermobile.repositories

import com.example.mytrainermobile.classes.Cycle

class CycleRepository {
    fun getCycleById(id: Int): Cycle{
        return Cycle(
            id = 1,
            name = "cycleName",
            detail = "cycleDetail",
            type = "cycleType",
            repetitions = 4,
            exerciseIds = listOf(1, 2, 3, 4, 5)
        )
    }
}
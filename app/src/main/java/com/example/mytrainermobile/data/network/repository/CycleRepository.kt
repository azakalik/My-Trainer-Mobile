package com.example.mytrainermobile.data.network.repository

import com.example.mytrainermobile.data.model.Cycle

class CycleRepository {

    private var cycles = listOf(
        Cycle(1, "Warmup", "www", "www", 1, listOf()),
        Cycle(2, "aaa", "aaa", "aaa", 1, listOf()),
        Cycle(3, "bbb", "bbb", "bbb", 1, listOf()),
        Cycle(4, "ccc", "ccc", "ccc", 1, listOf()),
        Cycle(5, "ddd", "ddd", "ddd", 1, listOf()),
    )

    fun getCycles(): List<Cycle> {
        return cycles
    }

    fun getCycleById(id: Int): Cycle {
        val cycle = cycles.find {it.id == id}
        return cycle?: cycle ?: Cycle(1, "", "","",1,listOf())
    }
}
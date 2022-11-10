package com.example.mytrainermobile.classes


/*
"id": 1,
      "name": "Fast Warmup",
      "detail": "Fast Warmup",
      "type": "warmup",
      "order": 1,
      "repetitions": 1,
      //TODO ver si en metadata guardo ID de los ejercicios
      "metadata": null
 */
data class CyclesData(
    val id: Int? = null,
    val detail: String? = null,
    val type: String? = null,
    val order: Int? = null,
    val repetitions: Int? = null
)
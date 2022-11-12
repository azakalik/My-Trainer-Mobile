package com.example.mytrainermobile.classes


/*
"id": 1,
      "name": "Fast Warmup",
      "detail": "Fast Warmup",
      "type": "warmup",
      "order": 1,
      "repetitions": 1,
      "metadata": null
 */
data class Cycle(
    val id: Int,
    val name: String,
    val detail: String,
    val type: String,
    val repetitions: Int,
    val exerciseIds: List<Int>
)
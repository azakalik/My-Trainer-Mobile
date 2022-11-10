package com.example.mytrainermobile.classes


/*

{
      "id": 1,
      "name": "Jumping Jacks",
      "detail": "Jumping Jacks",
      "type": "exercise",
      "date": 1620062203228,
      "metadata": null
    }
 */


//todo ver si cambiamos o no la logica de metadata

data class Excercise(
    val id: Int,
    val name: String,
    val detail: String,
    val type: String? = null,
    val metadata: String? = null
) {}
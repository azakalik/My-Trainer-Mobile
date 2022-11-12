package com.example.mytrainermobile.repositories

import com.example.mytrainermobile.classes.Cycle
import com.example.mytrainermobile.classes.Exercise
import com.example.mytrainermobile.classes.Routine

class RoutineRepository {

    private var myRoutines = listOf(
        Routine(
            id = 1,
            name = "routine1",
            creator = "user1",
            category = "Arms",
            isFavourite = true,
        ),
        Routine(
            id = 1,
            name = "routine1",
            creator = "user1",
            category = "Arms",
            isFavourite = false,
        ),
        Routine(
            id = 1,
            name = "routine1",
            creator = "user1",
            category = "Arms",
            isFavourite = true,
        ),
        Routine(
            id = 1,
            name = "routine1",
            creator = "user1",
            category = "Arms",
            isFavourite = true,
        ),
        Routine(
            id = 1,
            name = "routine1",
            creator = "user1",
            category = "Arms",
            isFavourite = false,
        ),
        Routine(
            id = 1,
            name = "routine1",
            creator = "user1",
            category = "Arms",
            isFavourite = true,
        ),
    )

    private var favouriteRoutines = listOf(
        Routine(
            id = 1,
            name = "routine1",
            creator = "user1",
            category = "Arms",
            isFavourite = true,
        ),
        Routine(
            id = 1,
            name = "routine1",
            creator = "user1",
            category = "Arms",
            isFavourite = true,
        ),
        Routine(
            id = 1,
            name = "routine1",
            creator = "user1",
            category = "Arms",
            isFavourite = true,
        ),
        Routine(
            id = 1,
            name = "routine1",
            creator = "user1",
            category = "Arms",
            isFavourite = true,
        ),
        Routine(
            id = 1,
            name = "routine1",
            creator = "user1",
            category = "Arms",
            isFavourite = true,
        ),
        Routine(
            id = 1,
            name = "routine1",
            creator = "user1",
            category = "Arms",
            isFavourite = true,
        ),
    )

    fun getUserRoutines(): List<Routine> {
        return myRoutines
    }

    fun getFavouriteRoutines(): List<Routine> {
        return favouriteRoutines
    }

    fun getAllRoutines(): List<Routine> {
        return myRoutines
    }

    fun getRoutineById(id: Int): Routine {
        return Routine(
            id = 1,
            name = "routine1",
            creator = "user1",
            category = "Arms",
            isFavourite = true,
        )
    }

}


package com.example.mytrainermobile.repositories

import com.example.mytrainermobile.classes.Routine

class RoutineRepository {

    private var myRoutines = listOf(
        Routine(
            id = 1,
            name = "routine2",
            creator = "user1",
            category = "legs",
            description = "description",
            difficulty = "difficulty",
            rating = "rating",
            isFavourite = true,
            cycleIds = listOf(1, 2, 3, 4, 5)
        ),
        Routine(
            id = 1,
            name = "routine2",
            creator = "user1",
            category = "legs",
            description = "description",
            difficulty = "difficulty",
            rating = "rating",
            isFavourite = false,
            cycleIds = listOf(1, 2, 3, 4, 5)
        ),

        Routine(
            id = 1,
            name = "routine2",
            creator = "user1",
            category = "legs",
            description = "description",
            difficulty = "difficulty",
            rating = "rating",
            isFavourite = true,
            cycleIds = listOf(1, 2, 3, 4, 5)
        ),

        Routine(
            id = 1,
            name = "routine2",
            creator = "user1",
            category = "legs",
            description = "description",
            difficulty = "difficulty",
            rating = "rating",
            isFavourite = true,
            cycleIds = listOf(1, 2, 3, 4, 5)
        ),

        Routine(
            id = 1,
            name = "routine2",
            creator = "user1",
            category = "legs",
            description = "description",
            difficulty = "difficulty",
            rating = "rating",
            isFavourite = true,
            cycleIds = listOf(1, 2, 3, 4, 5)
        ),

        )

    private var favouriteRoutines = listOf(
        Routine(
            id = 1,
            name = "routine2",
            creator = "user1",
            category = "legs",
            description = "description",
            difficulty = "difficulty",
            rating = "rating",
            isFavourite = true,
            cycleIds = listOf(1, 2, 3, 4, 5)
        ),
        Routine(
            id = 1,
            name = "routine2",
            creator = "user1",
            category = "legs",
            description = "description",
            difficulty = "difficulty",
            rating = "rating",
            isFavourite = true,
            cycleIds = listOf(1, 2, 3, 4, 5)
        ),

        Routine(
            id = 1,
            name = "routine2",
            creator = "user1",
            category = "legs",
            description = "description",
            difficulty = "difficulty",
            rating = "rating",
            isFavourite = true,
            cycleIds = listOf(1, 2, 3, 4, 5)
        ),

        Routine(
            id = 1,
            name = "routine2",
            creator = "user1",
            category = "legs",
            description = "description",
            difficulty = "difficulty",
            rating = "rating",
            isFavourite = true,
            cycleIds = listOf(1, 2, 3, 4, 5)
        ),

        Routine(
            id = 1,
            name = "routine2",
            creator = "user1",
            category = "legs",
            description = "description",
            difficulty = "difficulty",
            rating = "rating",
            isFavourite = true,
            cycleIds = listOf(1, 2, 3, 4, 5)
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
            name = "routine2",
            creator = "user1",
            category = "legs",
            description = "description",
            difficulty = "difficulty",
            rating = "rating",
            isFavourite = true,
            cycleIds = listOf(1, 2, 3, 4, 5)
        )
    }
}


package com.example.mytrainermobile.data.network.repository

import com.example.mytrainermobile.data.classes.Routine

class RoutineRepository {

    private var allRoutines = listOf(
        Routine(
            id = 1,
            name = "loleado",
            creator = "masi",
            category = "legs",
            description = "asdadadadsa",
            difficulty = "hard",
            rating = "1.3",
            isFavourite = true,
            cycleIds = listOf(1, 2, 3, 4, 5)
        ),
        Routine(
            id = 2,
            name = "bobo",
            creator = "asda",
            category = "tonto",
            description = "foafoafoafoafoaf",
            difficulty = "as,das",
            rating = "1.6",
            isFavourite = false,
            cycleIds = listOf(1, 2, 3, 4, 5)
        ),

        Routine(
            id = 3,
            name = "routine3",
            creator = "user1",
            category = "legs",
            description = "description",
            difficulty = "difficulty",
            rating = "rating",
            isFavourite = true,
            cycleIds = listOf(1, 2, 3, 4, 5)
        ),

        Routine(
            id = 4,
            name = "routine4",
            creator = "user1",
            category = "legs",
            description = "description",
            difficulty = "difficulty",
            rating = "rating",
            isFavourite = true,
            cycleIds = listOf(1, 2, 3, 4, 5)
        ),

        Routine(
            id = 5,
            name = "routine5",
            creator = "user1",
            category = "legs",
            description = "description",
            difficulty = "difficulty",
            rating = "rating",
            isFavourite = true,
            cycleIds = listOf(1, 2, 3, 4, 5)
        ),
    )

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
            id = 2,
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
            id = 3,
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
            id = 4,
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
            id = 5,
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


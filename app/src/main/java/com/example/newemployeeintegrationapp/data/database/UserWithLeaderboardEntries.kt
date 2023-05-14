package com.example.newemployeeintegrationapp.data.database

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithLeaderboardEntries(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userId"
    )
    val leaderboardEntries: List<LeaderboardEntity>
)

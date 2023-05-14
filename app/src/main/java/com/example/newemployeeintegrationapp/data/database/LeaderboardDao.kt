package com.example.newemployeeintegrationapp.data.database

import androidx.room.*

@Dao
interface LeaderboardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeaderboardEntry(leaderboard: LeaderboardEntity): Long

    @Update
    suspend fun updateLeaderboardEntry(leaderboard: LeaderboardEntity)

    @Delete
    suspend fun deleteLeaderboardEntry(leaderboard: LeaderboardEntity)

    @Query("SELECT * FROM Leaderboard")
    suspend fun getAllLeaderboardEntries(): List<LeaderboardEntity>

    @Query("SELECT * FROM Leaderboard WHERE id = :id")
    suspend fun getLeaderboardEntryById(id: Long): LeaderboardEntity?
}
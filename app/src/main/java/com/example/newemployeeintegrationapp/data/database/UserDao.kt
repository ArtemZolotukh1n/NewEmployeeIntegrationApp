package com.example.newemployeeintegrationapp.data.database

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity): Long

    @Update
    suspend fun updateUser(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Query("SELECT * FROM User")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM User WHERE userId = :userId")
    suspend fun getUserById(userId: Long): UserEntity?

    @Transaction
    @Query("SELECT * FROM User")
    suspend fun getUsersWithLeaderboardEntries(): List<UserWithLeaderboardEntries>
}
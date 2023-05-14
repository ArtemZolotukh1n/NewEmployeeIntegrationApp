package com.example.newemployeeintegrationapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "User")
class UserEntity(
    @PrimaryKey(autoGenerate = true) @NotNull val userId: Long = 0L,
    val nickname: String,
    val name: String,
    val surname: String,
    val completionPercentage: Double
)
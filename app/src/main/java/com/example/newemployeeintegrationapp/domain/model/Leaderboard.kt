package com.example.newemployeeintegrationapp.domain.model

import java.util.Date

data class Leaderboard(
    val leaderboardId: Long,
    val userId: Long,
    val taskId: Long,
    val completionDateTime: Date
)

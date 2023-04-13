package com.example.newemployeeintegrationapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.eestechhckathon.QuestTopAppBar
import com.example.newemployeeintegrationapp.navigation.NavGraph
import com.example.newemployeeintegrationapp.presentation.ui.app_bars.AppsBottomNavigationBar
import com.example.newemployeeintegrationapp.ui.theme.NewEmployeeIntegrationAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewEmployeeIntegrationAppTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = { QuestTopAppBar() },
                    bottomBar = { AppsBottomNavigationBar() }
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                    ) {
                        val navController = rememberNavController()
                        NavGraph(navController = navController)
                    }
                }
            }
        }
    }
}

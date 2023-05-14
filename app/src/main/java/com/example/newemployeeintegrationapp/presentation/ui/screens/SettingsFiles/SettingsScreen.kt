package com.example.newemployeeintegrationapp.presentation.ui.screens.SettingsFiles

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newemployeeintegrationapp.navigation.Screen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SettingsScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, bottom = 60.dp)
    ) {
        item {
            Text(
                text = "General",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 6.dp)
            )
            GeneralSettings()
        }

        item {
            Text(
                text = "Notifications",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 6.dp)
            )
            NotificationsSettings()
        }

        item {
            Text(
                text = "Terms & Support",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 6.dp)
            )
            TermsAndSupportSettings()
        }
    }
}

@Composable
fun GeneralSettings() {
    Column {
        SettingItem(title = "Edit Profile")
        SettingItem(title = "Change Password")
        SettingItem(title = "Change Language")
    }
}

@Composable
fun NotificationsSettings() {
    Column {
        SwitchSettingItem(title = "Edit Profile")
        SwitchSettingItem(title = "Change Password")
    }
}

@Composable
fun TermsAndSupportSettings() {
    Column {
        SettingItem(title = "Terms and Conditions")
        SettingItem(title = "Privacy Policy")
        SettingItem(title = "Support")
    }
}

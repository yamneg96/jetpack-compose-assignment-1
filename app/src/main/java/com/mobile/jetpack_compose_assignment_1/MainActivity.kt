package com.mobile.jetpack_compose_assignment_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.example.jetpackcomposeassignment.CourseListScreen
import com.mobile.jetpack_compose_assignment_1.data.sampleCourses

import com.mobile.jetpack_compose_assignment_1.ui.theme.JetpackComposeAssignmentTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // State for theme toggle
            var darkTheme by rememberSaveable { mutableStateOf(false) }

            JetpackComposeAssignmentTheme(darkTheme = darkTheme) {
                // Scaffold with TopAppBar containing a Switch
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("My Course Lists") },
                            actions = {
                                // Theme toggle switch
                                Switch(
                                    checked = darkTheme,
                                    onCheckedChange = { darkTheme = it }
                                )
                            }
                        )
                    }
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        CourseListScreen(courseList = sampleCourses)
                    }
                }
            }
        }
    }
}
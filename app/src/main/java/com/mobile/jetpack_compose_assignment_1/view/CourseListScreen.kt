package com.example.jetpackcomposeassignment

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.mobile.jetpack_compose_assignment_1.component.CourseCard
import com.mobile.jetpack_compose_assignment_1.data.Course

@Composable
fun CourseListScreen(
    courseList: List<Course>
) {
    LazyColumn {
        items(courseList) { course ->
            CourseCard(course = course)
        }
    }
}
package com.example.wined.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wined.model.Task

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var tasks by remember { mutableStateOf(listOf<Task>()) }
    var newTaskTitle by remember { mutableStateOf("") }

    val completedTasks = tasks.count { it.isCompleted }
    val totalTasks = tasks.size
    val completionPercentage = if (totalTasks > 0) (completedTasks.toFloat() / totalTasks * 100).toInt() else 0

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Win-ED Home") })
        },
        bottomBar = {
            BottomAppBar {
                Button(onClick = { navController.navigate("progress") }, modifier = Modifier.weight(1f)) {
                    Text("Progress")
                }
                Button(onClick = { navController.navigate("profile") }, modifier = Modifier.weight(1f)) {
                    Text("Profile")
                }
                Button(onClick = { navController.navigate("settings") }, modifier = Modifier.weight(1f)) {
                    Text("Settings")
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (newTaskTitle.isNotBlank()) {
                    tasks = tasks + Task(title = newTaskTitle)
                    newTaskTitle = ""
                }
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add Task")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Today's Wins: $completionPercentage%", style = MaterialTheme.typography.headlineSmall)
            LinearProgressIndicator(
                progress = { if (totalTasks > 0) completedTasks.toFloat() / totalTasks else 0f },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
            )

            OutlinedTextField(
                value = newTaskTitle,
                onValueChange = { newTaskTitle = it },
                label = { Text("What's your win today?") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(tasks) { task ->
                    TaskItem(
                        task = task,
                        onCheckedChange = { checked ->
                            tasks = tasks.map { if (it.id == task.id) it.copy(isCompleted = checked) else it }
                        },
                        onDelete = {
                            tasks = tasks.filter { it.id != task.id }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun TaskItem(task: Task, onCheckedChange: (Boolean) -> Unit, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = task.isCompleted,
            onCheckedChange = onCheckedChange
        )
        Text(
            text = task.title,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge
        )
        IconButton(onClick = onDelete) {
            Icon(Icons.Default.Delete, contentDescription = "Delete Task")
        }
    }
}

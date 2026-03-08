package com.example.wined.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgressScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Progress") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Weekly Completion", style = MaterialTheme.typography.headlineSmall)
            // Placeholder for Graph
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(vertical = 16.dp),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text("Graph Placeholder (Weekly)")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("Monthly Completion", style = MaterialTheme.typography.headlineSmall)
            // Placeholder for Graph
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(vertical = 16.dp),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text("Graph Placeholder (Monthly)")
            }
        }
    }
}

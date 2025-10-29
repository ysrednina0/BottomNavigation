package com.anindya.bottomnavigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.anindya.bottomnavigation.model.Book
import com.anindya.bottomnavigation.tabview.TabBarItem

@Composable
fun DetailScreen(
    navController: NavController,
    book: Book
) {
    val homeTab = TabBarItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(book.title, style = MaterialTheme.typography.headlineMedium)
        Text("Penulis: ${book.author}")
        Spacer(Modifier.height(8.dp))
        Text("Status: ${if (book.status) "Selesai Dibaca" else "Belum Selesai"}")
        Spacer(Modifier.height(16.dp))
        Text("Catatan:", style = MaterialTheme.typography.titleMedium)
        Text(book.notes)

        Button(
            onClick = {
                navController.popBackStack()
            },
        ) {
            Text("Back")
        }
    }
}

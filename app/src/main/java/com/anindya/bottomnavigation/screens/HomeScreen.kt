package com.anindya.bottomnavigation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.anindya.bottomnavigation.model.Book
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun HomeScreen(navController: NavController) {
    val books = listOf(
        Book(1, "Laut Bercerita", "Leila S. Chudori", "Novel sejarah Indonesia", true),
        Book(2, "Atomic Habits", "James Clear", "Kebiasaan kecil berdampak besar", false),
        Book(3, "Deep Work", "Cal Newport", "Fokus kerja mendalam", true)
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        items(books) { book ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable {
                        val json = Json.encodeToString(book)
                        navController.navigate("Detail/$json")
                    }
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(book.title, style = MaterialTheme.typography.titleLarge)
                    Text("Penulis: ${book.author}")
                    Text("Status: ${if (book.status) "Selesai Dibaca" else "Belum Selesai"}")
                }
            }
        }
    }
}

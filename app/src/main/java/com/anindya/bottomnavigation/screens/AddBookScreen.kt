package com.anindya.bottomnavigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddBookScreen(
    onNavigateToDetail: (String, String, String, Boolean) -> Unit ={_, _, _, _->},
) {
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }
    var status by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Input Judul Buku
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Judul Buku") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Input Penulis
        OutlinedTextField(
            value = author,
            onValueChange = { author = it },
            label = { Text("Penulis") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Input Catatan
        OutlinedTextField(
            value = notes,
            onValueChange = { notes = it },
            label = { Text("Catatan") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        ) {
            Text("Sudah Selesai Dibaca?", fontSize = 15.sp)
            Spacer(Modifier.width(8.dp))
            Switch(
                checked = status,
                onCheckedChange = { status = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFFA84339)
                )
            )
        }

        // Tombol Simpan
        Button(
            onClick = {
                onNavigateToDetail(title, author, notes, status)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFA84339),
                contentColor = Color.White
            ),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Simpan Buku",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

package com.anindya.bottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.anindya.bottomnavigation.model.Book
import com.anindya.bottomnavigation.screens.AddBookScreen
import com.anindya.bottomnavigation.screens.DetailScreen
import com.anindya.bottomnavigation.screens.HomeScreen
import com.anindya.bottomnavigation.tabview.TabBarItem
import com.anindya.bottomnavigation.tabview.TabView
import com.anindya.bottomnavigation.ui.theme.BottomNavigationTheme
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomNavigationTheme {
                val homeTab = TabBarItem(
                    title = "Home",
                    selectedIcon = Icons.Filled.Home,
                    unselectedIcon = Icons.Outlined.Home
                )
                val addTab = TabBarItem(
                    title = "Add",
                    selectedIcon = Icons.Filled.Add,
                    unselectedIcon = Icons.Outlined.Add
                )

                val tabItems = listOf(homeTab, addTab)
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = { TabView(tabItems = tabItems, navController = navController) },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AppNavHost(navController, tabItems, innerPadding)
                }
            }
        }
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    tabItem: List<TabBarItem>,
    innerPadding: androidx.compose.foundation.layout.PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = tabItem.first().title,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(tabItem[0].title) {
            HomeScreen(navController)
        }

        composable(tabItem[1].title) {
            AddBookScreen(
                onNavigateToDetail = { title, author, notes, status ->
                    val newBook = Book(
                        id = (0..1000).random(),
                        title = title,
                        author = author,
                        notes = notes,
                        status = status
                    )
                    val json = Json.encodeToString(newBook)
                    navController.navigate("Detail/$json")
                }
            )
        }

        composable(
            "Detail/{bookJson}",
            arguments = listOf(navArgument("bookJson") { type = NavType.StringType })
        ) { backStackEntry ->
            val json = backStackEntry.arguments?.getString("bookJson")
            val book = json?.let { Json.decodeFromString<Book>(it) }
            book?.let {
                DetailScreen(navController = navController, book = it)
            }
        }
    }
}

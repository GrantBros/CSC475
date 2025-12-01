package com.example.getitdone.ui.theme

import androidx.compose.runtime.Composable
import com.example.getitdone.ui.screens.*
import com.example.getitdone.ui.viewModel.GIDViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.getitdone.data.GetItDone


@Composable
fun AppNavHost(viewModel: GIDViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoute.Home.route)  {
        composable(NavRoute.Home.route) {
            HomeScreen(
                viewModel = viewModel,
                onAdd = { navController.navigate(NavRoute.Add.route) },
                onEdit = { todo ->
                    navController.navigate(
                        NavRoute.Edit.build(todo.id, todo.title, todo.details)
                    )
                }
            )
        }
        composable(NavRoute.Add.route) {
            AddScreen(viewModel = viewModel, onBack = {navController.popBackStack() }
            )
        }
        composable(
            NavRoute.Edit.route,
            arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("title") {type = NavType.StringType },
            navArgument("details") { type = NavType.StringType }
        ), content = {backStackEntry ->
                    val id = backStackEntry.arguments?.getInt("id") ?: 0
                    val title = backStackEntry.arguments?.getString("title")?: ""
                    val details = backStackEntry.arguments?.getString("details")?: ""
                    val task = GetItDone(id = id, title = title, details = details)
                EditScreen(
                    viewModel = viewModel,
                    task = task,
                    onBack = {navController.popBackStack() }
                    )
                }
            )
        }
    }

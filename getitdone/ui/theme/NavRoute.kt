package com.example.getitdone.ui.theme

sealed class NavRoute(val route: String) {
    object Home : NavRoute("home")
    object Add : NavRoute("add")
    object Edit : NavRoute("edit/{id}/{title}/{details}") {
        fun build(id: Int, title: String, details: String) = "edit/$id/$title/$details"
    }
}

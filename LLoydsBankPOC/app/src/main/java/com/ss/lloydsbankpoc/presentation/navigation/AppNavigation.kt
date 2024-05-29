package com.ss.lloydsbankpoc.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ss.lloydsbankpoc.R
import com.ss.lloydsbankpoc.common.Route
import com.ss.lloydsbankpoc.presentation.bookspage.BooksScreen
import com.ss.lloydsbankpoc.presentation.bookspage.viewmodel.BooksViewModel
import com.ss.lloydsbankpoc.presentation.spellspage.SpellsScreen
import com.ss.lloydsbankpoc.presentation.spellspage.viewmodel.SpellsViewModel
import com.ss.lloydsbankpoc.presentation.weasleypage.WeasleyScreen
import com.ss.lloydsbankpoc.presentation.weasleypage.viewmodel.WeasleyViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Route.BOOKS_SCREEN
) {
    val booksViewModel: BooksViewModel = viewModel()
    val spellsViewModel: SpellsViewModel = viewModel()
    val weasleyViewModel: WeasleyViewModel = viewModel()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        composable(
                route = Route.BOOKS_SCREEN,
            ) {
                BooksScreen(navController,booksViewModel = booksViewModel)
            }
        composable(
            route = Route.SPELLS_SCREEN,
        ) {
            SpellsScreen(navController,spellsViewModel = spellsViewModel)
        }
        composable(
            route = Route.WEASLEY_SCREEN,
        ) {
            WeasleyScreen(navController,weasleyViewModel = weasleyViewModel)
        }
    }
}




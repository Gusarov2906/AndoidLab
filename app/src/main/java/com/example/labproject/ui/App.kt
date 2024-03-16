package com.example.labproject.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.labproject.R
import com.example.labproject.StartScreen
import com.example.labproject.data.DataSource

enum class MainScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Lab1(title = R.string.lab1),
    Lab2(title = R.string.lab2),
    Lab3(title = R.string.lab3),
    Lab4_5_6(title = R.string.lab4_5_6),
    Lab7(title = R.string.lab7)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    currentScreen: MainScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = MainScreen.valueOf(
        backStackEntry?.destination?.route ?: MainScreen.Start.name
    )

    Scaffold(
        topBar = {
            AppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = MainScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            //START
            composable(route = MainScreen.Start.name) {
                StartScreen(
                    labsOptions = DataSource.labsOption,
                    onClickedLab1 = {
                        navController.navigate(MainScreen.Lab1.name)
                    },
                    onClickedLab2 = {
                        navController.navigate(MainScreen.Lab2.name)
                    },
                    onClickedLab3 = {
                        navController.navigate(MainScreen.Lab3.name)
                    },
                    onClickedLab4_5_6 = {
                        navController.navigate(MainScreen.Lab4_5_6.name)
                    },
                    onClickedLab7 = {
                        navController.navigate(MainScreen.Lab7.name)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            //LAB1
            composable(route = MainScreen.Lab1.name) {
                Lab1Screen(
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(navController)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            //LAB2
            composable(route = MainScreen.Lab2.name) {
                Lab2Screen(
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(navController)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            //LAB3
            composable(route = MainScreen.Lab3.name) {
                Lab3Screen(
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(navController)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            //LAB4_5_6
            composable(route = MainScreen.Lab4_5_6.name) {
                Lab4_5_6_Screen(
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(navController)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            //LAB8
            composable(route = MainScreen.Lab7.name) {
                Lab7_Screen(
                    onCancelButtonClicked = {
                        cancelOrderAndNavigateToStart(navController)
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}


private fun cancelOrderAndNavigateToStart(
    navController: NavHostController
) {
    navController.popBackStack(MainScreen.Start.name, inclusive = false)
}

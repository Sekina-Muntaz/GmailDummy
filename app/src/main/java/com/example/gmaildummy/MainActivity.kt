package com.example.gmaildummy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gmaildummy.components.*
import com.example.gmaildummy.ui.theme.GmailDummyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmailDummyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GmailApp()
                }
            }
        }
    }
}

@Composable
fun GmailApp() {
    val scaffoldState= rememberScaffoldState()
    val coroutineScope= rememberCoroutineScope()
    val scrollState= rememberScrollState()
    Scaffold(
        scaffoldState=scaffoldState,
        topBar = {HomeAppBar(scaffoldState,coroutineScope)},
        drawerContent={
            GmailDrawerMenu(scrollState = scrollState)
        },
        bottomBar = {
            HomeButtomMenu()
        },
        floatingActionButton = {GmailFab(scrollState = scrollState)}

        ) {
            MailList(paddingValues = it,scrollState = scrollState )
//            Navigation()



    }
    
}
@Composable
fun MainScreen(navController: NavController) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Column {
//        SearchView(textState)
//        CountryList(navController = navController, state = textState)
    }
}
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController = navController)
        }
        composable(
            "details/{countryName}",
            arguments = listOf(navArgument("countryName") { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("countryName")?.let { countryName ->
                MailDetails(countryName = countryName)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GmailDummyTheme {
        GmailApp()
    }
}
package com.demo.advancemultimodulararchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.advancemultimodulararchitecture.ui.theme.AdvanceMultiModularArchitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdvanceMultiModularArchitectureTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Base Url :  ${BuildConfig.BASE_URL}!",
            modifier = modifier
        )

        Text(
            text = "DB VERSION :${BuildConfig.DB_VERSION}",
            modifier = modifier
        )

        Text(
            text = "CAN CLEAR CACHE : ${BuildConfig.CAN_CLEAR_CACHE} ",
            modifier = modifier
        )

        Text(
            text = "MAP KEY : ${BuildConfig.MAP_KEY}",
            modifier = modifier
        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdvanceMultiModularArchitectureTheme {
        Greeting()
    }
}
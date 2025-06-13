package com.dellas0095.assesmobpro3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dellas0095.assesmobpro3.screen.MainScreen
import com.dellas0095.assesmobpro3.ui.theme.Assesmobpro3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assesmobpro3Theme {
                MainScreen()
            }
        }
    }
}


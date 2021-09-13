package com.example.introduccion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.introduccion.ui.theme.IntroduccionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Show(name = "this text")
        }
    }
    
    @Composable
    private fun Show(name : String) {
        MaterialTheme() {
            Column() {
                Text(text = "my text is: $name")
                Text(text = "Soy German", style = MaterialTheme.typography.h2)
            }
        }
    }

    @Preview
    @Composable
    fun RenderPreview() {
        // se renderiza toda la funcion show
        Show(name = "this text")

    }
}


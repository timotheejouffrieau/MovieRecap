package com.example.movierecap

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.movierecap.ui.theme.MovieRecapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LifeCycle", "onCreate")
        enableEdgeToEdge()
        setContent {
            MovieRecapTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Compteur(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "onDestroy")
    }
}

@Composable
fun Compteur(modifier: Modifier = Modifier) {
    var compteur by rememberSaveable { mutableIntStateOf(0) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Valeur : $compteur")
        Button(
            onClick = { compteur++ }
        ) {
            Text("+1")
        }
    }
}
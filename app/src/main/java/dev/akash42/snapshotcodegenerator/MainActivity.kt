package dev.akash42.snapshotcodegenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.akash42.snapshotannotation.Snapshot
import dev.akash42.snapshotcodegenerator.ui.theme.SnapshotCodeGeneratorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        println("whygg ${System.getProperty("MY_STRING")}")
        setContent {
            SnapshotCodeGeneratorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Snapshot(fileName = "Preview1.kt", composableName = "Greeting")
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnapshotCodeGeneratorTheme {
        Greeting("Android")
    }
}

@Snapshot(fileName = "Preview1.kt", composableName = "Greeting")
@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    SnapshotCodeGeneratorTheme {
        Greeting("Android")
    }
}
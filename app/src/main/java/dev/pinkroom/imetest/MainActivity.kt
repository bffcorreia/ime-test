package dev.pinkroom.imetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import dev.pinkroom.imetest.ui.theme.ImeTestTheme

val list = List(15) { "$it" }
const val showOpenDialog = false

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ImeTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    var showDialog by remember { mutableStateOf(false) }
                    Box(contentAlignment = Alignment.Center) {
                        if (showOpenDialog) {
                            Button(onClick = { showDialog = true }) {
                                Text(text = "Open Dialog")
                            }
                        } else TestList()
                    }
                    if (showDialog) TestDialog { showDialog = false }
                }
            }
        }
    }
}
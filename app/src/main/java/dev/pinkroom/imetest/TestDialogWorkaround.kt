package dev.pinkroom.imetest

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun TestDialogWorkaround(onDismissRequest: () -> Unit) {
    val configuration = LocalConfiguration.current
    val screenHeight = (configuration.screenHeightDp / 1.5).dp

    AlertDialog(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(0.dp, screenHeight),
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(),
        text = {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(
                        start = 12.dp,
                        top = 12.dp,
                        end = 12.dp,
                    ),
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 12.dp),
                    text = "DIALOG",
                )
                TestList()
            }
        },
        buttons = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .imePadding()
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.End,
            ) {
                TextButton(onClick = onDismissRequest) {
                    Text(text = "CANCEL")
                }
                TextButton(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 12.dp,
                    ),
                    onClick = onDismissRequest,
                ) {
                    Text(text = "CONFIRM")
                }
            }
        },
    )
}
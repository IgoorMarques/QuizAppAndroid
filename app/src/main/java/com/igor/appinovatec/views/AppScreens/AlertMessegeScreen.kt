package com.igor.appinovatec.views.AppScreens

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.igor.appinovatec.R




@Composable
fun ConfirmationDialog(
    message: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Descartar") },
        text = { Text(text = message) },
        confirmButton = {
            Button(
                onClick = onConfirm,
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.backgroundTelaSplash)),
            ) {
                Text(text = "Confirmar", color = Color.White)
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.backgroundTelaSplash))
            ) {
                Text(text = "Cancelar", color = Color.White)
            }
        }
    )
}

@Preview
@Composable
fun ver() {
    ConfirmationDialog(message = "Deseja mesmo descartar o item?", onConfirm = { /*TODO*/ }){}
}
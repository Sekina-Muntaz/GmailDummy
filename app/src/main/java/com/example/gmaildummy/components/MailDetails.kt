package com.example.gmaildummy.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun MailDetails(countryName:String){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text =countryName ,modifier = Modifier.align(Alignment.CenterHorizontally),
        textAlign = TextAlign.Center,
        fontSize = 14.sp)
    }
}
@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    MailDetails("United States 🇺🇸")
}
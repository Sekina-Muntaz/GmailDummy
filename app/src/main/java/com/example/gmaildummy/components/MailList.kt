package com.example.gmaildummy.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmaildummy.mailList
import com.example.gmaildummy.model.MailData
//import java.lang.reflect.Modifier

@Composable
fun MailList(paddingValues: PaddingValues,scrollState: ScrollState){
Box(modifier =Modifier.padding(paddingValues) ){
    LazyColumn(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()
        .scrollable(scrollState,Orientation.Vertical)){
        items(mailList){

                mailData->
                MailItem(mailData=mailData)

        }
    }
}
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MailItem(mailData: MailData,modifier: Modifier =Modifier){
    Card(modifier = Modifier.fillMaxSize().padding(bottom = 8.dp),elevation = 2.dp,onClick = {

    }
    ) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp)) {



    Card(modifier = Modifier
        .padding( 8.dp)
        .size(40.dp)
        .clip(CircleShape),backgroundColor = Color.Gray) {
        Text(text = mailData.userName[0].toString(),textAlign = TextAlign.Center,modifier = Modifier.padding(8.dp))

    }
        Column(modifier.weight(2.0f)) {
            Text(text = mailData.userName,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
            )
            Text(text = mailData.subject,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = mailData.body,
                fontSize = 14.sp,

            )

        }
        Column() {
            Text(text = mailData.timestamp)
            IconButton(onClick = { /*TODO*/ },
                modifier= Modifier
                    .size(50.dp)
                    .padding(top = 16.dp)) {
                Icon(imageVector = Icons.Outlined.Star,"Star")


            }

        }
    }
}

}
@Preview(showBackground = true)
@Composable
fun MailItemPreview(){
    MailItem(mailData = MailData(
        4,"sekina","lorem ipsum",
        "lorem ipsum sic","22:22"
    ))
}
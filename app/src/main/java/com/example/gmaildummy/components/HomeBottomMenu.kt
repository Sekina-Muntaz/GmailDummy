package com.example.gmaildummy.components

import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.gmaildummy.model.BottomMenuData

@Composable
fun HomeButtomMenu(){
    val bottomList= listOf (
        BottomMenuData.Mail,
        BottomMenuData.Meet,
        BottomMenuData.Add
    )
    BottomNavigation(backgroundColor = Color.White,contentColor = Color.Black) {
       bottomList.forEach{
           BottomNavigationItem(
               label={ Text(text = it.title)},
               alwaysShowLabel=true,
               selected = false,
               onClick = { /*TODO*/ },
            icon = { Icon(imageVector = it.icon,
                contentDescription =it.title )}
               )

       }

    }

}
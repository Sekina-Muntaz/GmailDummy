package com.example.gmaildummy.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuData(
    val icon:ImageVector,
    val title:String
){
    object Mail:BottomMenuData(
        icon = Icons.Outlined.Email,
        title = "Mail"
    )
    object  Meet:BottomMenuData(
        icon = Icons.Outlined.Person,
        title = "Meet"
    )
    object  Add:BottomMenuData(
        icon = Icons.Outlined.Add,
        title = "Add"
    )
}

package com.example.gmaildummy.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.ui.graphics.vector.ImageVector

sealed class DrawerMenuData(
    val icon:ImageVector?=null,
    val title:String?=null,
    val isDivider:Boolean=  false,
    val isHeader:Boolean=false
){
    object AllInboxes: DrawerMenuData(
        title = "All inboxes",
        icon = Icons.Outlined.AccountBox

    )
    object Primary: DrawerMenuData(
        title = "Primary",
        icon = Icons.Outlined.AccountBox

    )
    object Social: DrawerMenuData(
        title = "Social",
        icon = Icons.Outlined.AccountBox
    )
    object Divider: DrawerMenuData(
        isDivider = true
    )
    object HeaderOne: DrawerMenuData(
        isHeader = true,
        title = "All Labels"

    )

}

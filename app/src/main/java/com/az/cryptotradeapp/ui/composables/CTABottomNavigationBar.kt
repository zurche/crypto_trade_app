package com.az.cryptotradeapp.ui.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.az.cryptotradeapp.R
import com.az.cryptotradeapp.ui.theme.FullWhite

@Composable
@Preview
fun CTABottomNavigationBar(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier,
        content = {
            CTANavigationItem(drawable = R.drawable.home_ic, isSelected = true)

            CTANavigationItem(drawable = R.drawable.trending_up_ic, isSelected = false)

            CTANavigationItem(drawable = R.drawable.swap_horizontal_ic, isSelected = false)

            CTANavigationItem(drawable = R.drawable.wallet_ic, isSelected = false)
        },
        containerColor = FullWhite,
    )
}

@Composable
@Preview
private fun RowScope.CTANavigationItem(
    drawable: Int = R.drawable.home_ic, isSelected: Boolean = false
) {
    NavigationBarItem(
        icon = {
            Icon(
                painter = painterResource(drawable), contentDescription = null
            )
        },
        onClick = { },
        selected = isSelected,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Black,
            unselectedIconColor = MaterialTheme.colorScheme.secondary,
            indicatorColor = Color.White
        )
    )
}
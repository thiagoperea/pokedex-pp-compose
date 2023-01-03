package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thiagoperea.pokedexppcompose.ui.theme.AppColors

@Composable
fun DetailsTypeList() {
    LazyRow {
        val types = listOf(
            "Grass" to AppColors.grass,
            "Poison" to AppColors.poison
        )

        items(types) { type ->
            Text(
                text = type.first,
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .background(type.second, shape = RoundedCornerShape(16.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}
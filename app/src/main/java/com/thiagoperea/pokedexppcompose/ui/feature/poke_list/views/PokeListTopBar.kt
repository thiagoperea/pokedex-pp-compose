package com.thiagoperea.pokedexppcompose.ui.feature.poke_list.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thiagoperea.pokedexppcompose.R

@Composable
fun PokeListTopBar(
    onSortClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_pokeball_mini),
            contentDescription = null,
        )

        Text(
            text = "Pokédex",
            fontSize = 26.sp,
            fontWeight = FontWeight.W900,
            modifier = Modifier
                .weight(1.0f)
                .padding(horizontal = 16.dp)
        )

        IconButton(
            onClick = { onSortClick() },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_number_sort),
                contentDescription = null
            )
        }
    }
}
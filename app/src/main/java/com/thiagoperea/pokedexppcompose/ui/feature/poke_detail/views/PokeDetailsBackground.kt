package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.thiagoperea.pokedexppcompose.R

@Composable
fun PokeDetailsBackground(
    color: Color,
    showPreviousArrow: Boolean,
    onNextPressed: () -> Unit,
    onPreviousPressed: () -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color),
        horizontalAlignment = Alignment.End
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.ic_pokeball),
                contentDescription = null,
                modifier = Modifier.padding(top = 8.dp, end = 8.dp)
            )

            if (showPreviousArrow) {
                IconButton(
                    onClick = { onPreviousPressed() },
                    content = { Icon(painterResource(R.drawable.ic_chevron_left), null, tint = Color.White) },
                    modifier = Modifier.align(Alignment.BottomStart)
                )
            }

            IconButton(
                onClick = { onNextPressed() },
                content = { Icon(painterResource(R.drawable.ic_chevron_right), null, tint = Color.White) },
                modifier = Modifier.align(Alignment.BottomEnd)
            )

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(4.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
        )
    }
}
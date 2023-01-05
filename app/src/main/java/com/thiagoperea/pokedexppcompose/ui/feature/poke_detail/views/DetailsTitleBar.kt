package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thiagoperea.pokedexppcompose.R

@Composable
fun DetailsTitleBar(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
    name: String,
    id: Int
) {

    Row(
        modifier = modifier.padding(top = 24.dp, end = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { onNavigateBack() },
            content = {
                Icon(
                    painter = painterResource(R.drawable.ic_back),
                    contentDescription = null,
                    tint = Color.White
                )
            }
        )

        Text(
            text = name,
            color = Color.White,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .weight(1F)
                .padding(horizontal = 16.dp),
        )

        Text(
            text = stringResource(R.string.id_number, id.toString().padStart(3, '0')),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}
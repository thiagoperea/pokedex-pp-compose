package com.thiagoperea.pokedexppcompose.ui.feature.poke_list.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thiagoperea.pokedexppcompose.R
import com.thiagoperea.pokedexppcompose.ui.theme.AppFonts

@Composable
fun PokeListTopBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(R.drawable.ic_pokeball_mini),
            contentDescription = null,
        )

        Text(
            modifier = Modifier
                .weight(1.0f)
                .padding(horizontal = 16.dp),
            text = stringResource(R.string.pokedex),
            fontSize = 26.sp,
            fontFamily = AppFonts.poppins,
            fontWeight = FontWeight.Bold,
        )
    }
}
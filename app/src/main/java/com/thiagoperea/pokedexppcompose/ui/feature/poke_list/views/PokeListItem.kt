package com.thiagoperea.pokedexppcompose.ui.feature.poke_list.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.thiagoperea.pokedexppcompose.R
import com.thiagoperea.pokedexppcompose.data.model.PokeData
import com.thiagoperea.pokedexppcompose.ui.theme.AppColors
import com.thiagoperea.pokedexppcompose.ui.theme.AppFonts

@Composable
fun PokeListItem(
    pokeData: PokeData
) {
    val firstTypeColor = pokeData.typeList.firstOrNull()?.color ?: AppColors.lightGray

    Column(
        modifier = Modifier
            .height(112.dp)
            .width(104.dp)
            .border(1.dp, firstTypeColor, RoundedCornerShape(8.dp))
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, end = 8.dp),
            text = stringResource(R.string.id_number, pokeData.id.toString().padStart(3, '0')),
            textAlign = TextAlign.End,
            color = firstTypeColor,
            fontSize = 8.sp,
            fontFamily = AppFonts.poppins,
            fontWeight = FontWeight.Normal
        )

        AsyncImage(
            model = pokeData.officialUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.0f)
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
                .background(firstTypeColor)
                .padding(vertical = 2.dp, horizontal = 8.dp),
            text = pokeData.name,
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 10.sp,
            fontFamily = AppFonts.poppins,
            fontWeight = FontWeight.Normal
        )
    }
}
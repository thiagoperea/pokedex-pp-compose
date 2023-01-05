package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.thiagoperea.pokedexppcompose.R
import com.thiagoperea.pokedexppcompose.data.model.PokeData


@Composable
fun PokeDetailsForeground(
    onNavigateBack: () -> Unit,
    data: PokeData?,
    color: Color
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DetailsTitleBar(
            onNavigateBack = { onNavigateBack() },
            name = data?.name ?: "",
            id = data?.id ?: 0
        )

        AsyncImage(
            model = data?.officialUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(fraction = 0.5f) // square image with size beign 50% of screen's width
                .aspectRatio(1f) // aspect ratio makes the height the same as the width
                .padding(top = 24.dp)
        )

        Spacer(Modifier.height(16.dp))
        DetailsTypeList(
            typeList = data?.typeList ?: listOf()
        )

        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.about),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = color
        )

        Spacer(Modifier.height(16.dp))
        DetailsAboutContent(
            weight = data?.weight ?: 0,
            height = data?.height ?: 0,
            moves = data?.moveList ?: listOf()
        )

        Spacer(Modifier.height(16.dp))
        Text(
            text = data?.description ?: "",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )

        Spacer(Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.base_stats),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = color
        )

        Spacer(Modifier.height(16.dp))
        DetailsBaseStatsList(
            modifier = Modifier.padding(horizontal = 16.dp),
            stats = data?.stats,
            color = color
        )
    }
}
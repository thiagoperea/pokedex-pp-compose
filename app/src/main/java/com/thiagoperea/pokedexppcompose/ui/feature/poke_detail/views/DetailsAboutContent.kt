package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thiagoperea.pokedexppcompose.R

@Composable
fun DetailsAboutContent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .size(48.dp)
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        DetailsAboutContentItem(
            iconId = R.drawable.ic_weight,
            topDescription = "6,9 kg",
            bottomDescription = "Weight"
        )

        DetailsAboutDivider()

        DetailsAboutContentItem(
            iconId = R.drawable.ic_rule,
            topDescription = "0,7 m",
            bottomDescription = "Height"
        )

        DetailsAboutDivider()

        DetailsAboutContentItem(
            iconId = null,
            topDescription = "Chlorophyll\nOvergrow",
            bottomDescription = "Moves"
        )
    }
}

@Composable
fun DetailsAboutDivider() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(1.dp)
            .background(Color.Blue)
    )
}

@Composable
fun DetailsAboutContentItem(
    @DrawableRes iconId: Int?,
    topDescription: String,
    bottomDescription: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.weight(1.0f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (iconId != null) {
                Icon(
                    painter = painterResource(iconId),
                    contentDescription = null
                )
            }

            Text(
                text = topDescription,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }
        Text(
            text = bottomDescription,
            fontSize = 10.sp
        )
    }
}
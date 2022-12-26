package com.thiagoperea.pokedexppcompose.ui.feature.poke_detail.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thiagoperea.pokedexppcompose.ui.theme.PokedexComposeTheme
import com.thiagoperea.pokedexppcompose.ui.theme.grass

@Composable
fun DetailsBaseStatsItem() {
    Column(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "HP",
                color = grass,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = Modifier.widthIn(min = 28.dp)
            )

            Spacer(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .width(1.dp)
                    .fillMaxHeight()
                    .background(Color.Blue)
            )

            Text(
                text = "045",
                fontSize = 12.sp
            )

            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp)
                    .clip(RoundedCornerShape(16.dp)),
                color = grass,
                progress = 0.5f
            )
        }
    }
}

@Preview
@Composable
fun PreviewDetailsStats() {
    PokedexComposeTheme {
        Surface {
            DetailsBaseStatsItem()
        }
    }
}

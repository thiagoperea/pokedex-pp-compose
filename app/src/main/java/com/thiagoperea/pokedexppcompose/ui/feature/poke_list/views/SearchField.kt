package com.thiagoperea.pokedexppcompose.ui.feature.poke_list.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thiagoperea.pokedexppcompose.R
import com.thiagoperea.pokedexppcompose.ui.theme.lightGray

@Composable
fun SearchField() {
    val searchInput = remember { mutableStateOf("") }

    TextField(
        value = searchInput.value,
        onValueChange = { searchInput.value = it },
        textStyle = LocalTextStyle.current.copy(
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
        ),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(16.dp),
//            label = {
//
//                /**
//                 * TODO: LABEL HAS AN INTERNAL TOP PADDING.
//                 * I NEED TO CREATE A BOX WITH A TEXT INPUT FIELD + A "HINT ABOVE"
//                 *
//                 * https://stackoverflow.com/questions/69456059/jetpack-compose-textfield-label-not-staying-in-center
//                 */
//
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .wrapContentHeight(),
//                    verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.Center
//                ) {
//                    Icon(
//                        painter = painterResource(R.drawable.ic_search),
//                        contentDescription = null,
//                        modifier = Modifier.size(16.dp)
//                    )
//
//                    Text(
//                        text = "Procurar",
//                        fontSize = 12.sp
//                    )
//                }
//            },
        leadingIcon = {
            Icon(painterResource(R.drawable.ic_search), null)
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, lightGray, RoundedCornerShape(16.dp)),
    )
}
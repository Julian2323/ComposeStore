package com.example.composestore.presentation.product_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}

){



    var text by remember {
        mutableStateOf("")
    }

    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }


    Box(modifier = Modifier) {
        BasicTextField(value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(MaterialTheme.colors.surface, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)

        )

    }

}





/*
.onFocusChanged {
    isHintDisplayed = it != FocusState.Active && text.isNotEmpty()
}
)
if (isHintDisplayed) {
    Text(
        text = hint,
        color = Color.LightGray,
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 12.dp)
    )
}
 */
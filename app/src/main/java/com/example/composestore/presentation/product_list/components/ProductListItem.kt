package com.example.composestore.presentation.product_list.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.composestore.R
import com.example.composestore.domain.model.Product

@Composable
fun ProductListItem(
    product: Product,
    onItemClicked: (Product) -> Unit
) {
    Card (
        modifier = Modifier
            .padding(4.dp)
            .clickable { onItemClicked(product) },
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(8.dp)
            ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            AsyncImage(
                model =  product.image,
                contentDescription = product.title
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${product.title}",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${product.category}",
                style = MaterialTheme.typography.body2
            )
            Spacer(modifier = Modifier.height(8.dp))
            //RatingBar
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Top,
            ) {
                Icon(
                    modifier = Modifier
                        .size(18.dp)
                        .align(CenterVertically),
                    painter = painterResource(id = R.drawable.ic_star),
                    contentDescription = null,
                    tint = Color.Yellow
                )
                Text(
                    modifier = Modifier.align(CenterVertically),
                    text = "${product.rating.rate} (${product.rating.count})",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light
                )
            }
            // RatingBar
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$${product.price}",
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

}
/*CoilImage(
    request = ImageRequest.Builder(LocalContext.current)
        .data(product.image)
        .build(),
    contentDescription = product.title,
    fadeIn = true,
    modifier = Modifier
        .size(120.dp)
        .align(Alignment.CenterHorizontally)
) {
    CircularProgressIndicator(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.scale(0.5f)
    )
}
    // Coil
    implementation("io.coil-kt:coil-compose:2.2.2")

            AsyncImage(
                model =  product.image,
                contentDescription = product.title
            )
*/
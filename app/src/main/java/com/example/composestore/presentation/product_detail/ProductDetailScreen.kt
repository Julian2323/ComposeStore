package com.example.composestore.presentation.product_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.composestore.R

@Composable
fun ProductDetailScreen(
    viewModel: ProductDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.product?.let { product ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 75.dp)
            ) {
                AsyncImage(
                    model =  product.image,
                    contentDescription = product.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Inside
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = 0.dp,
                    shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp)
                ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Top
                        ) {
                            Text(
                                text = "${product.title}",
                                style = MaterialTheme.typography.h1,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            //RatingBar
                            Row(
                                modifier = Modifier,
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.Top,
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(18.dp)
                                        .align(Alignment.CenterVertically),
                                    painter = painterResource(id = R.drawable.ic_star),
                                    contentDescription = null,
                                    tint = Color.Yellow
                                )
                                Text(
                                    modifier = Modifier.align(Alignment.CenterVertically),
                                    text = "${product.rating.rate} (${product.rating.count})",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Light
                                )
                            }
                            // RatingBar
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                text = "${product.description}",
                                style = MaterialTheme.typography.h2,
                                fontWeight = FontWeight.Light,
                                fontSize = 12.sp
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                        }
                }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp, top = 50.dp),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "$${product.price}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Button(
                            onClick = {
                            },
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Black,
                                backgroundColor = Color.LightGray,
                            ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp),
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                text = "Add to Cart"
                            )
                        }
                    }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
package com.example.composestore.presentation.auth.signup

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composestore.common.Resource
import com.example.composestore.presentation.Screen
import com.example.composestore.presentation.auth.login.AuthViewModel


@Composable
fun SignupScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val authResource = viewModel?.signupFlow?.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colors.background)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Getting Started",
                style = MaterialTheme.typography.h1,
                fontWeight = FontWeight.SemiBold,
                fontSize = 22.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = "Create an account to view our amazing options!",
                style = MaterialTheme.typography.h2,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(80.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = name,
                onValueChange = {
                    name = it
                },
                label = {
                    Text(
                        text = "Name",
                        color = Color.Black
                    )
                },
                keyboardOptions = KeyboardOptions(
                    autoCorrect = true
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray,
                    textColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = email,
                onValueChange = {
                    email = it
                },
                label = {
                    Text(
                        text = "Email",
                        color = Color.Black
                    )
                },
                keyboardOptions = KeyboardOptions(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Email,
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray,
                    textColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = password,
                onValueChange = {
                    password = it
                },
                label = { Text(
                    text = "Password",
                    color = Color.Black
                )},
                keyboardOptions = KeyboardOptions(
                    autoCorrect = true,
                    keyboardType = KeyboardType.Password,
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Gray,
                    textColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Password should be at least 6 characters", color = Color.Gray)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { viewModel.signupUser(name, email, password) }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Sign Up!", color = MaterialTheme.colors.secondary)
            }
            Spacer(modifier = Modifier.height(32.dp))
            TextButton(onClick = { navController.navigate(Screen.LoginScreen.route) }) {
                Text(
                    text = buildAnnotatedString {
                        append("Already have an account?")
                        append(" ")
                        withStyle(
                            style = SpanStyle(color = MaterialTheme.colors.secondary, fontWeight = FontWeight.Bold)
                        ) {
                            append("Sign In")
                        }
                    },
                    textAlign = TextAlign.Center
                )
            }
        }
        authResource?.value?.let {
            val context = LocalContext.current
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(context, "Error Signing Up ", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    CircularProgressIndicator()
                }
                is Resource.Success -> {
                    LaunchedEffect(Unit) {
                        navController.navigate(Screen.ProductListScreen.route)
                    }
                }
            }
        }
    }
}
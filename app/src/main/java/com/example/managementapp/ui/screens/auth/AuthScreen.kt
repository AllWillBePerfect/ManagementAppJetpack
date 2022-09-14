package com.example.managementapp.ui.screens.auth

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.managementapp.R
import com.example.managementapp.ui.utils.GraphRoutes
import com.example.managementapp.ui.utils.ScreenRoutes
import com.example.managementapp.ui.theme.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AuthScreen(navController: NavController) {

    val boxSize = with(LocalDensity.current) { 300.dp.toPx() }

    ManagementAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold() {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .clip(shape = RoundedCornerShape(bottomStart = 35.dp, bottomEnd = 35.dp))
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(gradientWhiteBlue, gradientDarkBlue),
                                start = Offset(0f, 0f),
                                end = Offset(boxSize, boxSize)
                            )
                        )
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()

                ) {

                    Spacer(modifier = Modifier.height(84.dp))

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .height(190.dp)
                            .width(190.dp)
                            .clip(shape = RoundedCornerShape(51.dp))
                            .background(color = Color.White)
                    ) {
                        val painter = painterResource(id = R.drawable.box_logo)
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                painter = painter, contentDescription = "", modifier = Modifier
                                    .width(119.dp)
                                    .height(127.dp)
                            )
                            Text(
                                text = "InventApp",
                                fontSize = 30.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_regular))
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(51.dp))

                    var textFieldEmail by remember { mutableStateOf(TextFieldValue("")) }
                    TextFieldAuth(
                        value = textFieldEmail,
                        onValueChange = { textFieldEmail = it },
                        hintText = "Email",
                        icon = R.drawable.ic_email
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    var textFieldId by remember { mutableStateOf(TextFieldValue("")) }
                    TextFieldAuth(
                        value = textFieldId,
                        onValueChange = { textFieldId = it },
                        hintText = "ID",
                        icon = R.drawable.ic_user
                    )

                    Spacer(modifier = Modifier.height(39.dp))

                    Surface(
                        onClick = { navController.navigate(GraphRoutes.MainGraphRoute.route) {
                            popUpTo(ScreenRoutes.AuthScreenRoute.route) {
                                inclusive = true
                            }
                        } },
                        shape = RoundedCornerShape(10.dp),
                        color = editTextWhite,
                        border = ButtonDefaults.outlinedBorder,
                        role = Role.Button,
                        elevation = 4.dp,
                        modifier = Modifier
                            .height(43.dp)
                            .width(168.dp)

                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Войти",
                                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                fontSize = 24.sp
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_arrow_right),
                                contentDescription = ""
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                        }
                    }
                }
            }
        }
    }


}

@Composable
fun TextFieldAuth(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    hintText: String,
    @DrawableRes icon: Int
) {
    BasicTextField(value = value, onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .height(45.dp),
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = editTextWhite, shape = RoundedCornerShape(10.dp))
                    .padding(start = 16.dp, end = 48.dp)
            ) {
                if (value.text.isEmpty())
                    Text(
                        text = hintText,
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        color = editTextHint
                    )
                innerTextField()
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = icon), contentDescription = "",
                    modifier = Modifier
                        .padding(end = 15.dp)
                )
            }
        }
    )
}
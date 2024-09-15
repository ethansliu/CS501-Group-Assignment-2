package com.example.groupassignment2problem2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.groupassignment2problem2.ui.theme.GroupAssignment2Problem2Theme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GroupAssignment2Problem2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculatorApp()
                }
            }
        }
    }
}


@Composable
fun CalculatorApp() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var operator by remember { mutableStateOf("") }
    var finalResult by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(
            top = 200.dp,
            start = 35.dp,
            end = 35.dp
        )
    ) {
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Number 1") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Number 2") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { operator = "+" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.LightGray,
                ),

                ) {
                Text("+")
            }
            Button(onClick = { operator = "-" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.LightGray,
                )) {
                Text("-")
            }
            Button(onClick = { operator = "*" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.LightGray,
                )) {
                Text("*")
            }
            Button(onClick = { operator = "/" },
                   colors = ButtonDefaults.buttonColors(
                       containerColor = Color.DarkGray,
                       contentColor = Color.LightGray,
                   )) {
                Text("/")
            }
            Button(onClick = { operator = "%" },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.LightGray,
                )) {
                Text("%")

            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Operation:")
        Box(
            modifier = Modifier.border(width = 2.dp, color = Color.DarkGray)
        ) {
            Text(
                text = operator,
                modifier = Modifier.padding(horizontal = 25.dp, vertical = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val int1 = num1.toDoubleOrNull()
                val int2 = num2.toDoubleOrNull()
                if (int1 == null || int2 == null) {
                    finalResult = "Not enough numbers were inputted!"
                    return@Button
                }
                val result = when (operator) {
                    "+" -> int1 + int2
                    "-" -> int1 - int2
                    "*" -> int1 * int2
                    "/" -> {
                        if (int2==0.0) {
                            finalResult = "Can't divide by zero"
                            return@Button
                        } else {
                            int1 / int2
                        }
                    }
                    "%" -> {
                        if (int2==0.0) {
                            finalResult = "Can't modulo by zero"
                            return@Button
                        } else {
                            int1 % int2
                        }
                    }
                    else -> {
                        finalResult = "Forgot to enter an operator"
                        return@Button
                    }
                }
                finalResult = result.toString()
                num1 = ""
                num2 = ""
                operator = ""
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF9B38),
                contentColor = Color.White
            )
        ) {
            Text("Calculate")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Result:")
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier.border(width = 2.dp, color = Color.DarkGray)

            ) {
                Text(
                    text = finalResult,
                    modifier = Modifier.padding(horizontal = 25.dp, vertical = 8.dp)
                )
            }


        }
    }
}



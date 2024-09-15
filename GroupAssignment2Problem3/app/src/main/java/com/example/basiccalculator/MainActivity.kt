package com.example.basiccalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.basiccalculator.ui.theme.BasicCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicCalculatorTheme {

                //Storage field for the user to type in the OutlinedTextField (dynamically updates)
                var field  = remember {
                    mutableStateOf("")
                }

                //Storage field for the first number
                var store = remember {
                    mutableStateOf("")
                }

                //Storage field for the operation
                var operation = remember {
                    mutableStateOf("")
                }

                //Main column organizer
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    //Top text field
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors( unfocusedTextColor = Color.Black),
                            value = field.value,
                            onValueChange = { text ->
                                field.value = text
                            },
                            label = { Text("Result")}
                        )
                    }
                    //(1,2,3,+,*)
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
//                                .fillMaxWidth(0.2f),
                            onClick = { field.value = field.value + "1"}) {
                            Text(text="1")
                        }
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
//                                .fillMaxWidth(0.2f),
                            onClick = { field.value = field.value + "2"}) {
                            Text(text="2")
                        }
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
//                                .fillMaxWidth(0.2f),
                            onClick = { field.value = field.value + "3"  }) {
                            Text(text="3")
                        }
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
//                                .fillMaxWidth(0.2f),
                            onClick = {
                                store.value = field.value
                                field.value = ""
                                operation.value = "+"
                            }) {
                            Text(text="+")
                        }
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                .padding(0.dp, 0.dp, 0.dp, 0.dp)
//                                .fillMaxWidth(0.2f),
                            onClick = {
                                store.value = field.value
                                field.value = ""
                                operation.value = "*"
                            }) {
                            Text(text="*")
                        }
                    }
                    //(4,5,6,-,/)
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                    .fillMaxWidth(0.2f),
                            onClick = { field.value = field.value + "4"  }) {
                            Text(text="4")
                        }
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                .fillMaxWidth(0.2f),
                            onClick = { field.value = field.value + "5"  }) {
                            Text(text="5")
                        }
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                .fillMaxWidth(0.2f),
                            onClick = { field.value = field.value + "6"  }) {
                            Text(text="6")
                        }
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                .fillMaxWidth(0.2f),
                            onClick = {
                                store.value = field.value
                                field.value = ""
                                operation.value = "-"
                            }) {
                            Text(text="-")
                        }
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                .fillMaxWidth(0.2f),
                            onClick = {
                                store.value = field.value
                                field.value = ""
                                operation.value = "/"
                            }) {
                            Text(text="/")
                        }
                    }
                    //(7,8,9,SQRT)
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                    .fillMaxWidth(0.2f),
                            onClick = { field.value = field.value + "7" }) {
                            Text(text="7")
                        }
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                .fillMaxWidth(0.2f),
                            onClick = { field.value = field.value + "8"  }) {
                            Text(text="8")
                        }
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                .fillMaxWidth(0.2f),
                            onClick = { field.value = field.value + "9" }) {
                            Text(text="9")
                        }
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                .fillMaxWidth(0.2f),
                            onClick = {
                                store.value = field.value
                                field.value = Math.sqrt(field.value.toDouble()).toString()
                            }) {
                            Text(text="SQRT")
                        }
                    }
                    //(0,.,=)
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                    .fillMaxWidth(0.2f),
                            onClick = { field.value = field.value + "0" }) {
                            Text(text="0")
                        }
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                .fillMaxWidth(0.2f),
                            onClick = { field.value = field.value + "." }) {
                            Text(text=".")
                        }
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                .fillMaxWidth(0.4f),
                            onClick = {
                                var status = true
                                var res : Double = 0.0
                                var y : Double = 0.0
                                var x : Double = 0.0

                                //A bunch of error handling
                                if(field.value == "") {
                                    status = false
                                }
                                if(store.value == "") {
                                    status = false
                                }
                                try {
                                    x = store.value.toDouble()
                                    status = true
                                } catch (e: NumberFormatException) {
                                    status = false
                                }
                                try {
                                    y = field.value.toDouble()
                                    status = true
                                } catch (e: NumberFormatException) {
                                    status = false
                                }
                                if (y == 0.0) {
                                    status = false
                                }

                                //Actual calculation when '=' is pressed
                                if (status) {
                                    if (operation.value == "+") {
                                        res = x + y
                                    } else if (operation.value == "-") {
                                        res = x - y
                                    } else if (operation.value == "*") {
                                        res = x * y
                                    } else if (operation.value == "/") {
                                        res = x / y
                                    }
                                    field.value = res.toString()
                                } else {
                                    field.value = "Error"
                                }
                            }) {
                            Text(text="=")
                        }
                    }
                    //Dummy filler row
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {

                    }
                    //Contains the clear button and the backspace button
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                    .fillMaxWidth(0.2f),
                            onClick = { field.value = "" }) {
                            Text(text="C")
                        }
                        ElevatedButton(
                            shape = RoundedCornerShape(15.dp),
                            border = BorderStroke(1.dp, Color.Black),
//                            modifier = Modifier
//                                    .fillMaxWidth(0.2f),s
                            onClick = { field.value = field.value.substring(0, field.value.length - 1)}) {
                            Text(text="<")
                        }
                    }
                }
            }
        }
    }
}


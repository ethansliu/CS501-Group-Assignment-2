package com.example.hw2gp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groupassignment2problem1.ui.theme.GroupAssignment2Problem1Theme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    //setting default variable and declaring variable
    private var celsius = 0
    private var fahrenheit = 32
    private var fahrenheitSliderPosition = 32
    private var message = "Water Freezes."

    //use JetPack Compose for design
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroupAssignment2Problem1Theme {
                TemperatureConverter()
            }
        }
    }


    @Composable
    fun TemperatureConverter() {
        //create background for the app. It looks gradient. Use RGB to change the color depending on the temperature
        val backgroundColor = Color(
            red = celsius / 100f,
            green = 0f,
            blue = (100 - celsius) / 100f
        )
        Column(
            modifier = Modifier
                .background(backgroundColor)

                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Celsius", fontSize = 30.sp,  color = Color.White)
            Slider(
                //logic for Celsius. It calculates based on the number from Celsius and change the number for farenheit
                //and change the message based on the temperature
                value = celsius.toFloat(),
                onValueChange = {
                    celsius = it.roundToInt()
                    fahrenheit = (celsius * 9 / 5) + 32
                    fahrenheitSliderPosition = fahrenheit
                    message = updateMEssage(celsius)
                    setContent { GroupAssignment2Problem1Theme { TemperatureConverter() } }
                },
                //set the range for bar from 0 to 100
                valueRange = 0f..100f,
                //divide it by 100 so each steps are 1 celsius degree
                steps = 100,
                modifier = Modifier.fillMaxWidth()
            )

            //set the Text that will be displayed.
            Text(text = "${celsius}°C", fontSize = 18.sp, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Fahrenheit", fontSize = 30.sp, color = Color.White)

            //Same as celsius. Take data from farenheit and convert it and change it to Celsius
            //If farenheit goes below 32, just set it back to 32.

            Slider(
                value = fahrenheitSliderPosition.toFloat(),
                onValueChange = {
                    val newValue = it.roundToInt()
                    if (newValue >= 32) {
                        fahrenheit = newValue
                        fahrenheitSliderPosition = newValue
                        celsius = ((fahrenheit - 32) * 5 / 9)
                        message = updateMEssage(celsius)
                    } else {
                        fahrenheitSliderPosition = 32
                    }
                    setContent { GroupAssignment2Problem1Theme { TemperatureConverter() } }
                },
                //Set the range from 0 to 212. And make it steps 212 so each counts as 1 farenheit
                valueRange = 0f..212f,
                steps = 212,
                modifier = Modifier.fillMaxWidth()
            )

            Text(text = "${fahrenheit}°F", fontSize = 18.sp, color = Color.White)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = message, fontSize = 20.sp, color = Color.White, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }
    }
    //Interesting facts about temperature related with water.

    fun updateMEssage(celsius: Int): String {
        if (celsius >= 1 && celsius <= 4) {
            return "Water starts to form ice crystals and begins freezing"
        } else if (celsius >= 5 && celsius <= 10) {
            return "Cool room temperature"
        } else if (celsius >= 11 && celsius <= 15) {
            return "Cool and brisk temperature"
        } else if (celsius >= 16 && celsius <= 20) {
            return "Mild and comfortable temperature"
        } else if (celsius >= 21 && celsius <= 30) {
            return "Warm weather"
        } else if (celsius >= 31 && celsius <= 90) {
            return "Getting Hotter"
        } else if (celsius >= 91 && celsius <= 99) {
            return "Water starts to boil"
        } else {
            return "Water boils"
        }
    }
}



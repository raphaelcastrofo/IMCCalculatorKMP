package com.example.icmkmp.android

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.icmkmp.IMCCalculator


@Composable

fun IMCCalculatorScreen(modifier: Modifier = Modifier){
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Insira seu peso (Kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier=Modifier.height(16.dp))
        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text("Insira sua Altura (m)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier=Modifier.height(16.dp))
        Button(
            onClick = {
                val weightValue = weight.toDoubleOrNull() ?: 0.0
                val heightValue = height.toDoubleOrNull() ?: 0.0
                val imc = IMCCalculator.calculatorIMC(weight = weightValue, height = heightValue)
                val classification = IMCCalculator.classifyIMC(imc)

                result = "IMC: %.2f\nClassification: %s".format(imc,classification)
            },
            modifier = Modifier.fillMaxWidth()

        ){
            Text("Calcule o IMC")
        }
        Spacer(modifier=Modifier.height(16.dp))
        Text(result)
    }

}

@Preview
@Composable

private fun IMCCalculatorScreenPreview(){
    IMCCalculatorScreen(Modifier)
}
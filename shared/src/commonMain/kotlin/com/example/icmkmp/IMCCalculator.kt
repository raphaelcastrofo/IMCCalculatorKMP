package com.example.icmkmp

object IMCCalculator {
    fun calculatorIMC(weight: Double, height: Double): Double {
        return if (height>0) weight / (height * height) else 0.0
    }
    fun classifyIMC(imc: Double): String {
        return when {
            imc < 18.5 -> "ABAIXO DO PESO"
            imc in 18.5..24.9 -> "PESO NORMAL"
            imc in 25.0..29.9 -> "SOBRE PESO"
            imc in 30.0..34.9 -> "OBESIDADE GRAU I"
            imc in 35.0..39.9 -> "OBESISDADE GRAU II"
            else -> "OBESIDADE GRAU III"
        }
    }
}
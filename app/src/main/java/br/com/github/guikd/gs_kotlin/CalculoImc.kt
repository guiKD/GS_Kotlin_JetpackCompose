package br.com.github.guikd.gs_kotlin

import kotlin.math.pow

fun calcularImc(altura: Double, peso: Double): Double {
    return peso / (altura / 100).pow(2.0)
}
package com.bridgelabz.quantitiesmanager.model.enums

enum class Weight(
    val kilogramConverter: Double,
    val gramConverter: Double,
    val tonConverter: Double
) {

    KILOGRAM(1.0, 1000.0, 0.001),
    GRAM(0.001, 1.0, 0.000001),
    TONNE(1000.0, 907184.74, 1.0),
}

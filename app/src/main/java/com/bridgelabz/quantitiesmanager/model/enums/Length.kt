package com.bridgelabz.quantitiesmanager.model.enums

enum class Length(
    val inchConverter: Double,
    val feetConverter: Double,
    val yardConverter: Double,
    val centiMeterConverter: Double
) {
    INCH(1.0, 0.0833, 0.0277778, 2.54),

    FEET(12.0, 1.0, 0.333333, 30.48),
    YARD(36.0, 3.0, 0.333333, 91.44),
    CENTIMETER(0.393701, 0.0328084, 0.0109361, 1.0)

}

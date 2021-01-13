package com.bridgelabz.quantitiesmanager.model.enums



enum class Temperature(val celsiusConverter: Double, val fahrenheitConverter: Double) {

    CELSIUS(1.0, 33.8),
    FAHRENHEIT(-17.22, 1.0);
}

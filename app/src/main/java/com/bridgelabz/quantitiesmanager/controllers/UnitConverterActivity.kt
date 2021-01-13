package com.bridgelabz.quantitiesmanager.controllers

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.bridgelabz.quantitiesmanager.R
import com.bridgelabz.quantitiesmanager.model.enums.Length
import com.bridgelabz.quantitiesmanager.model.enums.Temperature
import com.bridgelabz.quantitiesmanager.model.enums.Weight

class UnitConverterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_converter)


        val quantityTypeSpinner: Spinner = findViewById<Spinner>(R.id.quantityType)

        quantityTypeSpinner.onItemSelectedListener = createListenerForQuantityType()
    }

    private fun createListenerForQuantityType(): AdapterView.OnItemSelectedListener {
        return object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val quantityType: String = resources.getStringArray(R.array.quantities)[position]
                val adapter = when (quantityType) {
                    "Weight" -> {
                        ArrayAdapter.createFromResource(
                            baseContext,
                            R.array.weight,
                            android.R.layout.simple_spinner_dropdown_item
                        )
                    }
                    "Length" -> {
                        ArrayAdapter.createFromResource(
                            baseContext,
                            R.array.length,
                            android.R.layout.simple_spinner_dropdown_item
                        )
                    }
                    "Temperature" -> {
                        ArrayAdapter.createFromResource(
                            baseContext,
                            R.array.temperature,
                            android.R.layout.simple_spinner_dropdown_item
                        )
                    }

                    else -> null
                }
                adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                findViewById<Spinner>(R.id.fromUnit).adapter = adapter
                findViewById<Spinner>(R.id.toUnit).adapter = adapter
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    fun convertQuantity(view : View) {

        val quantityType: Spinner = findViewById<Spinner>(R.id.quantityType)

        val fromUnitSpinner: Spinner = findViewById<Spinner>(R.id.fromUnit)
        val fromInput : EditText = findViewById<EditText>(R.id.input1)

        val toUnitSpinner: Spinner = findViewById<Spinner>(R.id.toUnit)
        val toResult : EditText = findViewById<EditText>(R.id.input2)

        val fromSelectedUnit : String = fromUnitSpinner.selectedItem.toString()
        val toSelectedUnit : String = toUnitSpinner.selectedItem.toString()
        val fromInputValue : Double = fromInput.text.toString().toDouble()

        Log.i("Convert", "From Selected Unit: $fromSelectedUnit, " +
                "To Selected Unit : $toSelectedUnit, Input value : $fromInputValue")

        when(quantityType.selectedItem) {
            "Length" -> {
                val fromUnit = Length.valueOf(fromSelectedUnit)
                when(Length.valueOf(toSelectedUnit)) {
                    Length.INCH -> toResult.setText("${fromInputValue * fromUnit.inchConverter}")
                    Length.CENTIMETER -> toResult.setText("${fromInputValue * fromUnit.centiMeterConverter}")
                    Length.FEET -> toResult.setText("${fromInputValue * fromUnit.feetConverter}")
                    Length.YARD -> toResult.setText("${fromInputValue * fromUnit.yardConverter}")
                }
            }
            "Weight" -> {
                val fromUnit = Weight.valueOf(fromSelectedUnit)
                when(Weight.valueOf(toSelectedUnit)) {
                    Weight.GRAM -> toResult.setText("${fromInputValue * fromUnit.gramConverter}")
                    Weight.KILOGRAM -> toResult.setText("${fromInputValue * fromUnit.kilogramConverter}")
                    Weight.TONNE -> toResult.setText("${fromInputValue * fromUnit.tonConverter}")
                }
            }
            "Temperature" -> {
                val fromUnit = Temperature.valueOf(fromSelectedUnit)
                when(Temperature.valueOf(toSelectedUnit)) {
                    Temperature.CELSIUS -> toResult.setText("${fromInputValue * fromUnit.celsiusConverter}")
                    Temperature.FAHRENHEIT -> toResult.setText("${fromInputValue * fromUnit.fahrenheitConverter}")
                }
            }
        }
    }

}

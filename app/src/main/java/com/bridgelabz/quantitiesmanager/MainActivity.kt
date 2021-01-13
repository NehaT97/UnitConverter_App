package com.bridgelabz.quantitiesmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bridgelabz.quantitiesmanager.controllers.UnitConverterActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showUnitConverter(view: View) {

        val intent = Intent(this,UnitConverterActivity::class.java)
        startActivity(intent)
    }


}
package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private var datePlaceholder: TextView? = null
    private var dateInMinutesPlaceholder: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.select_date_btn)
        datePlaceholder = findViewById(R.id.date_placeholder)
        dateInMinutesPlaceholder = findViewById(R.id.in_minutes_placeholder)

        btnDatePicker.setOnClickListener{
            clickDatePicker()
        }
    }

    private fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd =  DatePickerDialog(this,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
//                Toast.makeText(this, "DatePickerWorks! Selected Date: ${1+selectedMonth}/${selectedDayOfMonth}/$selectedYear", Toast.LENGTH_SHORT).show()
                val selectedDate = "${selectedMonth+1}/$selectedDayOfMonth/$selectedYear"
                datePlaceholder?.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                theDate?.let{
                    val selectedDateInMinutes = theDate.time / 60000

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                    currentDate?.let{
                        val currentDateInMinutes = currentDate.time / 60000

                        val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                        dateInMinutesPlaceholder?.text = differenceInMinutes.toString()
                    }
                }
            },
            year, month, day)
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()


    }
}
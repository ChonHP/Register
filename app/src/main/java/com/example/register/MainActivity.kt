package com.example.register

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private val calendar = Calendar.getInstance()
    private val year = calendar.get(Calendar.YEAR)

    private val month = calendar.get(Calendar.MONTH)
    private val day = calendar.get(Calendar.DAY_OF_MONTH)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val firstName = findViewById<EditText>(R.id.editText)
        val lastName = findViewById<EditText>(R.id.edt2)
        val email = findViewById<EditText>(R.id.edt5)
        val address = findViewById<EditText>(R.id.editText4)
        var genderText: String = ""
        val dateOfBirth = findViewById<TextView>(R.id.editText2)

        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val gender = findViewById<RadioGroup>(R.id.radioGroup)
        
        gender.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = findViewById<RadioButton>(checkedId)
            genderText = radioButton.text.toString()
        }



        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            dateOfBirth.text = "" + dayOfMonth + " " + monthOfYear + ", " + year
        }, year, month, day)

        findViewById<Button>(R.id.selectDate).setOnClickListener {
            dpd.show()
        }

        findViewById<Button>(R.id.submit).setOnClickListener {
            if (firstName.text.toString() == "" || lastName.text.toString() == "" || email.text.toString() == "" || address.text.toString() == ""
                || !checkBox.isChecked || genderText == "" || dateOfBirth.text == "Birthday"){
                Toast.makeText(this, "Không được để trống các trường", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_LONG).show()
            }
        }
    }
}
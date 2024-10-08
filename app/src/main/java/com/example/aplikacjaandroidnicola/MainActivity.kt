package com.example.aplikacjaandroidnicola

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aplikacjaandroidnicola.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.confirmButton.setOnClickListener {
            val name = binding.nameEditText.text.toString().trim()
            val lastName = binding.nameEditText2.text.toString().trim()
            val gender = when {
                binding.radioButton11.isChecked -> "mężczyzna"
                binding.radioButton12.isChecked -> "kobieta"
                binding.radioButton13.isChecked -> "inna"
                else -> ""
            }
            val isAdult = binding.checkBox3.isChecked


            val message = when {
                name.isEmpty() -> "Proszę wpisać imię"
                lastName.isEmpty() -> "Proszę wpisać nazwisko"
                gender.isEmpty() -> "Proszę wybrać płeć"
                !isAdult -> "Proszę potwierdzić, że jesteś pełnoletni"
                else -> "Imię: $name\nNazwisko: $lastName\nPłeć: $gender\nPełnoletni: Tak"
            }


            binding.textView2.text = message
        }
    }
}

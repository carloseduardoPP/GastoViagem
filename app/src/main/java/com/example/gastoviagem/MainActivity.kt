package com.example.gastoviagem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.bt_calcular) {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        return (binding.etDistancia.text.toString() != ""
                && binding.etPrice.text.toString() != ""
                && binding.etAutonomia.text.toString().toFloat() != 0f
                )
    }

    private fun calculate() {

        if (isValid()) {
            val distance = binding.etDistancia.text.toString().toFloat()
            val price = binding.etPrice.text.toString().toFloat()
            val autonomy = binding.etAutonomia.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            binding.tvTotal.text = "R\$ ${"%.2f".format(totalValue)}"
        } else {
             Toast.makeText(this, getString(R.string.exception), Toast.LENGTH_SHORT).show()

        }
    }
}


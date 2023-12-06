package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_Classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /* TABELA IMC
    Menor que 18,5	Baixo peso
    De 18,5 a 24,9	Peso normal
    De 25 a 29,9	Sobrepeso
    De 30 a 34,9	Obesidade grau I
    De 35 a 39.9	Obesidade grau II
    Igual ou maior que 40	Obesidade grau III
    */

        var classificacao = if (result < 18.5f) {
            "BAIXO PESO"
        } else if (result < 24.9f) {
            "PESO NORMAL"
        } else if (result < 29.9f) {
            "SOBREPESO"
        } else if (result < 34.9f) {
            "OBESIDADE GRAU I"
        } else if (result < 39.9f) {
            "OBESIDADE GRAU II"
        } else {
            "OBESIDADE GRAU III"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            finish()
            return super.onOptionsItemSelected(item)
        }
}
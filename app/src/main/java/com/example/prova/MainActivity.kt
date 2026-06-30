package com.example.prova

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etOperador: EditText
    private lateinit var etLinha: EditText
    private lateinit var tvPecas: TextView
    private lateinit var btnIniciar: Button
    private lateinit var btnRegistrar: Button
    private lateinit var btnFinalizar: Button

    private var contadorPecas = 0
    private var tempoInicio: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etOperador = findViewById(R.id.etOperador)
        etLinha = findViewById(R.id.etLinha)
        tvPecas = findViewById(R.id.tvPecas)
        btnIniciar = findViewById(R.id.btnIniciar)
        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnFinalizar = findViewById(R.id.btnFinalizar)

        btnIniciar.setOnClickListener {
            tempoInicio = System.currentTimeMillis()
            etOperador.isEnabled = false
            etLinha.isEnabled = false
            btnRegistrar.isEnabled = true
            btnIniciar.isEnabled = false
        }

        btnRegistrar.setOnClickListener {
            contadorPecas++
            tvPecas.text = "Peças: $contadorPecas"
        }

        btnFinalizar.setOnClickListener {
            val tempoFim = System.currentTimeMillis()
            val tempoTotalMs = tempoFim - tempoInicio

            val taktTime = if (contadorPecas > 0) {
                (tempoTotalMs / 1000.0) / contadorPecas
            } else {
                0.0
            }

            val intent = Intent(this, RelatorioActivity::class.java)
            intent.putExtra("operador", etOperador.text.toString())
            intent.putExtra("linha", etLinha.text.toString())
            intent.putExtra("pecas", contadorPecas)
            intent.putExtra("tempoTotalMs", tempoTotalMs)
            intent.putExtra("taktTime", taktTime)
            startActivity(intent)
        }
    }
}
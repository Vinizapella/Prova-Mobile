package com.example.prova

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RelatorioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relatorio)

        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val btnNovaProducao = findViewById<Button>(R.id.btnNovaProducao)

        val operador = intent.getStringExtra("operador") ?: ""
        val linha = intent.getStringExtra("linha") ?: ""
        val pecas = intent.getIntExtra("pecas", 0)
        val tempoTotalMs = intent.getLongExtra("tempoTotalMs", 0)
        val taktTime = intent.getDoubleExtra("taktTime", 0.0)

        val totalSegundos = tempoTotalMs / 1000
        val minutos = totalSegundos / 60
        val segundos = totalSegundos % 60

        val texto = """
            Operador: ${operador.uppercase()}
            Linha: ${linha.uppercase()}
            Peças produzidas: $pecas
            Tempo total: ${minutos}min ${segundos}s
            Takt time médio: ${String.format("%.2f", taktTime)} s/peça
        """.trimIndent()

        tvResultado.text = texto

        btnNovaProducao.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}
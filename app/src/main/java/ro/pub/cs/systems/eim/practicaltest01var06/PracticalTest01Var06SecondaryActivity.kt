package ro.pub.cs.systems.eim.practicaltest01var06


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var06SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var06_secondary)

        val nr = intent.getStringArrayExtra("numbers") ?: arrayOf()
        val casute = intent.getIntExtra("checked", 0)
        val faraJoker = nr.filter { it != "*" }
        val castiguri = faraJoker.distinct().size <= 1
        val gain = if (castiguri) {
            when (casute) {
                0 -> 100
                1 -> 50
                2 -> 10
                else -> 0
            }
        } else {
            0
        }

        val gainedEditText = findViewById<EditText>(R.id.gained)
        if (castiguri) {
            gainedEditText.setText("Gained $gain")
        } else {
            gainedEditText.setText("")
        }
        findViewById<Button>(R.id.ok).setOnClickListener {
            val result = Intent()
            result.putExtra("gain", gain)
            setResult(RESULT_OK, result)
            finish()
        }

    }
}


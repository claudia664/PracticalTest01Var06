package ro.pub.cs.systems.eim.practicaltest01var06

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var06MainActivity : AppCompatActivity() {

    private lateinit var text: List<TextView>
    private lateinit var hold: List<CheckBox>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var06_main)
        text = listOf(
            findViewById(R.id.text1),
            findViewById(R.id.text2),
            findViewById(R.id.text3)
        )
        hold = listOf(
            findViewById(R.id.hold1),
            findViewById(R.id.hold2),
            findViewById(R.id.hold3)
        )

        findViewById<Button>(R.id.random).setOnClickListener {
            for (i in 0..2) {
                if (!hold[i].isChecked) {
                    text[i].text = listOf("1", "2", "3", "*").random()
                }
            }
        }

        findViewById<Button>(R.id.play).setOnClickListener {
            val values = text.map { it.text.toString() }
            val mesaj = values.joinToString(" ")
            Toast.makeText(this, mesaj, Toast.LENGTH_SHORT).show()

        }

    }
}
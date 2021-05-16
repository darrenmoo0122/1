package gm.pu.edu.tw.a0510

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generate()

        random.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                generate()
            }
        })
        submit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                intent = Intent(this@MainActivity, answer::class.java).apply {

                    if (plus.text == "+") {
                        putExtra("answer", answer.text.toString().toDouble())
                        putExtra(
                            "correct",
                            (x.text.toString().toDouble() + y.text.toString().toDouble())
                        )
                    } else if (plus.text == "-") {
                        putExtra("answer", answer.text.toString().toDouble())
                        putExtra(
                            "correct",
                            (x.text.toString().toDouble() - y.text.toString().toDouble())
                        )
                    } else if (plus.text == "x") {
                        putExtra("answer", answer.text.toString().toDouble())
                        putExtra(
                            "correct",
                            (x.text.toString().toDouble() * y.text.toString().toDouble())
                        )
                    }
                    else if (plus.text == "/") {
                        val ansnum = (answer.text.toString().toDouble())
                        val correctnum = (x.text.toString().toDouble() / y.text.toString().toDouble())

                        putExtra("answer", ansnum)
                        putExtra("correct", correctnum)
                    }
                }
                startActivity(intent)
            }
        })
    }

    fun generate() {
        val ops = arrayOf('+', '-', 'x', '/')
        val i = (0..3).random()
        val ranx = (1..100).random()
        val rany = (1..100).random()
        x.text = ranx.toString()
        y.text = rany.toString()
        plus.text = ops[i].toString()
    }
}
package gm.pu.edu.tw.a0510

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_answer.*
import kotlinx.android.synthetic.main.activity_main.*

class answer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        val intent=getIntent()
        val your: Double = intent.getDoubleExtra("answer",0.0)
        val correct:Double=intent.getDoubleExtra("correct",0.0)
        val cf=String.format("%.1f",correct)

        yourans.text=your.toString()
        cans.text= cf
        if(cans.text!=yourans.text){
            tf.text="錯誤"
        }
        else tf.text="正確"

        bck.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
            }
        })
    }
}
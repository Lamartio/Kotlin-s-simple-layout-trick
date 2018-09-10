package io.lamart.layout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LinearLayout(this) layout {

            layout.orientation = LinearLayout.VERTICAL
            layout.gravity = Gravity.CENTER

            +textView {
                text = "hello"
            }

            +frameLayout layout {

                +button {
                    text = "click me"
                    setOnClickListener {
                        // ...
                    }
                }

            }

        })
    }

}


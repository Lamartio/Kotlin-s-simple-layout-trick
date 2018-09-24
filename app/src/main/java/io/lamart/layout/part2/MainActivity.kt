package io.lamart.layout.part2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.LinearLayout
import io.lamart.layout.part1.textView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LinearLayout(this).layout(User.asDataSource()) {

            layout.orientation = LinearLayout.VERTICAL
            layout.gravity = Gravity.CENTER

            +textView {
                bind { text = "$name: $age" }
            }

            // ...

        })
    }

}


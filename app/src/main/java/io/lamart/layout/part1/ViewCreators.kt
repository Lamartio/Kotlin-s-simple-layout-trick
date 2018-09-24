package io.lamart.layout.part1

import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView

val Layout<*>.textView: TextView get() = TextView(context)
val Layout<*>.button: Button get() = Button(context)
val Layout<*>.frameLayout: FrameLayout get() = FrameLayout(context)
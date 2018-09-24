package io.lamart.layout.part1

import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import android.view.ViewParent
import java.util.*

infix fun <V : ViewGroup> V.layout(block: Layout<V>.() -> Unit): V =
        also { Layout(it).run(block) }

open class Layout<V : ViewGroup>(val layout: V) : ViewManager by layout, ViewParent by layout {

    val context = layout.context

    operator fun <V : View> V.unaryPlus(): V =
            apply(layout::addView)

    operator fun <V : View> V.unaryMinus(): V =
            also(layout::removeView)


    operator fun <V : View> V.invoke(block: V.() -> Unit): V =
            also { block(it) }
}

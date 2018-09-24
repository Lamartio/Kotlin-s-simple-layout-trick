package io.lamart.layout.part2

import android.view.ViewGroup
import io.lamart.layout.part1.Layout
import io.reactivex.Observable
import io.reactivex.functions.Consumer

fun <T, V : ViewGroup> V.layout(observable: Observable<T>, block: BindableLayout<T, V>.() -> Unit): V =
        also { BindableLayout(it, observable).run(block) }

typealias Observer<T> = T.(T) -> Unit

open class BindableLayout<T, V : ViewGroup>(
        layout: V,
        private val observable: Observable<T>
) : Layout<V>(layout) {

    init {
        layout.addOnAttachStateChangeListener(DisposableOnAttachStateChangeListener {
            observable.subscribe(observers)
        })
    }

    private val observers = Observers()

    fun bind(observer: Observer<T>) {
        observers.add(observer)
    }

    private inner class Observers : ArrayList<Observer<T>>(), Consumer<T> {

        override fun accept(value: T) =
                forEach { observer -> observer(value, value) }

    }

}


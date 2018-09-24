package io.lamart.layout.part2

import android.view.View
import io.reactivex.disposables.Disposable

class DisposableOnAttachStateChangeListener(
        private val onViewAttachedToWindow: (view: View) -> Disposable
) : View.OnAttachStateChangeListener {

    private var disposable: Disposable? = null

    override fun onViewAttachedToWindow(view: View) {
        disposable = onViewAttachedToWindow.invoke(view)
    }

    override fun onViewDetachedFromWindow(view: View) {
        disposable?.dispose()
    }

}
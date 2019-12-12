package com.raywenderlich.android.creaturemon.preseneter

import java.lang.ref.WeakReference

abstract class Presenter<V> {
    private var view: WeakReference<V>? = null

    fun setView(view: V) {
        this.view = WeakReference(view)
    }

    fun getView(): V? = view?.get()
}
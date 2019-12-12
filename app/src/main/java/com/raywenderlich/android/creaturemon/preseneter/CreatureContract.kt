package com.raywenderlich.android.creaturemon.preseneter

import androidx.constraintlayout.widget.ConstraintAttribute

interface CreatureContract {
    interface presenter {
        fun updateName(name: String)
        fun attributeSelected(attributeType: ConstraintAttribute.AttributeType, position: Int)
        fun drawableSelected(drawable: Int)
        fun isDrawable(): Boolean
    }

    interface View
}
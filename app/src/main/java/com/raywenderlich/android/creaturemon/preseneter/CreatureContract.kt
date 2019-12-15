package com.raywenderlich.android.creaturemon.preseneter

import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintAttribute
import com.raywenderlich.android.creaturemon.model.AttributeType

interface CreatureContract {
    interface presenter {
        fun updateName(name: String)
        fun attributeSelected(attributeType: AttributeType, position: Int)
        fun drawableSelected(drawable: Int)
        fun isDrawableSelected(): Boolean
    }

    interface View {
        fun showHitPoints(hitPoints: String)
        fun showAvatarDrawable(@DrawableRes resourceId: Int)
    }
}
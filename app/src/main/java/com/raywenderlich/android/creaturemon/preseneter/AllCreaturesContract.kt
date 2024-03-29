package com.raywenderlich.android.creaturemon.preseneter

import androidx.lifecycle.LiveData
import com.raywenderlich.android.creaturemon.model.Creature

interface AllCreaturesContract {
    interface Presenter {
        fun getAllCreatures(): LiveData<List<Creature>>
        fun clearAllCreatures()
    }
    interface View {
        fun showCreaturesCleared()
    }
}
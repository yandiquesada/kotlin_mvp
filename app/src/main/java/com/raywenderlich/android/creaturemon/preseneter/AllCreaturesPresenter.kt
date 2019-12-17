package com.raywenderlich.android.creaturemon.preseneter

import androidx.lifecycle.LiveData
import com.raywenderlich.android.creaturemon.model.Creature
import com.raywenderlich.android.creaturemon.model.CreatureRepository
import com.raywenderlich.android.creaturemon.model.room.RoomRepository

class AllCreaturesPresenter(private val creatureRepository: CreatureRepository = RoomRepository()): BasePresenter<AllCreaturesContract.View>(), AllCreaturesContract.Presenter {

    override fun getAllCreatures(): LiveData<List<Creature>> {
        return creatureRepository.getAllCreatures()
    }

    override fun clearAllCreatures() {
        creatureRepository.clearAllCreatures()
        getView()?.showCreaturesCleared()
    }
}
package com.raywenderlich.android.creaturemon.preseneter

import androidx.constraintlayout.widget.ConstraintAttribute
import com.raywenderlich.android.creaturemon.model.*
import com.raywenderlich.android.creaturemon.model.room.RoomRepository
import kotlinx.android.synthetic.main.activity_creature.*

class CreaturePresenter(private val creatureGenerator: CreatureGenerator = CreatureGenerator(),
                        private val creatureRepository: CreatureRepository = RoomRepository()): BasePresenter<CreatureContract.View>(), CreatureContract.presenter {

    private lateinit var creature: Creature

    private var name = ""
    private var intelligence = 0
    private var strength = 0
    private var endurance = 0
    private var drawable = 0

    private fun updateCreature() {
        val creatureAttributes = CreatureAttributes(intelligence, strength, endurance)
        creature = creatureGenerator.generateCreature(creatureAttributes, name, drawable)

        getView()?.showHitPoints(creature.hitPoints.toString())
    }

    override fun updateName(name: String) {
        this.name = name
        updateCreature()
    }

    override fun attributeSelected(attributeType: AttributeType, position: Int) {
        when(attributeType) {
            AttributeType.INTELLIGENCE ->
                intelligence = AttributeStore.INTELLIGENCE[position].value
            AttributeType.STRENGTH ->
                strength = AttributeStore.STRENGTH[position].value
            AttributeType.ENDURANCE ->
                endurance = AttributeStore.ENDURANCE[position].value
        }
        updateCreature()
    }

    override fun drawableSelected(drawable: Int) {
        this.drawable = drawable
        this.getView()?.showAvatarDrawable(drawable)
        updateCreature()
    }

    override fun isDrawableSelected(): Boolean {
        return drawable != 0
    }

    private fun canSaveCreature(): Boolean {
        return intelligence != 0 && endurance != 0 && strength != 0 && !name.isEmpty() && drawable != 0
    }

    override fun saveCreature(){
        if (canSaveCreature()) {
            creatureRepository.saveCreature(creature)
            getView()?.showCreatureSaved()
        } else {
            getView()?.showCreatureSavedError()
        }
    }
}

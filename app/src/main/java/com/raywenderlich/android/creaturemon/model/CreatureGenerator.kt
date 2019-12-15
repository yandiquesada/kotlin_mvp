package com.raywenderlich.android.creaturemon.model

class CreatureGenerator {
    fun generateCreature(creatureAttributes: CreatureAttributes, name: String = "", drawable: Int = 0): Creature {
        val hitPoints = getHitPoints(creatureAttributes)
        return Creature(creatureAttributes, hitPoints, name)
    }

    private fun getHitPoints(creatureAttributes: CreatureAttributes): Int {
        return 5 * creatureAttributes.intelligence + 3 * creatureAttributes.strength + 4 * creatureAttributes.endurance
    }
}
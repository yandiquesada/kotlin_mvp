package com.raywenderlich.android.creaturemon.model

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CreatureGeneratorTest {
    private lateinit var creatureGenerator: CreatureGenerator

    @Before
    fun setup() {
        creatureGenerator = CreatureGenerator()
    }

    @Test
    fun generateHitPoints() {
        val attributes = CreatureAttributes(
                intelligence = 7,
                strength = 3,
                endurance =  10
        )
        val name = "Rikachu"
        val expectedCreature = Creature(attributes, 84, name)

        val generatedCreature = creatureGenerator.generateCreature(attributes, name)

        assertEquals(expectedCreature.hitPoints, generatedCreature.hitPoints)
        assertEquals(expectedCreature.name, generatedCreature.name)
    }
}
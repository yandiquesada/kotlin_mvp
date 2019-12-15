package com.raywenderlich.android.creaturemon.preseneter

import com.raywenderlich.android.creaturemon.model.AttributeType
import com.raywenderlich.android.creaturemon.model.Creature
import com.raywenderlich.android.creaturemon.model.CreatureAttributes
import com.raywenderlich.android.creaturemon.model.CreatureGenerator
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations

class CreaturePresenterTest {

    private lateinit var presenter: CreaturePresenter

    @Mock
    lateinit var view: CreatureContract.View

    @Mock
    lateinit var mockGenerator: CreatureGenerator

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter = CreaturePresenter(mockGenerator)
        presenter.setView(view)
    }

    @Test
    fun testIntelligenceSelected() {
        val attributes = CreatureAttributes(10, 0,0)
        val stubCreature = Creature(attributes, 50)
        `when`(mockGenerator.generateCreature(attributes)).thenReturn(stubCreature)

        presenter.attributeSelected(AttributeType.INTELLIGENCE, 3)

        verify(view, times(1)).showHitPoints("50")
    }

}
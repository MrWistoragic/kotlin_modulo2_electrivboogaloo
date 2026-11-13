package com.example.pr1_5

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
//import androidx.room3.jarjarred.org.antlr.v4.tool.Rule
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun testWaterTrackerLogic() {
        composeTestRule.setContent { WaterTracker() }

        // 1. Проверка кнопки добавления
        composeTestRule.onNodeWithTag("add_water_btn").performClick()
        composeTestRule.onNodeWithText("Сделать Глоть воды (+250 мл)").assertExists()

        // 2. Проверка кнопки "Завершить день" (нажимаем 6 раз по 250 = 1500)
        repeat(5) { composeTestRule.onNodeWithTag("add_water_btn").performClick() } // 250 + 1250 = 1500
        composeTestRule.onNodeWithTag("finish_day_btn").performClick()

        // 3. Проверка текста дней
        composeTestRule.onNodeWithTag("streak_text")
            .assertTextEquals("Дней подряд (1500+ мл): 1")
    }
}
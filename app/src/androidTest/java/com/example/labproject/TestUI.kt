package com.example.labproject

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import com.example.labproject.data.DataSource
import com.example.labproject.ui.App
import com.example.labproject.ui.theme.LabProjectTheme

import org.junit.Test

import org.junit.Rule

class TestUI {

    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun myTest() {
        // Start the app
        composeTestRule.setContent {
            LabProjectTheme {
                App()
            }
        }

        composeTestRule.onNodeWithText("LAB1").performClick()
        composeTestRule.onNodeWithContentDescription("Back").performClick()
        composeTestRule.onNodeWithText("LAB2").performClick()
        composeTestRule.onNodeWithContentDescription("Back").performClick()
        composeTestRule.onNodeWithText("LAB3").performClick()
        composeTestRule.onNodeWithContentDescription("Back").performClick()
        composeTestRule.onNodeWithText("LAB4 LAB5 LAB6").performClick()

        // PLUS
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NUM).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NUM).performClick()
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NUM).performTextInput("21")

        composeTestRule.onNodeWithTag(DataSource.TAG_SECOND_NUM).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_SECOND_NUM).performClick()
        composeTestRule.onNodeWithTag(DataSource.TAG_SECOND_NUM).performTextInput("15")

        composeTestRule.onNodeWithTag(DataSource.TAG_PLUS).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_PLUS).performClick()

        composeTestRule.onNodeWithTag(DataSource.TAG_RESULT).assertIsDisplayed()
        composeTestRule.onNodeWithText("36.0").assertIsDisplayed()

        // MINUS
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NUM).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NUM).performClick()
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NUM).performTextReplacement("-4.6")

        composeTestRule.onNodeWithTag(DataSource.TAG_SECOND_NUM).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_SECOND_NUM).performClick()
        composeTestRule.onNodeWithTag(DataSource.TAG_SECOND_NUM).performTextReplacement("2000")

        composeTestRule.onNodeWithTag(DataSource.TAG_MINUS).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_MINUS).performClick()

        composeTestRule.onNodeWithTag(DataSource.TAG_RESULT).assertIsDisplayed()
        composeTestRule.onNodeWithText("-2004.6").assertIsDisplayed()

        // MULTIPLY
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NUM).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NUM).performClick()
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NUM).performTextReplacement("7.225")

        composeTestRule.onNodeWithTag(DataSource.TAG_SECOND_NUM).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_SECOND_NUM).performClick()
        composeTestRule.onNodeWithTag(DataSource.TAG_SECOND_NUM).performTextReplacement("2")

        composeTestRule.onNodeWithTag(DataSource.TAG_MULTIPLY).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_MULTIPLY).performClick()

        composeTestRule.onNodeWithTag(DataSource.TAG_RESULT).assertIsDisplayed()
        composeTestRule.onNodeWithText("14.45").assertIsDisplayed()

        // DIVIDE
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NUM).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NUM).performClick()
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NUM).performTextReplacement("12.2")

        composeTestRule.onNodeWithTag(DataSource.TAG_SECOND_NUM).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_SECOND_NUM).performClick()
        composeTestRule.onNodeWithTag(DataSource.TAG_SECOND_NUM).performTextReplacement("2")

        composeTestRule.onNodeWithTag(DataSource.TAG_DIVIDE).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_DIVIDE).performClick()

        composeTestRule.onNodeWithTag(DataSource.TAG_RESULT).assertIsDisplayed()
        composeTestRule.onNodeWithText("6.1").assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("Back").performClick()

        composeTestRule.onNodeWithText("LAB7").performClick()

        // Save profile
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NAME_EDIT).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NAME_EDIT).performClick()
        composeTestRule.onNodeWithTag(DataSource.TAG_FIRST_NAME_EDIT).performTextReplacement("Andrew")

        composeTestRule.onNodeWithTag(DataSource.TAG_LAST_NAME_EDIT).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_LAST_NAME_EDIT).performClick()
        composeTestRule.onNodeWithTag(DataSource.TAG_LAST_NAME_EDIT).performTextReplacement("Gusarov")

        composeTestRule.onNodeWithTag(DataSource.TAG_SAVE_PROFILE).assertIsDisplayed()
        composeTestRule.onNodeWithTag(DataSource.TAG_SAVE_PROFILE).performClick()

        composeTestRule.onNodeWithText("Welcome, Andrew Gusarov!").assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("Back").performClick()

        //composeTestRule.onNodeWithText("Welcome").assertIsDisplayed()
    }
}
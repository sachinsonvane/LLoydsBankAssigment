package com.ss.lloydsbankpoc

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import com.ss.lloydsbankpoc.presentation.main.MainActivity
import com.ss.lloydsbankpoc.presentation.navigation.AppNavigation
import org.junit.Rule
import org.junit.Test

class ComposeUiTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun textIfLLoydsBankTestAssignmentIsDisplayed() {
        composeRule.onNodeWithText("LLoydsBankTest Assignment").assertIsDisplayed()
    }

}

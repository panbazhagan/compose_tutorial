package app.tutorial.compose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class MainActivityKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun shouldDisplayPreviewView() {
        composeTestRule.setContent {
            ReCompositionExample()
        }
        composeTestRule.onNodeWithText("1").assertIsDisplayed()
    }
}
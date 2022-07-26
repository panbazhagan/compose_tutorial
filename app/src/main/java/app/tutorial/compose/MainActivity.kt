package app.tutorial.compose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import app.tutorial.compose.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

data class ExampleUiState(
    val dataToDisplayOnScreen: List<String> = emptyList(),
    val userMessages: List<String> = listOf("Hello"),
    val loading: Boolean = false
)

class ExampleViewModel() : ViewModel() {

    var uiState by mutableStateOf(ExampleUiState())
        private set

    // Business logic
    fun somethingRelatedToBusinessLogic() { /* ... */
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun ReCompositionExample(viewModel: ExampleViewModel = viewModel()) {
    Column {
        Text(text = viewModel.uiState.userMessages.first())
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTutorialTheme {
        Log.d("compose", "This compose block is running")
        ReCompositionExample()
    }
}
package ua.edu.lntu.ipz_cw2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.lntu.ipz_cw2.ui.theme.IPZ_CR_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CR_2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun SliderWithButton(){
    val texts = listOf("Присідання", "Віджимання", "Підтягування")
    // Список який буде перемикатись

    var currentIndex by remember { mutableIntStateOf(0) }
    // змінна для початкового індексу


    fun changeTextIndex() {
        currentIndex = (currentIndex + 1) % texts.size
    }

    // Графічне відображення інтерфейсу
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        //Поточний текст
        Text(
            text = texts[currentIndex],
            modifier = Modifier.padding(vertical = 16.dp) //внутрішні відступи
        )

        Button(onClick = { changeTextIndex() }) {
            Text("Наступний текст")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SliderWithButtonPreview() {
    IPZ_CR_2Theme {
        SliderWithButton()
    }
}
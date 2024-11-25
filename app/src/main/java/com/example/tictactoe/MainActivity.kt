package com.example.tictactoe

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tictactoe.ui.theme.TicTacToeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeTheme {

            }
        }
    }
}

@Composable
fun PlayerName(name: String, modifier: Modifier = Modifier) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Tom",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Jerry",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun Grid(modifier: Modifier = Modifier){
        LazyVerticalGrid(
            GridCells.Fixed(3),
            verticalArrangement = Arrangement.Center,
            content = {
                items(9) {
                    Box(
                        modifier
                            .width(100.dp)
                            .height(120.dp)
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                            .clip(RectangleShape)
                    ) {
                        Button( onClick = {},
                            modifier =
                            Modifier
                                .align(Alignment.Center)
                                .fillMaxSize()
                            , shape = RectangleShape)
                        {

                        }
                    }
                }
            }
        )
}


@Preview(
    showBackground = true,
    widthDp = 411,
    heightDp = 891,)
@Preview(
    name = "Phone Preview",
    showBackground = true,
    widthDp = 411,
    heightDp = 891,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun GridPreview() {
    TicTacToeTheme {
        Surface(){
            Column(verticalArrangement = Arrangement.Center,) {
                PlayerName("Tom")
                Spacer(modifier = Modifier.height(75.dp))
                Grid()
            }
        }
    }
}
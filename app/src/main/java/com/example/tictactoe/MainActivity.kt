package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoe.ui.theme.TicTacToeTheme
import kotlinx.coroutines.flow.MutableStateFlow

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

@SuppressLint("UnrememberedMutableState", "StateFlowValueCalledInComposition")
@Composable
fun GameScreen(
) {
    /* For UI preview purposes, refactor this part of code to somewhere else */
    val boardState = MutableStateFlow(List(3) { MutableList(3) { "" } })
    val borderColor = MaterialTheme.colorScheme.onSurface
    /* */
    Column(Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text("Current Player's Turn: Tom") /* placeholder, replace with actual player */
        Spacer(Modifier.height(16.dp))
        for (y in 0..2) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                for (x in 0..2) {
                    Box(
                        Modifier
                            .size(100.dp)
                            .border(1.dp, borderColor)
                            .clickable {  },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(boardState.value[y][x])
                    }
                }
            }
        }
    }
}

@Composable
fun PlayerCreationScreen(modifier: Modifier = Modifier){
    Column (modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Tic Tac Toe", fontWeight = FontWeight.Bold, fontSize = 50.sp)
        Spacer(modifier = Modifier.height(75.dp))

        Text(text = "Player Name")
        Spacer(modifier = Modifier.height(25.dp))
        Box {
            TextField(value = "", onValueChange = {}, placeholder = { Text("Enter player name") })
        }
        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Connect")
        }
    }
}

@Composable
fun LobbyScreen() {
    Column {
        Spacer(modifier = Modifier.height(75.dp))
        Text("Players in Lobby", textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 30.sp, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(5) { player -> /* placeholder */
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { /* Handle player selection */ }
                        .padding(8.dp)
                ) {
                    Text("Player Name")
                    Spacer(Modifier.weight(1f))
                    Button(onClick = { /* Handle challenge */ }) {
                        Text("Challenge")
                    }
                }
            }
        }
    }
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
            GameScreen()
        }
    }
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
fun PlayerCreationScreenPreview() {
    TicTacToeTheme {
        Surface(){
            PlayerCreationScreen()
        }
    }
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
fun LobbyScreenPreview() {
    TicTacToeTheme {
        Surface(){
            LobbyScreen()
        }
    }
}
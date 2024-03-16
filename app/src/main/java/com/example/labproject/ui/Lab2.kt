package com.example.labproject.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labproject.ui.theme.Pink80

@Preview
@Composable
fun Lab2Screen(
    onCancelButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
)
{
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RowExample(modifier.padding(10.dp))
            ColumnExample(modifier.padding(10.dp))
            BoxExample(modifier.padding(10.dp))
            GridExample(modifier.padding(10.dp))
        }

    }
}

var cBg = Modifier.background(color = Color.Cyan)
var bBg = Modifier.background(color = Color.Blue)
var gBg = Modifier.background(color = Color.Green)

@Composable
fun RowExample(
    modifier: Modifier = Modifier
) {
    Text(text = "Row aligment:", color = Color.Black, fontSize = 28.sp)
    Row(modifier)
    {
        FilledTonalButton(onClick = {},
            modifier = Modifier.padding(horizontal = 5.dp)) {
            Text("AAAA")
        }
        FilledTonalButton(onClick = {},
            modifier = Modifier.padding(horizontal = 5.dp)) {
            Text("BBBB")
        }
        FilledTonalButton(onClick = {},
            modifier = Modifier.padding(horizontal = 5.dp)) {
            Text("CCCC")
        }
    }
}

@Composable
fun ColumnExample(
    modifier: Modifier = Modifier
) {
    Text(text = "Column aligment:", color = Color.Black, fontSize = 28.sp)
    Column(modifier)
    {
        FilledTonalButton(onClick = {})
        {
            Text("AAAA")
        }
        FilledTonalButton(onClick = {},
  ) {
            Text("BBBB")
        }
        FilledTonalButton(onClick = {}) {
            Text("CCCC")
        }
    }
}

@Composable
fun BoxExample(
    modifier: Modifier = Modifier
) {
    Text(text = "Box aligment:", color = Color.Black, fontSize = 28.sp, modifier = Modifier.padding(10.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
    ) {
        Button(onClick = {}, modifier = Modifier.align(Alignment.TopStart).width(120.dp)) {
            Text(text = "Top Start", fontSize = 12.sp)
        }
        Button(onClick = {}, modifier = Modifier.align(Alignment.TopCenter).width(120.dp)) {
            Text(text = "Top Center", fontSize = 12.sp)
        }
        Button(onClick = {}, modifier = Modifier.align(Alignment.TopEnd).width(120.dp)) {
            Text(text = "Top End", fontSize = 12.sp)
        }
        Button(onClick = {}, modifier = Modifier.align(Alignment.CenterStart).width(120.dp)) {
            Text(text = "Center Start", fontSize = 12.sp)
        }
        Button(onClick = {}, modifier = Modifier.align(Alignment.Center).width(120.dp)) {
            Text(text = "Center Start", fontSize = 12.sp)
        }
        Button(onClick = {}, modifier = Modifier.align(Alignment.CenterEnd).width(120.dp)) {
            Text(text = "Center Start", fontSize = 12.sp)
        }
        Button(onClick = {}, modifier = Modifier.align(Alignment.BottomStart).width(120.dp)) {
            Text(text = "Bottom Start", fontSize = 12.sp)
        }
        Button(onClick = {}, modifier = Modifier.align(Alignment.BottomCenter).width(120.dp)) {
            Text(text = "Bottom Start", fontSize = 12.sp)
        }
        Button(onClick = {}, modifier = Modifier.align(Alignment.BottomEnd).width(120.dp)) {
            Text(text = "Bottom Start", fontSize = 12.sp)
        }
    }
}

@Composable
fun GridExample(
    modifier: Modifier = Modifier
) {
    val list = (1..9).map { it.toString() }
    Text(text = "Lazy Grid aligment:", color = Color.Black, fontSize = 28.sp)
    LazyVerticalGrid(
        columns = GridCells.Adaptive(60.dp),

        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(list.size) { index ->
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .height(32.dp)
                        .fillMaxWidth()
                ) {
                    Button(onClick = {}) {
                        Text(list[index])
                    }
                }
            }
        },
        modifier = modifier
            .background(color = Color.White)
            .height(120.dp)
    )
}
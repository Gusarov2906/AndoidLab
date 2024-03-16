package com.example.labproject.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labproject.R
import com.example.labproject.data.DataSource.TAG_DIVIDE
import com.example.labproject.data.DataSource.TAG_FIRST_NUM
import com.example.labproject.data.DataSource.TAG_MINUS
import com.example.labproject.data.DataSource.TAG_MULTIPLY
import com.example.labproject.data.DataSource.TAG_PLUS
import com.example.labproject.data.DataSource.TAG_RESULT
import com.example.labproject.data.DataSource.TAG_SECOND_NUM


@Composable
fun Lab4_5_6_Screen(
    onCancelButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
)
{
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        CalculatorAppWithBg()
    }
}

@Preview
@Composable
fun CalculatorAppWithBg(
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    Box(modifier) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.9F
        )
        CalculatorApp(modifier)
    }
}


@Composable
fun CalculatorApp(
    modifier: Modifier = Modifier
) {
    var firstNum by rememberSaveable { mutableStateOf("") }
    var secondNum by rememberSaveable { mutableStateOf("") }
    var result by rememberSaveable { mutableStateOf("") }


    var orientation by remember { mutableStateOf(Configuration.ORIENTATION_PORTRAIT) }

    val configuration = LocalConfiguration.current
    LaunchedEffect(configuration) {
        // Save any changes to the orientation value on the configuration object
        snapshotFlow { configuration.orientation }
            .collect { orientation = it }
    }

    Column()
    {
        Text(
            text = "CALCULATOR",
            fontWeight = FontWeight.W800,
            fontSize = 35.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))

        when (orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                Row(modifier.align(Alignment.CenterHorizontally)) {
                    Column {
                        Text(text = "First number:", fontSize = 28.sp, modifier = modifier.padding(horizontal = 40.dp))
                        EditNumberField(firstNum, { firstNum = it },  modifier = modifier.padding(horizontal = 40.dp).testTag(TAG_FIRST_NUM))
                    }
                    Column {
                        Text(text = "Second number:", fontSize = 28.sp,  modifier = modifier.padding(horizontal = 40.dp))
                        EditNumberField(secondNum, { secondNum = it },  modifier = modifier.padding(horizontal = 40.dp).testTag(TAG_SECOND_NUM))
                    }
                }
            }
            else ->
            {
                Column(
                    modifier = modifier
                        .wrapContentHeight(Alignment.CenterVertically)
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(text = "First number:", fontSize = 28.sp)
                    EditNumberField(firstNum, { firstNum = it }, modifier = modifier.fillMaxWidth().testTag(TAG_FIRST_NUM))
                    Text(text = "Second number:", fontSize = 28.sp)
                    EditNumberField(secondNum, { secondNum = it }, modifier = modifier.fillMaxWidth().testTag(TAG_SECOND_NUM))
                }

            }
        }
        Column(
            modifier = modifier
                .wrapContentHeight(Alignment.CenterVertically)
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Center,

            ) {
            Text(text = "Operation:", fontSize = 28.sp)
            Row(modifier = Modifier.align(Alignment.CenterHorizontally))
            {
                Button(
                    onClick = { result = GetResult(firstNum, secondNum, '+') },
                    Modifier.padding(horizontal = 10.dp).testTag(TAG_PLUS)
                ) {
                    Text(text = "+", fontSize = 28.sp)
                }
                Button(
                    onClick = { result = GetResult(firstNum, secondNum, '-') },
                    Modifier.padding(horizontal = 10.dp).testTag(TAG_MINUS)
                ) {
                    Text(text = "-", fontSize = 28.sp)
                }
                Button(
                    onClick = { result = GetResult(firstNum, secondNum, '*') },
                    Modifier.padding(horizontal = 10.dp).testTag(TAG_MULTIPLY)
                ) {
                    Text(text = "*", fontSize = 28.sp)
                }
                Button(
                    onClick = { result = GetResult(firstNum, secondNum, '/') },
                    Modifier.padding(horizontal = 10.dp).testTag(TAG_DIVIDE)
                ) {
                    Text(text = "/", fontSize = 28.sp)
                }
            }
            Text(text = "Result:", fontSize = 28.sp)
            OutlinedTextField(
                value = result,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                textStyle = TextStyle(fontSize = 22.sp),
                modifier = Modifier.fillMaxWidth().testTag(TAG_RESULT),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    disabledContainerColor = MaterialTheme.colorScheme.surface,
                ),
                onValueChange = { result = it }
            )
        }
    }
}

fun GetResult(firstNum: String, secondNum: String, op: Char): String
{
    val regex = """-?\d+[.]?\d*""".toRegex()
    var matchResult = regex.matchEntire(firstNum)
    if (matchResult == null) {
        return "ERROR"
    }
    matchResult = regex.matchEntire(secondNum)
    if (matchResult == null)
    {
        return "ERROR"
    }
    return Calculate(firstNum.toDouble(), secondNum.toDouble(), op)
}

@Composable
fun EditNumberField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        singleLine = true,
        shape = MaterialTheme.shapes.large,
        modifier = modifier,
        textStyle = TextStyle(fontSize = 24.sp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            disabledContainerColor = MaterialTheme.colorScheme.surface,
        ),
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
}
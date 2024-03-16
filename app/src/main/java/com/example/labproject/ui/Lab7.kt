package com.example.labproject.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import com.example.labproject.R
import com.example.labproject.data.DataSource

@Composable
fun Lab7_Screen(
    onCancelButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
)
{
    val db = Room.databaseBuilder(
        LocalContext.current,
        DataSource.AppDatabase::class.java, "db"
    ).allowMainThreadQueries().build()

    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        PortfolioAppWithBg(db)
    }
}

@Preview
@Composable
fun PortfolioAppWithBg(
    db: DataSource.AppDatabase,
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
        PortfolioApp(db, modifier)
    }
}

@Composable
fun PortfolioApp(
    db: DataSource.AppDatabase,
    modifier: Modifier = Modifier
) {
    val userDao = db.userDao()
    val users: List<DataSource.User> = userDao.getAll()
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var firstNameInput by rememberSaveable { mutableStateOf("") }
    var lastNameInput by rememberSaveable { mutableStateOf("") }

    if (users.count() > 0) {
        firstName = users[0].firstName.toString()
        lastName = users[0].lastName.toString()
    }

    Column(modifier = modifier.wrapContentHeight(Alignment.CenterVertically)) {
        var modifier = modifier.align(Alignment.CenterHorizontally)
        Text(text = "Welcome, $firstName $lastName!", fontSize = 40.sp, modifier = modifier.padding(horizontal = 40.dp))
        Text(text = "First name:", fontSize = 28.sp, modifier = modifier.padding(horizontal = 40.dp))
        EditPortfolioField(firstNameInput, { firstNameInput = it },  modifier = modifier
            .padding(horizontal = 40.dp)
            .testTag(
                DataSource.TAG_FIRST_NAME_EDIT
            ))

        Text(text = "Last name:", fontSize = 28.sp,  modifier = modifier.padding(horizontal = 40.dp))
        EditPortfolioField(lastNameInput, { lastNameInput = it },  modifier = modifier
            .padding(horizontal = 40.dp)
            .testTag(
                DataSource.TAG_LAST_NAME_EDIT
            ))
        Button(onClick = {
            SaveProfile(db, firstNameInput, lastNameInput)
            firstName = firstNameInput
            lastName = lastNameInput
                         }, modifier.padding(vertical = 40.dp).testTag(
            DataSource.TAG_SAVE_PROFILE
        )) {
            Text(text = "save", fontSize = 28.sp)
        }
    }
}

fun SaveProfile(db: DataSource.AppDatabase, firstName: String, lastName: String)
{
    val userDao = db.userDao()
    userDao.update(DataSource.User(0, firstName, lastName))
}

@Composable
fun EditPortfolioField(
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
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    )
}

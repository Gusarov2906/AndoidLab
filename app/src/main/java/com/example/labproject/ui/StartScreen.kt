/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.labproject

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.labproject.data.DataSource
import com.example.labproject.ui.theme.LabProjectTheme
import com.example.labproject.ui.theme.Purple40


@Composable
fun StartScreen(
    labsOptions: List<Pair<Int, Int>>,
    onClickedLab1: (Int) -> Unit,
    onClickedLab2: (Int) -> Unit,
    onClickedLab3: (Int) -> Unit,
    onClickedLab4_5_6: (Int) -> Unit,
    onClickedLab7: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "ANDROID APP made by Gusarov Andrey PIN-21M",
                style = MaterialTheme.typography.headlineSmall,
                color = Purple40,
                fontSize = 45.sp,
                lineHeight = 50.sp,
                textAlign = TextAlign.Center,
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(id = R.dimen.padding_medium)
            )
        ) {
            LabButton(
                labelResourceId = labsOptions[0].first,
                onClick = { onClickedLab1(labsOptions[0].second) },
                modifier = Modifier.fillMaxWidth(),
            )
            LabButton(
                labelResourceId = labsOptions[1].first,
                onClick = { onClickedLab2(labsOptions[1].second) },
                modifier = Modifier.fillMaxWidth(),
            )
            LabButton(
                labelResourceId = labsOptions[2].first,
                onClick = { onClickedLab3(labsOptions[2].second) },
                modifier = Modifier.fillMaxWidth(),
            )
            LabButton(
                labelResourceId = labsOptions[3].first,
                onClick = { onClickedLab4_5_6(labsOptions[3].second) },
                modifier = Modifier.fillMaxWidth(),
            )
            LabButton(
                labelResourceId = labsOptions[4].first,
                onClick = { onClickedLab7(labsOptions[4].second) },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
fun LabButton(
    @StringRes labelResourceId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .widthIn(min = 250.dp)
            .height(50.dp)
    ) {
        Text(stringResource(labelResourceId), textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun StartScreenPreview() {
    LabProjectTheme {
        StartScreen(
            labsOptions = DataSource.labsOption,
            onClickedLab1 = {},
            onClickedLab2 = {},
            onClickedLab3 = {},
            onClickedLab4_5_6 = {},
            onClickedLab7 = {},
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(R.dimen.padding_medium))
        )
    }
}

/*
 * Copyright 2023 The Android Open Source Project
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

package com.google.android.horologist.materialcomponents

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.horologist.compose.layout.ScalingLazyColumn
import com.google.android.horologist.compose.layout.ScalingLazyColumnState
import com.google.android.horologist.compose.material.SplitToggleChip
import com.google.android.horologist.compose.material.ToggleChipToggleControl

@Composable
internal fun SampleSplitToggleChipScreen(
    modifier: Modifier = Modifier,
    columnState: ScalingLazyColumnState,
) {
    ScalingLazyColumn(
        columnState = columnState,
        modifier = modifier.fillMaxSize(),
    ) {
        item {
            SplitToggleChip(
                checked = true,
                onCheckedChanged = { },
                label = "Primary label",
                onClick = { },
                toggleControl = ToggleChipToggleControl.Switch,
            )
        }
        item {
            SplitToggleChip(
                checked = true,
                onCheckedChanged = { },
                label = "Primary label",
                onClick = { },
                toggleControl = ToggleChipToggleControl.Radio,
            )
        }
        item {
            SplitToggleChip(
                checked = true,
                onCheckedChanged = { },
                label = "Primary label",
                onClick = { },
                toggleControl = ToggleChipToggleControl.Checkbox,
            )
        }
        item {
            SplitToggleChip(
                checked = false,
                onCheckedChanged = { },
                label = "Primary label",
                onClick = { },
                toggleControl = ToggleChipToggleControl.Switch,
            )
        }
        item {
            SplitToggleChip(
                checked = true,
                onCheckedChanged = { },
                label = "Primary label",
                onClick = { },
                toggleControl = ToggleChipToggleControl.Switch,
                secondaryLabel = "Secondary label",
            )
        }
        item {
            SplitToggleChip(
                checked = true,
                onCheckedChanged = { },
                label = "Primary label",
                onClick = { },
                toggleControl = ToggleChipToggleControl.Switch,
                enabled = false,
            )
        }
        item {
            SplitToggleChip(
                checked = false,
                onCheckedChanged = { },
                label = "Primary label",
                onClick = { },
                toggleControl = ToggleChipToggleControl.Switch,
                enabled = false,
            )
        }
    }
}

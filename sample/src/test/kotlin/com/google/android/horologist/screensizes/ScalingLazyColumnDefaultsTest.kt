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

package com.google.android.horologist.screensizes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.AppCard
import androidx.wear.compose.material.Text
import com.google.android.horologist.composables.SectionedList
import com.google.android.horologist.compose.layout.ScalingLazyColumnDefaults
import com.google.android.horologist.compose.layout.ScalingLazyColumnState
import com.google.android.horologist.compose.material.Title
import com.google.android.horologist.compose.tools.Device
import com.google.android.horologist.sample.R
import com.google.android.horologist.sample.Screen
import org.junit.Test

class ScalingLazyColumnDefaultsTest(device: Device) :
    ScreenSizeTest(device = device, showTimeText = false) {

        @Composable
        override fun Content() {
            Standard()
        }

        @Test
        fun responsive() {
            runTest { Responsive() }
        }

        @Test
        fun belowTimeText() {
            runTest { BelowTimeText() }
        }

        @Test
        fun standard_end() {
            runTest {
                val columnState = ScalingLazyColumnDefaults.scalingLazyColumnDefaults().create()

                SampleMenu(columnState = columnState)

                LaunchedEffect(Unit) {
                    columnState.state.scrollToItem(100, 0)
                }
            }
        }

        @Test
        fun responsive_end() {
            runTest {
                val columnState = ScalingLazyColumnDefaults.responsive().create()

                SampleMenu(columnState = columnState)

                LaunchedEffect(Unit) {
                    columnState.state.scrollToItem(100, 0)
                }
            }
        }

        @Test
        fun belowTimeText_end() {
            runTest {
                val columnState = ScalingLazyColumnDefaults.belowTimeText().create()

                SampleMenu(columnState = columnState)

                LaunchedEffect(Unit) {
                    columnState.state.scrollToItem(100, 0)
                }
            }
        }

        @Composable
        fun SampleMenu(columnState: ScalingLazyColumnState, modifier: Modifier = Modifier) {
            SectionedList(
                columnState = columnState,
                modifier = modifier.fillMaxSize(),
            ) {
                section(
                    listOf(
                        Pair(
                            R.string.sectionedlist_stateless_sections_menu,
                            Screen.SectionedListStatelessScreen.route,
                        ),
                        Pair(
                            R.string.sectionedlist_stateful_sections_menu,
                            Screen.SectionedListStatefulScreen.route,
                        ),
                        Pair(
                            R.string.sectionedlist_expandable_sections_menu,
                            Screen.SectionedListExpandableScreen.route,
                        ),
                    ),
                ) {
                    header {
                        Title(
                            stringResource(R.string.sectionedlist_samples_title),
                            Modifier.padding(vertical = 8.dp),
                        )
                    }

                    loaded {
                        AppCard(
                            onClick = { },
                            appName = {
                                Text("App Name")
                            },
                            time = {
                                Text("12:05")
                            },
                            title = {
                                Text("Title")
                            },
                        ) {
                            Text("Content\nContent\nContent")
                        }
                    }
                }
            }
        }
    }

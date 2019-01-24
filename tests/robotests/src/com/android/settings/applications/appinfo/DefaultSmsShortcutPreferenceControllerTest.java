/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.applications.appinfo;

import static com.google.common.truth.Truth.assertThat;

import android.content.Context;
import android.permission.PermissionControllerManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowApplication;

@RunWith(RobolectricTestRunner.class)
public class DefaultSmsShortcutPreferenceControllerTest {

    private static final String TEST_PACKAGE_NAME = "TestPackage";
    private static final String PREFERENCE_KEY = "default_sms_app";

    @Mock
    private PermissionControllerManager mPermissionControllerManager;

    private DefaultSmsShortcutPreferenceController mController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ShadowApplication.getInstance().setSystemService(Context.PERMISSION_CONTROLLER_SERVICE,
                mPermissionControllerManager);
        mController = new DefaultSmsShortcutPreferenceController(RuntimeEnvironment.application,
                TEST_PACKAGE_NAME);
    }

    @Test
    public void getPreferenceKey_shouldReturnDefaultSms() {
        assertThat(mController.getPreferenceKey()).isEqualTo(PREFERENCE_KEY);
    }
}

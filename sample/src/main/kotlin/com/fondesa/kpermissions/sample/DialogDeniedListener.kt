/*
 * Copyright (c) 2018 Fondesa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fondesa.kpermissions.sample

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import com.fondesa.kpermissions.request.PermissionRequest


/**
 * Created by antoniolig on 05/01/18.
 */
class DialogDeniedListener(private val context: Context) : PermissionRequest.DeniedListener {

    override fun onPermissionsPermanentlyDenied(permissions: Array<out String>) {
        AlertDialog.Builder(context)
                .setTitle("Denied title")
                .setMessage("Denied message")
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    // Open the app's settings.
                    val intent = createAppSettingsIntent()
                    context.startActivity(intent)
                }
                .setNegativeButton(android.R.string.cancel, null)
                .show()
    }

    private fun createAppSettingsIntent() = Intent().apply {
        action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        data = Uri.fromParts("package", context.packageName, null)
    }
}
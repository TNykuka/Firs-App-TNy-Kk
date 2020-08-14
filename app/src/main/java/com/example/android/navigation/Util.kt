/*
 * Copyright 2019, The Android Open Source Project
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

package com.example.android.trackmysleepquality

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.example.android.navigation.R
import com.example.android.navigation.database.ListNight
import java.text.SimpleDateFormat


@SuppressLint("SimpleDateFormat")
fun convertLongToDateString(systemTime: String): String {
    return SimpleDateFormat("EEEE MMM-dd-yyyy' Time: 'HH:mm")
            .format(systemTime).toString()
}

fun formatNights(nights: List<ListNight>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
        nights.forEach {
            append("<br>")
            append(resources.getString(R.string.add_name))
            append("\t${convertLongToDateString(it.namelistQuality)}<br>")
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}

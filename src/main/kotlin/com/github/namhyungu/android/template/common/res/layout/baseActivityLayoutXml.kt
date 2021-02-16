package com.github.namhyungu.android.template.common.res.layout

import com.android.tools.idea.wizard.template.getMaterialComponentName

fun baseActivityLayoutXml(
    packageName: String,
    activityClass: String,
    useAndroidX: Boolean
): String {
    val layout = getMaterialComponentName("android.support.constraint.ConstraintLayout", useAndroidX)

    return """
<?xml version="1.0" encoding="utf-8"?>
<$layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="$packageName.$activityClass">
</$layout>
"""
}

package com.github.namhyungu.android.template.mvvmActivity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.namhyungu.android.template.common.saveFile
import com.github.namhyungu.android.template.mvvmActivity.src.mvvmActivity
import com.github.namhyungu.android.template.mvvmActivity.src.mvvmViewModel
import mvvmUiState

fun RecipeExecutor.generateMVVMActivity(
    moduleData: ModuleTemplateData,
    screenName: String,
    packageName: String,
) {
    val (projectData, srcOut) = moduleData
    val useAndroidX = projectData.androidXSupport

    val activityClass = "${screenName}Activity"
    val viewModelClass = "${screenName}ViewModel"
    val uiStateClass = "${screenName}UiState"

    val activityPath = srcOut.resolve("$activityClass.kt")
    val activity = mvvmActivity(packageName, activityClass, useAndroidX)
    saveFile(activity, activityPath)

    val viewModelPath = srcOut.resolve("$viewModelClass.kt")
    val viewModel = mvvmViewModel(packageName, viewModelClass, uiStateClass)
    saveFile(viewModel, viewModelPath)

    val uiStatePath = srcOut.resolve("$uiStateClass.kt")
    val uiState = mvvmUiState(packageName, uiStateClass)
    saveFile(uiState, uiStatePath)
}
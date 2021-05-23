package com.github.namhyungu.android.template.mvvmActivity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.namhyungu.android.template.common.res.layout.baseActivityLayoutXml
import com.github.namhyungu.android.template.common.saveFile
import com.github.namhyungu.android.template.mvvmActivity.src.mvvmActivity
import com.github.namhyungu.android.template.mvvmActivity.src.mvvmViewModel
import mvvmUiState

fun RecipeExecutor.generateMVVMActivity(
        moduleData: ModuleTemplateData,
        screenName: String,
        packageName: String,
        layoutName: String,
) {
    val (projectData, srcOut, resOut) = moduleData
    val useAndroidX = projectData.androidXSupport

    val activityClass = "${screenName}Activity"
    val viewModelClass = "${screenName}ViewModel"
    val uiStateClass = "${screenName}UiState"

    val activityPath = srcOut.resolve("$activityClass.kt")
    val activity = mvvmActivity(
            packageName = packageName,
            applicationPackage = projectData.applicationPackage,
            activityClass = activityClass,
            viewModelClass = viewModelClass,
            layoutName = layoutName,
            useAndroidX = useAndroidX
    )
    saveFile(activity, activityPath)

    val viewModel = mvvmViewModel(packageName, viewModelClass, uiStateClass)
    saveFile(viewModel, srcOut.resolve("$viewModelClass.kt"))

    val uiState = mvvmUiState(packageName, uiStateClass)
    saveFile(uiState, srcOut.resolve("$uiStateClass.kt"))

    val layout = baseActivityLayoutXml(packageName, activityClass, useAndroidX)
    saveFile(layout, resOut.resolve("layout/$layoutName.xml"))
}

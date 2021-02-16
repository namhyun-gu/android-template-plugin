package com.github.namhyungu.android.template.mvvmActivity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.namhyungu.android.template.common.res.layout.baseActivityLayoutXml
import com.github.namhyungu.android.template.common.saveFile
import com.github.namhyungu.android.template.mvvmActivity.src.mvvmAction
import com.github.namhyungu.android.template.mvvmActivity.src.mvvmActivity
import com.github.namhyungu.android.template.mvvmActivity.src.mvvmUseCase
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
    val useCaseClass = "${screenName}UseCase"
    val actionClass = "${screenName}Action"

    val activityPath = srcOut.resolve("$activityClass.kt")
    val activity = mvvmActivity(
        packageName = packageName,
        applicationPackage = projectData.applicationPackage,
        activityClass = activityClass,
        layoutName = layoutName,
        useAndroidX = useAndroidX
    )
    saveFile(activity, activityPath)

    val viewModel = mvvmViewModel(packageName, viewModelClass, uiStateClass)
    saveFile(viewModel, srcOut.resolve("$viewModelClass.kt"))

    val uiState = mvvmUiState(packageName, uiStateClass)
    saveFile(uiState, srcOut.resolve("$uiStateClass.kt"))

    val useCase = mvvmUseCase(packageName, useCaseClass)
    saveFile(useCase, srcOut.resolve("$useCaseClass.kt"))

    val action = mvvmAction(packageName, actionClass)
    saveFile(action, srcOut.resolve("$actionClass.kt"))

    val layout = baseActivityLayoutXml(packageName, activityClass, useAndroidX)
    saveFile(layout, resOut.resolve("layout/$layoutName.xml"))
}

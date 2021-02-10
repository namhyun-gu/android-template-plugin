package com.github.namhyungu.android.template.mvvmActivity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter
import com.github.namhyungu.android.template.common.MIN_API

val mvvmActivityTemplate
    get() = template {
        name = "MVVM Activity"
        minApi = MIN_API
        description = ""
        revision = 1

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        lateinit var layoutName: StringParameter
        val screenName = stringParameter {
            name = "Screen Name"
            constraints = listOf(Constraint.NONEMPTY)
            default = "Main"
        }

        val packageName = defaultPackageNameParameter

        widgets(
            TextFieldWidget(screenName),
            Separator,
            PackageNameWidget(packageName),
        )

        recipe = { data: TemplateData ->
            generateMVVMActivity(
                moduleData = data as ModuleTemplateData,
                screenName = screenName.value,
                packageName = packageName.value,
            )
        }
    }
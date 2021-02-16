package com.github.namhyungu.android.template.mvvmActivity

import com.android.tools.idea.wizard.template.Category
import com.android.tools.idea.wizard.template.Constraint.LAYOUT
import com.android.tools.idea.wizard.template.Constraint.NONEMPTY
import com.android.tools.idea.wizard.template.Constraint.UNIQUE
import com.android.tools.idea.wizard.template.FormFactor
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.PackageNameWidget
import com.android.tools.idea.wizard.template.Separator
import com.android.tools.idea.wizard.template.TemplateData
import com.android.tools.idea.wizard.template.TextFieldWidget
import com.android.tools.idea.wizard.template.WizardUiContext
import com.android.tools.idea.wizard.template.activityToLayout
import com.android.tools.idea.wizard.template.impl.defaultPackageNameParameter
import com.android.tools.idea.wizard.template.stringParameter
import com.android.tools.idea.wizard.template.template
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

        val screenName = stringParameter {
            name = "Screen Name"
            constraints = listOf(NONEMPTY)
            default = "Main"
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            constraints = listOf(LAYOUT, UNIQUE, NONEMPTY)
            suggest = { activityToLayout("${screenName.value}Activity") }
            default = "activity_main"
        }

        val packageName = defaultPackageNameParameter

        widgets(
            TextFieldWidget(screenName),
            TextFieldWidget(layoutName),
            Separator,
            PackageNameWidget(packageName),
        )

        recipe = { data: TemplateData ->
            generateMVVMActivity(
                moduleData = data as ModuleTemplateData,
                screenName = screenName.value,
                packageName = packageName.value,
                layoutName = layoutName.value
            )
        }
    }

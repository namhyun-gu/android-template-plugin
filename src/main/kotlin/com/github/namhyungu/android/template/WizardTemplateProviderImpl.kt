package com.github.namhyungu.android.template

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.namhyungu.android.template.mvvmActivity.mvvmActivityTemplate

// TODO Ref: https://cs.android.com/android-studio/platform/tools/base/+/mirror-goog-studio-master-dev:wizard/template-impl/src/com/android/tools/idea/wizard/template/impl/
class WizardTemplateProviderImpl : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(
        mvvmActivityTemplate
    )
}
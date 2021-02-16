package com.github.namhyungu.android.template.mvvmActivity.src

import com.android.tools.idea.wizard.template.PackageName
import com.android.tools.idea.wizard.template.escapeKotlinIdentifier
import com.android.tools.idea.wizard.template.getMaterialComponentName
import com.android.tools.idea.wizard.template.renderIf

fun mvvmActivity(
    packageName: String,
    applicationPackage: PackageName?,
    activityClass: String,
    layoutName: String,
    useAndroidX: Boolean
): String {
    val applicationPackageBlock = renderIf(applicationPackage != null) { "import $applicationPackage.R" }

    return """
package ${escapeKotlinIdentifier(packageName)}
 
import ${getMaterialComponentName("android.support.v7.app.AppCompatActivity", useAndroidX)}
import android.os.Bundle
$applicationPackageBlock

class $activityClass : AppCompatActivity() {
    private val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.$layoutName)
    }
    
    override fun onStart() {
        super.onStart()
        viewModel.uiState.observe(this) {
        }
    }
}
"""
}

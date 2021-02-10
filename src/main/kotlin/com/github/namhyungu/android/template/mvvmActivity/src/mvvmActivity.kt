package com.github.namhyungu.android.template.mvvmActivity.src

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier
import com.android.tools.idea.wizard.template.getMaterialComponentName

fun mvvmActivity(
    packageName: String,
    activityClass: String,
    useAndroidX: Boolean
) = """
package ${escapeKotlinIdentifier(packageName)}
 
import ${getMaterialComponentName("android.support.v7.app.AppCompatActivity", useAndroidX)}
import android.os.Bundle

class $activityClass : AppCompatActivity() {
    private val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    
    override fun onStart() {
        super.onStart()
        viewModel.uiState.observe(this) {
        }
    }
}
"""
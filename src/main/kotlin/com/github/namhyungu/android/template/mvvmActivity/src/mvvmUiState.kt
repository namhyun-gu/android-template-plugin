import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun mvvmUiState(
        packageName: String,
        uiStateClass: String
) = """
package ${escapeKotlinIdentifier(packageName)}

sealed class $uiStateClass
"""

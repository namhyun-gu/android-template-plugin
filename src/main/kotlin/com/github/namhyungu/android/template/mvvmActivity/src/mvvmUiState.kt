import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun mvvmUiState(
    packageName: String,
    uiStateClass: String
) = """
package ${escapeKotlinIdentifier(packageName)}

data class $uiStateClass(val data: String = "")
"""
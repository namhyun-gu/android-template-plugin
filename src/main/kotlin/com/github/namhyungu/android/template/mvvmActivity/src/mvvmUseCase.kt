package com.github.namhyungu.android.template.mvvmActivity.src

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun mvvmUseCase(
    packageName: String,
    useCaseClass: String
) =
    """
package ${escapeKotlinIdentifier(packageName)}

class $useCaseClass(
) : UseCase<P, R> {
}
"""

package com.github.namhyungu.android.template.mvvmActivity.src

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun mvvmAction(
    packageName: String,
    actionClass: String
) =
    """
package ${escapeKotlinIdentifier(packageName)}

sealed class $actionClass
"""

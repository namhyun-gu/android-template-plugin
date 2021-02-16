package com.github.namhyungu.android.template.mvvmActivity.src

import com.android.tools.idea.wizard.template.escapeKotlinIdentifier

fun mvvmViewModel(
    packageName: String,
    viewModelClass: String,
    uiStateClass: String
) =
    """
package ${escapeKotlinIdentifier(packageName)}

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class $viewModelClass : ViewModel() {
    private val _uiState = MutableLiveData($uiStateClass())
    val uiState: LiveData<$uiStateClass> = _uiState
}
"""

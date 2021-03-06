# android-template-plugin

![Build](https://github.com/namhyun-gu/android-template-plugin/workflows/Build/badge.svg)
<!-- [![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID) -->

<!-- Plugin description -->

## Supported Templates

<!-- Plugin description end -->

- MVVM Activity (New > Other > MVVM Activity)  
  Generate Activity, Ui State, Layout XML

  <img src="images/preview_mvvm_activity.png"/>

  <details>
  <summary>Preview file content</summary>
  - Activity

  ```kotlin
  import androidx.appcompat.app.AppCompatActivity
  import android.os.Bundle

  class ${screenName}Activity : AppCompatActivity() {
    private val viewModel: ${screenName}ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_${screenName})
    }
      
    override fun onStart() {
      super.onStart()
      viewModel.uiState.observe(this) {
      } 
    }
  }
  ```
    - UiState

  ```kotlin
  sealed class ${screenName}UiState
  ```
    - ViewModel

  ```kotlin
  import androidx.lifecycle.LiveData
  import androidx.lifecycle.MutableLiveData
  import androidx.lifecycle.ViewModel

  class ${screenName}ViewModel : ViewModel() {
    private val _uiState = MutableLiveData<${screenName}UiState>()
    val uiState: LiveData<${screenName}UiState> = _uiState
  }
  ```
  </details>

## Installation

- Using IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "
  android-template-plugin"</kbd> >
  <kbd>Install Plugin</kbd>

- Manually:

  Download the [latest release](https://github.com/namhyun-gu/android-template-plugin/releases/latest) and install it
  manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template

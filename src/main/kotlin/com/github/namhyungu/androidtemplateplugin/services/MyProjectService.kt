package com.github.namhyungu.androidtemplateplugin.services

import com.github.namhyungu.androidtemplateplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}

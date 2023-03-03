package com.github.ayfri.jetbrainsplugincopysave

import com.intellij.openapi.project.Project
import com.intellij.ui.components.CheckBox
import com.intellij.ui.dsl.builder.panel

class AppSettingsComponent(project: Project) {
    val field = CheckBox("Copy the current file contents on save.", CopyFileOnSaveState.getService(project).enabled)
    val panel = panel {
        row {
            cell(field)
        }
    }
}

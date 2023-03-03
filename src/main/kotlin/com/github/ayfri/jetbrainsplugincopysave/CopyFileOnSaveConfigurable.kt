package com.github.ayfri.jetbrainsplugincopysave

import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project

class CopyFileOnSaveConfigurable(private val project: Project) : Configurable {
    private var settingsComponent: AppSettingsComponent? = null

    override fun apply() {
        CopyFileOnSaveState.getService(project).enabled = settingsComponent!!.field.isSelected
    }

    override fun createComponent() = AppSettingsComponent(project).also { settingsComponent = it }.panel

    override fun disposeUIResources() {
        super.disposeUIResources()
        settingsComponent = null
    }

    override fun getDisplayName() = "Copy Current File On Save"

    override fun getPreferredFocusedComponent() = settingsComponent!!.field

    override fun isModified() = settingsComponent!!.field.isSelected != CopyFileOnSaveState.getService(project).enabled

    override fun reset() {
        settingsComponent!!.field.isSelected = CopyFileOnSaveState.getService(project).enabled
    }
}

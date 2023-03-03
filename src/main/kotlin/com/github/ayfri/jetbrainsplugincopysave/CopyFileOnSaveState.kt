package com.github.ayfri.jetbrainsplugincopysave

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.project.Project
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
	name = "com.github.ayfri.jetbrainsplugincopysave.CopyFileOnSaveState",
	storages = [
		Storage("CopyFileOnSave.xml")
	]
)
class CopyFileOnSaveState : PersistentStateComponent<CopyFileOnSaveState> {
	var enabled = false

	override fun getState() = this

	override fun loadState(state: CopyFileOnSaveState) {
		XmlSerializerUtil.copyBean(state, this)
	}

	companion object {
		fun getService(project: Project): CopyFileOnSaveState = project.getService(CopyFileOnSaveState::class.java)
	}
}

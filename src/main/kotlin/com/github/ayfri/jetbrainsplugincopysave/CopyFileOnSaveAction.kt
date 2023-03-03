package com.github.ayfri.jetbrainsplugincopysave

import com.intellij.ide.actionsOnSave.impl.ActionsOnSaveFileDocumentManagerListener.ActionOnSave
import com.intellij.openapi.components.service
import com.intellij.openapi.editor.Document
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.ide.CopyPasteManager
import com.intellij.openapi.project.Project
import java.awt.datatransfer.StringSelection

class CopyFileOnSaveAction : ActionOnSave() {
	override fun isEnabledForProject(project: Project): Boolean {
		return project.service<CopyFileOnSaveState>().enabled
	}

	override fun processDocuments(project: Project, documents: Array<out Document>) {
		val selectedTextEditor = FileEditorManager.getInstance(project).selectedTextEditor ?: return
		documents.find { selectedTextEditor.document == it }?.let { document ->
			val selection = StringSelection(document.text)
			CopyPasteManager.getInstance().setContents(selection)
		}
	}
}

package com.github.namhyungu.android.template.common

import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.SKIP_LINE
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.fileEditor.FileDocumentManager
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.OpenFileDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.ThrowableComputable
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.vfs.VirtualFile
import java.io.File
import java.io.IOException
import java.util.regex.Pattern

private val WINDOWS_NEWLINE = Pattern.compile("\r\n")

// Ref: com/android/tools/idea/templates/TemplateUtils.kt:333 (version: 2020.2)
fun RecipeExecutor.saveFile(source: String, to: File) {
    val contents = source.withoutSkipLines().trim().squishEmptyLines()

    var vf = LocalFileSystem.getInstance().findFileByIoFile(to)
    if (vf == null) {
        val parentDir = checkedCreateDirectoryIfMissing(to.parentFile)
        vf = parentDir.createChildData(this, to.name)
    }
    val document = FileDocumentManager.getInstance().getDocument(vf)
    if (document != null) {
        document.setText(WINDOWS_NEWLINE.matcher(contents).replaceAll("\n"))
        FileDocumentManager.getInstance().saveDocument(document)
    } else {
        vf.setBinaryContent(contents.toByteArray(Charsets.UTF_8), -1, -1, this)
    }
}

fun RecipeExecutor.openFile(project: Project, file: File) {
    val vFile = VfsUtil.findFileByIoFile(file, true)
    if (vFile != null) {
        val descriptor = OpenFileDescriptor(project, vFile)
        FileEditorManager.getInstance(project).openEditor(descriptor, true)
    }
}

private fun checkedCreateDirectoryIfMissing(directory: File): VirtualFile =
    WriteCommandAction.runWriteCommandAction(
        null,
        ThrowableComputable<VirtualFile, IOException> {
            VfsUtil.createDirectoryIfMissing(directory.absolutePath)
                ?: throw IOException("Unable to create " + directory.absolutePath)
        }
    )

private fun CharSequence.withoutSkipLines() = this.split("\n")
    .filter { it.trim() != SKIP_LINE }
    .joinToString("\n")
    .replace(SKIP_LINE, "")

private fun CharSequence.squishEmptyLines(): String {
    var isLastBlank = false
    return this.split("\n").mapNotNull { line ->
        when {
            line.isNotBlank() -> line
            !isLastBlank -> "" // replace blank with empty
            else -> null
        }.also {
            isLastBlank = line.isBlank()
        }
    }.joinToString("\n")
}

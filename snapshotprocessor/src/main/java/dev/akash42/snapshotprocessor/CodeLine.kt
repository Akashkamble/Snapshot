package dev.akash42.snapshotprocessor

data class CodeLine(
    val type: CodeLineType = CodeLineType.NON_IMPORT,
    val line: String
)

enum class CodeLineType {
    IMPORT,
    NON_IMPORT
}

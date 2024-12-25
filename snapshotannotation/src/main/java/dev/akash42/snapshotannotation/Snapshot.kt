package dev.akash42.snapshotannotation

@Target(AnnotationTarget.FUNCTION)
annotation class Snapshot(val fileName: String, val composableName: String)
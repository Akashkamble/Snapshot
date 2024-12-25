package dev.akash42.snapshotcodegenerator.test

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.akash42.snapshotannotation.Snapshot
import dev.akash42.snapshotcodegenerator.ui.theme.SnapshotCodeGeneratorTheme

@Composable
fun PackageTestComposable(modifier: Modifier = Modifier) {
    Box(modifier = modifier.size(50.dp).background(color = Color.Red)) {
    }
}

@Snapshot(fileName = "PackageTest.kt", composableName = "PackageTestComposable")
@Preview
@Composable
private fun PackageTestComposablePreview() {
    SnapshotCodeGeneratorTheme {
        PackageTestComposable()
    }
}
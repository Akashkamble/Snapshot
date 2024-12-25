package dev.akash42.snapshotcodegenerator

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.akash42.snapshotannotation.Snapshot
import dev.akash42.snapshotcodegenerator.ui.theme.SnapshotCodeGeneratorTheme

@Composable
fun TestComposable(modifier: Modifier = Modifier) {
    Text(text = "Hello From TestComposable!", modifier = modifier)
}

@Snapshot(fileName = "TestComposable.kt", composableName = "TestComposable")
@Preview
@Composable
private fun TestComposablePreview() {
    SnapshotCodeGeneratorTheme {
        TestComposable()
    }
}
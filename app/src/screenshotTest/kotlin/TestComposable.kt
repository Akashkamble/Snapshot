import dev.akash42.snapshotcodegenerator.TestComposable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.akash42.snapshotannotation.Snapshot
import dev.akash42.snapshotcodegenerator.ui.theme.SnapshotCodeGeneratorTheme

@Preview()
@Composable
fun TestComposablePreview() {
  SnapshotCodeGeneratorTheme {
        TestComposable()
    }
}



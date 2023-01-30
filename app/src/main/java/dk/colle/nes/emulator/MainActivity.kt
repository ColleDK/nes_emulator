package dk.colle.nes.emulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dk.colle.nes.emulator.bus.Bus
import dk.colle.nes.emulator.bus.IBus
import dk.colle.nes.emulator.cpu.IProc6502
import dk.colle.nes.emulator.cpu.Proc6502
import dk.colle.nes.emulator.ui.theme.Nes_emulatorTheme
import timber.log.Timber

class MainActivity : ComponentActivity() {
    private val processor: IProc6502 = Proc6502()
    private val bus: IBus = Bus()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        processor.linkBus(bus = bus)
        processor.writeData(0xFFFFu, 0xAFu)

        val data = processor.readData(0x0000u)
        Timber.d("New data $data")

        setContent {
            Nes_emulatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Nes_emulatorTheme {
        Greeting("Android")
    }
}
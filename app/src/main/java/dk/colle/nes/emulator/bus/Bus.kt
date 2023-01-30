package dk.colle.nes.emulator.bus

import dk.colle.nes.emulator.bus.IBus.Companion.MAX_RAM
import timber.log.Timber

@OptIn(ExperimentalUnsignedTypes::class)
class Bus: IBus {
    override val ram: UByteArray = UByteArray(MAX_RAM)

    init {
        // Reset ram
        for (i in ram.indices){
            ram[i] = 0x00u
        }
    }

    override fun writeData(address: UShort, data: UByte) {
        if (address < 0x0000u || address > 0xFFFFu){
            Timber.d("Trying to access memory out of range: $address")
            return
        }
        ram[address.toInt()] = data
    }

    override fun readData(address: UShort): UByte {
        if (address < 0x0000u || address > 0xFFFFu){
            Timber.d("Trying to access memory out of range: $address")
            return 0x00u
        }
        return ram[address.toInt()]
    }

    internal fun dumpData() {
        for (i in ram.indices){
            Timber.d("Data at $i is ${ram[i]}")
        }
    }
}
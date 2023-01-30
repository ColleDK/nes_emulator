package dk.colle.nes.emulator.bus

@OptIn(ExperimentalUnsignedTypes::class)
interface IBus {
    val ram: UByteArray
    fun writeData(address: UShort, data: UByte)
    fun readData(address: UShort): UByte

    companion object {
        const val MAX_RAM: Int = 64 * 1024 // 64 KB ram
    }
}
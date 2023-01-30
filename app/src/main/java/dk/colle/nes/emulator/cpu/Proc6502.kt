package dk.colle.nes.emulator.cpu

import dk.colle.nes.emulator.bus.IBus

class Proc6502: IProc6502 {
    private var bus: IBus? = null

    override fun linkBus(bus: IBus) {
        this.bus = bus
    }

    override fun writeData(address: UShort, data: UByte) {
        bus?.writeData(address = address, data = data)
    }

    override fun readData(address: UShort): UByte {
        return bus?.readData(address) ?: 0x00u
    }
}
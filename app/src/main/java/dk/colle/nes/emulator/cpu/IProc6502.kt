package dk.colle.nes.emulator.cpu

import dk.colle.nes.emulator.bus.IBus

interface IProc6502 {
    fun linkBus(bus: IBus)
    fun writeData(address: UShort, data: UByte)
    fun readData(address: UShort): UByte
}
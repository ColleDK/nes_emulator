package dk.colle.nes.emulator.cpu

import dk.colle.nes.emulator.bus.IBus

interface IProc6502 {
    fun linkBus(bus: IBus)
    fun writeData(address: UShort, data: UByte)
    fun readData(address: UShort): UByte

    // Addressing modes
    fun Implicit(): UByte // Implicit
    fun Immediate(): UByte // Immediate
    fun Relative(): UByte // Relative
    fun Indirect(): UByte // Indirect
    fun IndirectZeroX(): UByte // Indirect zero page
    fun IndirectZeroY(): UByte // Indirect zero page
    fun ZeroPage0(): UByte // Zero page
    fun ZeroPageX(): UByte // Zero page indexed
    fun ZeroPageY(): UByte // Zero page indexed
    fun Abs(): UByte // Absolute
    fun AbsX(): UByte // Absolute indexed
    fun AbsY(): UByte // Absolute indexed

    // something
    fun step() // Move to next cycle
    fun reset() // Reset system
    fun irq() // Interrupt request signal
    fun nmi() // Non-maskable interrupt
}
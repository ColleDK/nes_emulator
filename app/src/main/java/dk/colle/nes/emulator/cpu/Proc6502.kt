package dk.colle.nes.emulator.cpu

import dk.colle.nes.emulator.bus.IBus

class Proc6502: IProc6502 {
    // Sealed class containing cpu register
    inner class CpuRegister {
        var a: UByte = 0x00u // accumulator
        var x: UByte = 0x00u // x index
        var y: UByte = 0x00u // y index
        var pc: UShort = 0x0000u // program counter
            get() = field++
        var sp: UByte = 0x00u // stack pointer
        var status: UByte = 0x00u // status
    }

    private var bus: IBus? = null
    private val register: CpuRegister = CpuRegister()

    override fun linkBus(bus: IBus) {
        this.bus = bus
    }

    override fun writeData(address: UShort, data: UByte) {
        bus?.writeData(address = address, data = data)
    }

    override fun readData(address: UShort): UByte {
        return bus?.readData(address) ?: 0x00u
    }

    override fun Implicit(): UByte {
        TODO("Not yet implemented")
    }

    override fun Immediate(): UByte {
        TODO("Not yet implemented")
    }

    override fun Relative(): UByte {
        TODO("Not yet implemented")
    }

    override fun Indirect(): UByte {
        TODO("Not yet implemented")
    }

    override fun IndirectZeroX(): UByte {
        TODO("Not yet implemented")
    }

    override fun IndirectZeroY(): UByte {
        TODO("Not yet implemented")
    }

    override fun ZeroPage0(): UByte {
        TODO("Not yet implemented")
    }

    override fun ZeroPageX(): UByte {
        TODO("Not yet implemented")
    }

    override fun ZeroPageY(): UByte {
        TODO("Not yet implemented")
    }

    override fun Abs(): UByte {
        TODO("Not yet implemented")
    }

    override fun AbsX(): UByte {
        TODO("Not yet implemented")
    }

    override fun AbsY(): UByte {
        TODO("Not yet implemented")
    }

    override fun step() {
        TODO("Not yet implemented")
    }

    override fun reset() {
        TODO("Not yet implemented")
    }

    override fun irq() {
        TODO("Not yet implemented")
    }

    override fun nmi() {
        TODO("Not yet implemented")
    }

    companion object {
        enum class FLAGS(num: Int){
            C(1 shl 0), // Carry bit
            Z(1 shl 1), // Zero
            I(1 shl 2), // Disable interrupt
            D(1 shl 3), // Decimal mode
            B(1 shl 4), // Break
            U(1 shl 5), // Unused
            V(1 shl 6), // Overflow
            N(1 shl 7), // Negative
        }
    }
}
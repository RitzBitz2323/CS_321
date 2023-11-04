## Five Classic Components of Computer
**Input**
	- Keyboard Network, serial parts, hard drive
**Output**
	- Monitor,  printer, serial port
**Memory**
	- RAM ( volatile storage )
**Datapath**
	- Pathways (busses) that take data from input to and from memory, and to output
**Control**
	- Circuitry that allows the computer to *decide* what to do next: what data do we need, what institution do we execute on the data, what we do with the result. 
___
## Measuring Performance

>CPU time = Cpu Clock Cycles x Clock Cycle Time
>Clock Cycle Time = 1 / Clock Rate
>CPU Time = CPU Clock Cycles / Clock Rate

- From this, it follows that to improve program peformance, either:
	- *Decrease Clock Cycles*
	- *Increase clock rate*
___
## The CPU Performance Equation

>Tme = Seconds/Program = (Instruction/Program) x (Clock cycles/instruction) x (Seconds/Clock cycles)

**Amdahl's Law**
`S(s) = 1 / ((1 - P ) + (P/s))`
Big s = speedup of prgoram
Little s = speedup of a portion of program
P = fraction of the program that can be sped up

s = 2: 2x speedup on the optimization portion
p = 2: Optimization applies to 20% of the program

**The Power Wall**
- In the mid eighties it started to become difficult to cool chips sufficiently
- Focus changed to multicore design from single thread performance
- Dynamic power
	- Energy is proportional to capacitive load times voltage squared
	- Energy = Power x Time
	- Power is proprtional to voltage<sup>2</sup> x frequency
		- Voltage and Frequency scale roughly linearly
	- Power is roughly proportional to voltage<sup>3</sup> + frequency<sup>3</sup>

**Static Power** 
- Transistors Leak
- Leakage is a phenomenon where in current moves through an "off" transistor
- 
- ***All of this led to multi core + lower clock frequencies.***
- ***Designing processors to be fast and also to be energy efficient are not mutually exclusive***



`
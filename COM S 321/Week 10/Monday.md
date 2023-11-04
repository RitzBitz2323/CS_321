## Pipelining
- Exploiting ILP - Instruction level parallelism
	- The idea that there exists parallelism between instructions in a program
	- Exploit it by:
		- Piplining - deeper pipelines  (theoretically) allows for higher through put but lead to more complexity in hardware and software ( specially compiler )
		- Multiple issues - starting multiple instructions at the same tim
- Multiple Issue
	- Dynamic Multiple Issue - hardware decides ( usually w/ computer help) which instructions to issue in a given cycle
		- Usually implies out of order execution
	- Static Multiple Issue - compiler schedules "issue slots" or "packets" of instructions
- Example extension of legv8 to allow dual issue
	- dual issue - aka 2 way static multiple issue
	- a packet may have:
		- 1 ALU or branch instruction, and 
		- 1 load or store
	- If an instruction (of any type) cannot run with another **available** instruction, the compile inserts a no-op (NOP)
	- Effectively, instructions are 64 bits wide, hence the name "VILW" aka very long instruction word aka "vectored instructions"

`for (i=0; i<1000; i++)`
	`a[i]++ `
i is in x9
a is in x10

ADD X9, XZR, XZR // init
loop:
SUBIS XZR, X9, #1000 // i - 1000 -> set flag
B.EQ end
LSL X11, X9, #3 // x11 = i * 8 
ADD X11, X11, X10 // X11 = a[i]
LDUR X12, [X11, #0] // X12 = a[i]
ADDI X12, X12, #1   // a[i] ++
STUR X12, [X11, #0] 
ADDI X9, X9, #1 //i++
B loop
end:

Scheduling for dual issue 
	One alu branch and one load/store
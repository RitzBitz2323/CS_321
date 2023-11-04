**Making a Procedure Call**
- In order to call a procedure, the program must*
	1. Place the parameters - *in Arm, parameters go in X0 - X7*
	2. Transfer Control - *That is, jump to the procedure using BL ( Branch and Links )*
	3. Allocate stack storage - *For saved registers, local variables*
	4. Perform calculation - *function body*
	5. Place result - *return value(s) go in X0 - X7*
	6. Return control to called - *BR ( branch to register ), First restore saved registers*
___
**Registers & Instructions to facilitate procedure calls**
- Registers
	- SP (stock pointer, X28)
	- FP (frame pointer, X29)
	- LR (link register, X30)
- Instructions
	- BR rg - "Branch to register" jumps to the instruction ***after*** the one indexed by reg. Almost always uses L
	- BL label - "Branch & link" jumps to label and stores *address of BL instruction* in LR aka the PC, program counter
- Other registers use conventions:
	- X0 - X7 -procedure parameters and return values, spill to stack if more are needed
	- X9 - X15 - Temporaries - Callee is not responsible for these
	- X19 - X27 - Saved registers - Callee must save them to the stack before using and restore them before returning
	- To implement a procedure ( Callee ):
	```
	//label
	myprocedure:
	//save any saved registers that we will use
	SUBI SP, SP, #8 x n // where n is the number of things we need to save
	STUR reg0, [SP, #0]
	STUR reg1, [SP, #8]
	.
	.
	.
	STUR regn-1, [SP, #8x(n-1)]
	// Procedure body
	Return value copied to X0 ( if applicable )
	// Restore saved registers
	LDUR regn-1, [SP, #8x(n-1)]
	LDUR reg1, [SP, #8]
	LDUR reg0, [SP, #0]
	ADDF SP, SP, #8xn
	BR LR // return to caller
	
	```

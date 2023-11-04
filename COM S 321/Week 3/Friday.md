## ARM Assembly
- ***Instruction Format***
	- R (register) instructions: Mnemonic  dest, src1 ,src 2 (ADD X3, X2, X1)
	- I ( immediate) instructions: Mnemonic dest, src , constant
	- D (data) instructions: Mnemonic reg [addr.reg, immediate offset].
		- addr.reg = pointer
		- immediate offset = "index"

- Registers are named X0 - X31 ( 32 registers, all 64 bits)
	- X31 is also called XZR - it is always zero ( aka zero register )

- Example
	- Compile the line of C code
		- y = x + a [15] + 7
			- y goes in x12
			- x is in x14
			- a is in x20
		- LDUR X12, [X20, #120]
			- 120 = 15x (byte size aka 8). // y = a[15]
		- ADD X12, X12, X14 // y = y + x
		- ADDI X12, X12, #7
			- Add immediate (constant)
			- pound for any number 

- Jumping ( branching )
	- B ( branch ) - unconditional jump to a label
	- CBZ - compare and branch if zero
	- CBNZ -compare and branch if not zero
		- Both take register and label
		- Labels are simpley labelname: ___

- Example
	`if (x == y) x++; else y++`
	- X in x19
	- y in x20

>SUB X21, X19, X20 // temp = x - y
>CBNZ X21,  Y-inc // if tmp !=0 go to y-inc
>ADDI, X19, #1 // x++
>B end // branch to end
>y-inc: ADDI X20, X20, #1 //branch label for y-inc
>end: // label for end up above

- Labels are actually named addresses

```
while(a[i])
	i++;

```
- A in x11
- i in x12
- if i = 7
	- 00...00111
	- shift three bits left
	- 00...0111000
	- 32 + 16 = 48 + 8 = 56
	- Base 10
	- 27 shift 3 left
	- 27000
	- shift == mult by base<sup>shift</sup>
- LSL (logical shift left)
- top:
- LSL X10, X12, #3 //temp =  i*=8
- ADD X10, X10, X11 /temp = a+i
- LDUR X10 [X10, #0]// temp = xtemp
- CBZ X10, end
- ADD X12, X12, #1
- B top
- end
- 

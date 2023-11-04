**To call a procedure ( Caller )**
```
// if neccesary, save temporaries
SUBI SP, SP, #8 * n // where n is number of things to save
STUR reg0 , [SP, #0] // store registers in the stack
STUR reg1, [SP, #8] 
.
.
.
STUR regn, [SP, #8 * x(n-1)]
// Place parameters positionially in X0 - X7
ADDI X0, Xn , #0
.
.
.
BL Procedure
// return value is now in X0
// restore saved registers ( if applicable )
LDUR regn-1, [SP, #8 x (n-1)]
.
.
.
LDUR reg1, [SP, #8]
LDUR reg0, [SP, #0]
ADDI SP, SP, #8 x n
``````

Example: 
//long long 64 bit type, long = 32 bit type 
long long fib(long long n )
{
	if(n < 2){
	return n;
	}
	return fib(n-1) + fib(n-2);
}

```
fib:
// any saved variables need to be backed up as well as temporary variables
CBZ X0, done //n == 0
SUBI X9, X0, #1
CBNZ X9, body // n == 1

done:
BR LR // input == output

body:
// stack
SUBI SP, SP, #24 // 3 things x 8 = 24 bytes of saved stuff
STUR LR, [SP, #0]
STUR X19, [SP, #8]
STUR X20, [SP, #16]
//save parameter
ADD X19, X0, XZR // Copy n to x19
SUBI X0, X0, #1 // parameter for first recursive call
BL fib
ADD X20, X0, XZR // save return value from first recursive call
SUBI X0, X19, #2
BL fib
ADD X0, X0, X20 //x0 = fibn - 1 + fibn x - 2
//restore stack
LDUR X20, [SP, #16]
LDUR X19, [SP, #8]
LDUR LR, [SP, #0]
ADDI SP, SP, #24
BR LR // return here instead of calling done
```
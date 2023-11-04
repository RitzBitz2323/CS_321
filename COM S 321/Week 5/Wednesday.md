1110 1010 000 | 0 1011 | 0000 00 | 01 010 |      0 1001
Opcode.               RM            shamt        Rn.         Rd
	11.                    5.               6               5                5

ANDS                    XII                               X10             X9

ANDS X9, X10, X11


1101 0011 011 | 0 0000 | 0011 11 | 01 001 | 0  1001
11 bit opcode.   rm 5.       shamt.   rn.          rd
LSL.                    X0           15               X9         X9
LSL  Rd, Rn, shamt

LSL X9, X9, #15

1101 0010 1 | 10 | 0 1111 1111 1111 111 | 0 1110
Opcode        ext.     Immediate      Rd
9                   2.             16                    5

MOVZ.         32 bit    32767            X14

MOVZ X14, #32767, LSL 32


1000 1011 000  | 0 1110     | 0000 00 | 01100 | 01000
							X14	rm.                         X12rn.          X8 rd
ADD X8, X12, X14

Rd = rn + rm


1101 0001 00| 000100000000 | 01011 | 01011
														X11 Rn.     Rd X11		
SUBI X11, X11, #256

Rd = Rn - aluim


1011 0101 | 1111111111111111111 | 00111
								-1						Rt X7

CBNZ X7, -1


1111 1000 010 | 000100000 |00 01111 01101
										.   
LDUR 

100101 1 1111111111111111111111101
## **Chapter 3**
***Integer multiplication ( like a computer )***

cost for multiplication = 1 + log(bit width) cycles


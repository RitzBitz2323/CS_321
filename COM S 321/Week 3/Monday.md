## Representation of Data

**Memory is a big array**
- From address 0 to address size of memory - 1
- There is no such thing physically as a 2-, 3-, etc. dimensional array
	- char a[x]/[y] // declare this
		- a[q]/[y] // where q < y + P < x and q,p >= 0
		- a + qx + p <-- address of a[q]/[p] and a[q]/[p]
		- Data at a + qx + p = (star)(a+qx+p)
		- = a[q]/[p]
	- int b[y]/[x] // declare an x * y array of int
		- b[q]/[p] = b +(size of (int) = 4 * (qx + p))
			- In C, compiler does the computation of above after b + for you 
			- In assembly, you have to do it by hand
	- int[z]/[y]/[x]  //declare
		- c[r]/[q]/[p]
		- c + rxy + qx + p

**Representing Integers**![[IMG_5926.png]]![[IMG_5931.png]]


*Two conventions for defining negativer numbers in binary*
	One's compliment
	Two's compliment
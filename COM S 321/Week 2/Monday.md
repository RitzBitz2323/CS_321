## How did computers become so fast?
---
### Solutions
- Design for the future
	- Predicting for future and makin sure it comes out all right
- Use abstraction effectively
- Design for the common case
- Exploit Parallelism
- Predict
	```
	int a[10];
	for(i = 0; i < 10; i++){
	a[i] = i;
	}
	```
	- Temporal Locality - a, i 
		- being re used 
		- if i need an address, ill have to use it soon
		- Once you use something you'll use it again soon.
	- Spatial Locality - elements in the array/a
		- If i access some point in an array than i will access the next point in the array as well
- Use Hierarchical structures
	- Main menory - 10<sup>5</sup> - 10<sup>6</sup> cycles latency
		- L3 cache - 1000 cycles
		- L2 cache - 100 cycles
		- L1 cache -10 cycles
- Be dependable

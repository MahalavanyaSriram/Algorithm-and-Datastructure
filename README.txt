Readme.txt file for Implementation of Lempel–Ziv–Welc compression algorithm  
created 6/3/2020 by Mahalavanya Sriram


* The algorithm implementation is done on JavaSE and JRE 1.8. 

* There are 3 packages 
	com.LZW.algorithm - main package consists of 3 classes 
		LZW - main method. Command Line inputs are taken and encoding or decoding classes are called accordingly.
		Encoding - Implements encoding of the input data read from the file and creates a dictionary and outputs the corresponding coded result.
		Decoding - Implements the decoding of the input stream of data read from the file and decompression of the data takes place and result is stored in a file again.
	
	com.LZW.model - model class
		InputObject- consists of two variables filename and its respective setters and getters
		
	com.LZW.util - utilities class that performs helper functions such  as reading and writing to a file
		ReadFile - methods to read a normal file and 16bit coded file
		WriteFile - method to write a string output to a file and 16bit coded stream of data too.

* To implement the main logic a hash map is used cause our algorithm requires data-structure that can easily store and retrieve values
  cause we create a dictionary in both the cases which is mainly based on store and retrieve data values
  
* the command line input of the code should be give appropriately which should contain keywords such as encode input1.txt 12
 program works for few other combinations such as java program encode input1.txt 12 and terminate. (encode input1.txt 12) should be found together
 
 * the code works for only text files as input not other files
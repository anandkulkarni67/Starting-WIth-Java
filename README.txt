PROJECT <1> README FILE

Author(s): <Anand Kulkarni>

PURPOSE:

[
  The project intends to read a xml file using only methods from String API and find element name(s) which occur most frequently.
]

PERCENT COMPLETE:

[
  I believe, I have completed 100% of this project.
]

PARTS THAT ARE NOT COMPLETE:

[
  None.
]

BUGS:

[
  None.
]

FILES:

[
  Included with this project are 4 files:

  Driver.java - the file which has the main method.
  FileProcessor.java - the file responsible for file operations.
  StringOperations.java - the file which contains the algorithm to find element name(s) with highest frequency.
  README.txt, the text file you are presently reading.
]

SAMPLE OUTPUT:

[
  remote01:~/design patterns/anand_kulkarni_assign1> cd Starting_With_Java/
  remote01:~/design patterns/anand_kulkarni_assign1/Starting_With_Java> cd src/
  remote01:~/design patterns/anand_kulkarni_assign1/Starting_With_Java/src> javac *.java
  remote01:~/design patterns/anand_kulkarni_assign1/Starting_With_Java/src> java Driver amazon.wsdl
  remote01:~/design patterns/anand_kulkarni_assign1/Starting_With_Java/src> java Driver amazon.wsdl
  The most frequently occurring elements are ABCD, QWER. They appear 14 times 
  remote01:~/design patterns/anand_kulkarni_assign1/Starting_With_Java/src> 
]

TO COMPILE:

[
  Steps for program compilation :
  1. Traverse inside the src folder by using following command :
	cd Starting_With_Java/src/
  2. Compile all java classes by using following command :	
	javac *.java
]

TO RUN:

[
  Steps for program execution :
  1. Execute following command to execute the program :
	java Driver <INPUT_FILE_PATH>
	For example : java Driver amazon.wsdl
]

DATA STRUCTURES:

[
  Following data structures are used :
  1. HashMap : 
	Time Complexity : Program required a data structure which stores key-value pairs. So, a HashMap is used to keep track of element names and number of times they occur in the file. It has time 				complexity of O(1) while inserting and retrieving elements.
  2. LinkedList : 
	Time Complexity : A Linked list data structure is used for storing element name(s) that occur most frequently. It is used to store element names in case more than one element name occurs most 			frequently. This program only performs insertion operations on the linked list which have a time complexity of O(1).
	Space Complexity : ArrayList and LinkedList both have its advantages and disadvantages. ArrayList causes wastage of memory due to frequent re-sizing where as LinkedList requires more memory to 			store references to next data elements.
]

EXTRA CREDIT:

[
  None.
]

BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
<Anand Kulkarni>

[
  None.
]

ACKNOWLEDGEMENT:

[
  None.
]

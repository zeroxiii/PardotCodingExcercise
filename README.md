# PardotCodingExcercise
# Candiate: Rahmaan Lodhia

Problem Statement: You are given a function 'secret()' that accepts a single integer parameter and returns an integer. In your favorite programming language, write a command-line program that takes one command-line argument (a number) and determines if the secret() function is additive [secret(x+y) = secret(x) + secret(y)], for all combinations x and y, where x and y are all prime numbers less than the number passed via the command-line argument.  Describe how to run your examples.

# Instructions

1. Download either the src folder or simply just the SecretAddtiveTest.java file from src folder.

2. On a computer running the latest version of Java (Note: this program was compiled using Java Version 1.8.0_71), open up terminal or command prompt and navigate to the directory housing the SecretAdditveTest.java file.

3. Compile the program first with the following command:

javac SecretAdditiveTest.java

4. The SecretAdditiveTest.class will be created in the working directory, and you can now run the java program with the following command:

java SecretAdditiveTest n

(Where “n” is any integer number. Inputting anything other than a number will result in an error message from the program. )

# Sample Outputs

Rahmaan-Lodhias-Macbook:bin rlodhia$ java SecretAdditiveTest 5
Testing All Combinations of Prime Numbers: [2, 3]
The Secret Function Has Succeeded With All Combination of Primes!
The Secret Function is Additive!

Rahmaan-Lodhias-Macbook:bin rlodhia$ java SecretAdditiveTest 50
Testing All Combinations of Prime Numbers: [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
The Secret Function Has Succeeded With All Combination of Primes!
The Secret Function is Additive!

Rahmaan-Lodhias-Macbook:bin rlodhia$ java SecretAdditiveTest 100
Testing All Combinations of Prime Numbers: [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
The Secret Function Has Succeeded With All Combination of Primes!
The Secret Function is Additive!

# Algorithm

The code was run with the following algorithm:

1. Parse first argument input from command line.  If the result is anything other than an Integer, throw an error message and exit the program.

2. The Integer argument is then passed into the program.  From the integer, an ArrayList of primes is calculated by the following method:
	a. Iterate through all numbers less than n.
	b. Check if a number is a prime.
		i. Primes are determined by looping 1 through sqrt(x), where x is the current number being tested.
		ii. If the test number is divisible by any of the numbers in the loop, it is not a prime.
	c. Add the number to an ArrayList if it is a prime.
	d. Return ArrayList of prime numbers to calling function.

3. The program will then loop through the ArrayList of Primes twice in a nested loop.  The outer loop will provide the values of x.  The inner loop will provide the values of y.  This in turn tests all possible combination of primes including duplicates (e.g. [3, 3], [5, 5]) and all permutations of pairs (e.g. [5, 3] and [3, 5]).  The program tests all of these inputs as it cannot be assumed that order of inputs does not affect the result, resulting in these somewhat redundant entries.  
	a. During each run of the inner loop, the additive test will be run: secret(x + y) == secret(x) + secret(y).
	b. If any result from the test is false, the loop will exit and the additive test will have failed.
	c. If all results pass, the function returns true.

4. The main function will take the results from the additive tests and display them to the user.

# Notes

The secret() function:
For this exercise, a sample secret() function was created within the SecretAdditiveTest class to test the functionality of the program.  The used secret() function is defined as:

public static int secret(int n)
{
	return n;
}


This function is additive, so all tests run should result in the number being additive.

If there is a desire to test a secret() function that is not additive, simply change secret() to:

public static int secret(int n)
{
	return n^2;
}

This function is not additive and should result in a test failure message.  Making this change in SecretAdditiveTest.java and recompiling will provide this result.

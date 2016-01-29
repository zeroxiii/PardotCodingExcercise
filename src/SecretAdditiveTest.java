/* Pardot Coding Excercise
 * Candidate: Rahmaan Lodhia
 * Secret Additive Test
 * Input: command=line Integer argument n
 * Output: True if the secret() function passes additive tests for all combination of primes less than n. False otherwise.
 */

// Import the ArrayList class
import java.util.ArrayList;

public class SecretAdditiveTest 
{

	public static void main(String[] args) 
	{
		int testArg;
		
		// Checks to see if there are command-line arguments.  If not, the program exits. 
		if (args.length > 0) 
		{
			// Checks to see if the given command-line argument is an Integer.  If not, an error is thrown and the program exits.
			try 
			{
				testArg = Integer.parseInt(args[0]);
				
				// If the input is valid, the Additive test is run and the resulting messages will be displayed
				if (isSecretAdditive(testArg))
					System.out.println("The Secret Function is Additive!");
				else
					System.out.println("The Secret Function is NOT Additive!");
			} 
			catch (NumberFormatException e)
			{
		        System.err.println("Argument " + args[0] + " must be an integer. All other inputs are ignored.");
		        System.exit(1);
			}
		}
		else
		{
			System.out.println("An integer argument is required for program to run.");
			System.exit(1);
		}	
	}

	/* 
	 * Returns a boolean stating whether the secret() function is additive given the test number.
	 * 
	 * @param n	This is the test number provided from the command-line.  A list of primes less than this number will be tested.
	 * @return	The result of the additive test.
	 */
	public static boolean isSecretAdditive(int n) 
	{
		// Generate list of primes to test
		ArrayList<Integer> testNumbers = getArrayOfPrimes(n);
		
		System.out.println("Testing All Combinations of Prime Numbers: " + testNumbers);
		
		// Loop through the list of primes twice to create all possible permutations between the prime numbers
		for (int x : testNumbers)
		{
			for (int y : testNumbers)
			{
				// For each combination of primes, test the secret() function's additive property
				System.out.printf("Testing [%d, %d]: ", x, y);
				
				// Return a result for each test, ending the loop if a failure is found
				if(!isAdditive(x, y))
				{
					System.out.println("False");
					System.out.println("The Secret Function Has Failed the Additive Test!");
					return false;
				}
				
				System.out.println("True");
			}
		}
		
		// If all combinations pass, the function passes the additive test
		System.out.println("The Secret Function Has Succeeded With All Combination of Primes!");
		return true;
	}
	
	/* 
	 * Returns a boolean stating whether the secret function is additive given two inputs.
	 * 
	 * @param x	This is the first input of the additive test.
	 * @param y This is the second input of the additive test.
	 * @return	The result of a single additive test.
	 */
	public static boolean isAdditive(int x, int y)
	{
		return (secret(x + y) == secret(x) + secret(y));
	}
	
	
	/* 
	 * Returns an ArrayList of all primes less than a number.
	 * 
	 * @param n	This is the test number. An ArrayList of primes less than this number will be generated.
	 * @return	The ArrayList of all primes less than n.
	 */
	public static ArrayList<Integer> getArrayOfPrimes(int n)
	{
		ArrayList<Integer> result = new ArrayList<>();
		
		// Loop through all numbers less than n, and check each one for primality
		for (int i = 1; i < n; i++)
		{
			if (isPrime(i))
				result.add(i);
		}
		
		return result;
	}
	
	/* 
	 * Returns a boolean stating whether the given number is a prime.
	 * 
	 * @param n	This is the integer that will be tested.
	 * @return	The result of the isPrime test.
	 */
	public static boolean isPrime(int n)
	{
		// Numbers less than 2 are not prime
		if (n < 2)
		{
			return false;
		}
		
		int sqrt = (int) Math.sqrt(n);
		
		// We loop up until sqrt(n) as any number past that is redundant to check
		for (int i = 2; i <= sqrt; i++)
		{
			if (n % i == 0)
				return false;
		}
		
		return true;
	}
	
	/* 
	 * Returns an integer result based on the secret() function. For purposes of this exercice, the result is just the number itself.
	 * 
	 * @param n	This is the integer input to the secret() function
	 * @return	The integer result of the defined secret() function.
	 */
	public static int secret(int n)
	{
		return n;
	}
}

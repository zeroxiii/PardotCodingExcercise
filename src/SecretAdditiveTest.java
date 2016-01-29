import java.util.ArrayList;

public class SecretAdditiveTest 
{

	public static void main(String[] args) 
	{
		int testArg;
		if (args.length > 0) 
		{
			try 
			{
				testArg = Integer.parseInt(args[0]);
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
		
	}

	public static boolean isSecretAdditive(int n) 
	{
		ArrayList<Integer> testNumbers = getArrayOfPrimes(n);
		
		System.out.println("Testing All Combinations of Prime Numbers: " + testNumbers);
		
		for (int x : testNumbers)
		{
			for (int y : testNumbers)
			{
				System.out.printf("Testing [%d, %d]: ", x, y);
				
				if(!isAdditive(x, y))
				{
					System.out.println("False");
					System.out.println("The Secret Function Has Failed the Additive Test!");
					return false;
				}
				
				System.out.println("True");
			}
		}
		
		System.out.println("The Secret Function Has Succeeded With All Combination of Primes!");
		return true;
	}
	
	public static boolean isAdditive(int x, int y)
	{
		return (secret(x + y) == secret(x) + secret(y));
	}
	
	public static ArrayList<Integer> getArrayOfPrimes(int n)
	{
		ArrayList<Integer> result = new ArrayList<>();
		
		for (int i = 1; i < n; i++)
		{
			if (isPrime(i))
				result.add(i);
		}
		
		return result;
	}
	
	public static boolean isPrime(int n)
	{
		if (n < 2)
		{
			return false;
		}
		
		int sqrt = (int) Math.sqrt(n);
		
		for (int i = 2; i <= sqrt; i++)
		{
			if (n % i == 0)
				return false;
		}
		
		return true;
	}
	
	public static int secret(int n)
	{
		return n;
	}
}

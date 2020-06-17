	import java.util.*; 																				//importing all java utilities
	public class DanielLam_100368469_Project1 {

		public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a credit card number as a long interger: ");							//lont int due to being 13 to 16 characters long
		long creditcard = input.nextLong();
		String NameOfCard = null;
		System.out.print(creditcard + " is " + (validity_check(creditcard) ? "valid. " : "invalid. ")); //will return either valid or invalid depending
		if (validity_check(creditcard) == true) {														//on the value of the boolean
			System.out.print("It is a " + (cardType(creditcard, NameOfCard))); 							//checks the card type and must be valid in order
		}																								//for the function to execute
		}
		
		public static boolean validity_check(long creditcard) {
			boolean valid = (checkNum(creditcard, 4) || checkNum(creditcard, 5)								// must be all true for the credit card
					|| checkNum(creditcard, 6) || checkNum2(creditcard, 37) && checkSize(creditcard)) && 	// to be valid
					((sumOfEven(creditcard) + sumOfOdd(creditcard)) % 10 == 0);
			return valid;																					//returns valid if all cases are true
		}
		
		public static boolean checkNum(long creditcard, int digit) {
			String number = "" + creditcard;										//converts the long to a string first
			char charFirstDigit = number.charAt(0);
			int FirstDigit = charFirstDigit - '0'; 									//converts the char back to an integer
			if (FirstDigit == digit)												//compares the char to the int
				return true;
			else
				return false;														//false if the digit is not a card type
		}
		
		public static boolean checkNum2(long creditcard, int digit) {
			String number = "" + creditcard;
			char charFirstDigit = number.charAt(0);			//converting the integer to a char first so that it can grab only the first number
			char charSecondDigit = number.charAt(1);
			int FirstDigit = charFirstDigit - '0';			//converting the char back to an integer so that it can be compared
			int SecondDigit = charSecondDigit - '0';
				if (FirstDigit == 3 && SecondDigit == 7) {				//37 is the only card with 2 digits therefore 2 cases
					return true;
					}
				else
					return false;
		}
		public static boolean checkSize(long creditcard) {
			int lengthOfCC = String.valueOf(creditcard).length();
			if (lengthOfCC >= 13 && lengthOfCC <=16) { 					//validates the length of the credit card
				return true;
			}
			else
				return false;
			}
		

		public static int sumOfEven(long creditcard)					//checks from the second last number from right to left
		{
			
			int total = 0;
			String str = Long.toString(creditcard);
			int lengthOfCC = str.length();
			for (int i = lengthOfCC - 2; i>= 0; i-=2) //declines by 2 can't read last char
				{
				total += doubledigit(Integer.parseInt(str.charAt(i) + "")); //converts string back to integer then sends
				}															//to method to see if 
			return total;
			
		}
		public static int sumOfOdd(long creditcard)						//checks from right to left from the last number
	{
			
			int total = 0;
			String str = Long.toString(creditcard);
			int lengthOfCC = str.length();
			for (int i = lengthOfCC - 1; i>= 0; i-=2) //can not read the last number so has to decline by 1
				{
				total += Integer.parseInt(str.charAt(i) + ""); // totals the odd numbers
				}
			return total; //sends total number back 
			
		}
		public static int doubledigit(int num) {
			num = num * 2;
			if (num >= 10)
				return num % 10 + num /10; //adds the remainder and 1, will not go above 18
			else
				return num;	//lower than 10, returns same number
		}
		
		public static String cardType(long creditcard, String NameOfCard)
		{
			String str = creditcard + "";						//checks what type of credit card the user has
			char firstDig = str.charAt(0);
			char secondDig = str.charAt(1);
			int num1 = firstDig - '0';
			int num2 = secondDig - '0';
			if (num1 == 4)
				NameOfCard = "Visa";
			else if (num1 == 5)
				NameOfCard = "Master cards";
			else if (num1 == 6)
				NameOfCard = "Discover Cards";
			else if (num1 == 3 && num2 == 7)
				NameOfCard = "American Express card";
			return NameOfCard;
		}
		}

package costa_p1;

public class Encrypter {

	public static String encrypt(int value) {
		// Encrypts 'value.' 
		// E.g.: 1234 -> 0189.
		
		// Getting each of the four digits of 'value.'
		int digit1 = (int) value / 1000;
		int digit2 = ((int) value / 100) % 10;
		int digit3 = ((int) value / 10) % 10;
		int digit4 = value % 10;
		
		// Adding 7 to each digit and then taking mod 10 of each.
		digit1 = (digit1 + 7) % 10;
		digit2 = (digit2 + 7) % 10;
		digit3 = (digit3 + 7) % 10;
		digit4 = (digit4 + 7) % 10;
		
		// Swapping the 1st and 3rd digits.
		int temp = digit1;
		digit1 = digit3;
		digit3 = temp;
		
		// Swapping the 2nd and 4th digits.
		temp = digit2;
		digit2 = digit4;
		digit4 = temp;
		
		// Concatenating integers.
		String s1 = Integer.toString(digit1);
		String s2 = Integer.toString(digit2);
		String s3 = Integer.toString(digit3);
		String s4 = Integer.toString(digit4);
		
		return s1 + s2 + s3 + s4;
	}
}

//-- PSEUDOCODE --
/* 
 * Get separates digits and store in 4 int variables (not going to use an array because
 * it is feasible to use 4 variables only).
 * 
 * Encrypting begins: Add 7 and mod 10 each digit.
 * 
 * Swap the appropriate digits (1st with the 3rd and the 2nd with the 4th).
 * 
 * Concatenate integers so that I can return the encrypted number.
 * 
 * */
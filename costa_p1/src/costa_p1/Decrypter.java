package costa_p1;

public class Decrypter {

	public static int decrypt(String value) {
		// Decrypts 'value.'
		// E.g.: 0189 -> 1234.
		
		int num = Integer.parseInt(value);
		
		// Getting each of the four digits of 'value.'
		int digit1 = (int) num / 1000;
		int digit2 = ((int) num / 100) % 10;
		int digit3 = ((int) num / 10) % 10;
		int digit4 = num % 10;
		
		// Swapping the 1st and 3rd digits.
		int temp = digit1;
		digit1 = digit3;
		digit3 = temp;
				
		// Swapping the 2nd and 4th digits.
		temp = digit2;
		digit2 = digit4;
		digit4 = temp;
		
		// Reversing the mod 10 operation.
		if (digit1 >= 0 && digit1 <= 6) {
			digit1 += 10;
		}
		
		if (digit2 >= 0 && digit2 <= 6) {
			digit2 += 10;
		}
		
		if (digit3 >= 0 && digit3 <= 6) {
			digit3 += 10;
		}
		
		if (digit4 >= 0 && digit4 <= 6) {
			digit4 += 10;
		}
		
		// Subtracting 7 from each digit.
		digit1 -= 7;
		digit2 -= 7;
		digit3 -= 7;
		digit4 -= 7;
		
		// Concatenating integers.
		String s1 = Integer.toString(digit1);
		String s2 = Integer.toString(digit2);
		String s3 = Integer.toString(digit3);
		String s4 = Integer.toString(digit4);
				
		String s = s1 + s2 + s3 + s4;
		return Integer.parseInt(s);
	}
}

//-- PSEUDOCODE --
/*
 * ---------------------------------------------------------------------------
 * OBS1: I'll do the reverse encrypting operation.
 * 
 * OBS2: Keep in mind that the greatest number a digit can become after adding 7
 * is 16 (this may help when understanding how I reversed the mod10 I did when
 * encrypting the original number).
 * ---------------------------------------------------------------------------
 *
 * Parse the string to integer so that I can get the individual digits as int already.
 *
 * Get each digit from the encrypted number.
 * 
 * Swap the appropriate digits.
 * 
 * Reverse the mod 10 operation and subtract seven from each digit.
 * 
 * Concatenate each digit so that I can return the decrypted number.
 * 
 * */

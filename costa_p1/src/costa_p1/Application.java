package costa_p1;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Getting user input (four-digit int).
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		// Encrypting...
		String encrypted_num = Encrypter.encrypt(num);
		System.out.println(encrypted_num);
		
		// Decrypting...
		int decrypted_num = Decrypter.decrypt(encrypted_num);
		System.out.println(decrypted_num);
	
	}
}

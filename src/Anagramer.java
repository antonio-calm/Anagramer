import java.util.Scanner;

public class Anagramer {
	public static void main(String [] args) {
		Scanner scan = new Scanner (System.in);
		
		System.out.print("Enter phrase: ");
		String phrase = scan.nextLine();
		
		String[] words = phrase.split(" ");
		
		for (String word : words) {
			System.out.print(reverse(word).concat(" "));
		}
	}
	
	private static String reverse(String word){
		final int WORD_LENGTH = word.length();
		
		char[] chars = word.toCharArray();
		char[] result = new char[WORD_LENGTH];
		
		for (int i = 0; i < WORD_LENGTH; i++) {
			if (!isLatinLetter(chars[i])){
				result[i] = chars[i];
			}
		}
		
		for (int i = 0; i < WORD_LENGTH; i++){
			if (isLatinLetter(chars[i])){
				
				for (int j = WORD_LENGTH - 1; j >= 0; j--){
					if (result[j] == 0) {
						result[j] = chars[i];
						break;
					}
				}
			}
		}
		return new String(result);
	}
	
	private static boolean isLatinLetter(char ch){
		if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
			return true;
		}
		return false;
		
	}
}

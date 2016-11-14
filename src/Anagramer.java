import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Anagramer {
	public static void main(String[] args) {
		try (InputStream inputStream = System.in;
				Reader inputStreamReader = new InputStreamReader(inputStream);
				BufferedReader reader = new BufferedReader(inputStreamReader)) {

			System.out.print("Enter text: ");
			String text = reader.readLine();
			String result = makeAnagramOfEachWord(text);
			System.out.println(result);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String makeAnagramOfEachWord(String text) {
		String delimiter = " ";
		String separator = " ";
		String[] words = text.split(delimiter);
		int numberOfWords = words.length;
		int lastWordIndex = numberOfWords - 1;

		StringBuilder builder = new StringBuilder();

		for (int wordIndex = 0; wordIndex < numberOfWords; wordIndex++) {
			String anagram = makeAnagramOfWord(words[wordIndex]);
			builder.append(anagram);

			if (wordIndex != lastWordIndex) {
				builder.append(separator);
			}
		}

		return builder.toString();
	}

	private static String makeAnagramOfWord(String word) {
		int wordLength = word.length();
		char[] chars = word.toCharArray();
		StringBuilder builder = new StringBuilder(wordLength);

		for (char ch : chars) {
			if (Character.isLetter(ch)) {
				builder.append(ch);
			}
		}

		builder.reverse();

		for (int charIndex = 0; charIndex < wordLength; charIndex++) {
			if (!Character.isLetter(chars[charIndex])) {
				builder.insert(charIndex, chars[charIndex]);
			}
		}

		return builder.toString();
	}
}
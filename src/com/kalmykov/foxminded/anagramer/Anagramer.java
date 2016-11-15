package com.kalmykov.foxminded.anagramer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Anagramer {
	public static void main(String[] args) throws IOException {
		Reader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(inputStreamReader);

			System.out.print("Enter text: ");
			String text = reader.readLine();
			String result = makeAnagramOfEachWord(text);
			System.out.println(result);


	}

	private static String makeAnagramOfEachWord(String text) {
		String delimiter = " ";
		String separator = " ";
		String[] words = text.split(delimiter);

		StringBuilder builder = new StringBuilder();

		for (String word : words) {
			String anagram = makeAnagramOfWord(word);
			builder.append(anagram);
			builder.append(separator);
		}

		builder.deleteCharAt(builder.length() - 1);

		return builder.toString();
	}

	private static String makeAnagramOfWord(String word) {
		char[] chars = word.toCharArray();
		StringBuilder builder = new StringBuilder(word.length());

		for (char ch : chars) {
			if (Character.isLetter(ch)) {
				builder.append(ch);
			}
		}

		builder.reverse();

		for (int charIndex = 0; charIndex < word.length(); charIndex++) {
			char ch = chars[charIndex];
			if (!Character.isLetter(ch)) {
				builder.insert(charIndex, ch);
			}
		}

		return builder.toString();
	}
}
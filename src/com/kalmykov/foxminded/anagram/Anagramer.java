package com.kalmykov.foxminded.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Anagramer {
	private static final String DELIMITING_REGEXP = " ";
	private static final char WORDS_SEPARATOR = ' ';

	public static void main(String[] args) throws IOException {
		Reader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(inputStreamReader);

		System.out.print("Enter text: ");
		String text = reader.readLine();

		String anagram = getAnagram(text);

		System.out.println(anagram);
	}

	private static String getAnagram(String text) {
		String[] words = text.split(DELIMITING_REGEXP);

		StringBuilder anagramBuilder = new StringBuilder();

		for (String word : words) {
			String anagram = getAnagramFromWord(word);
			anagramBuilder.append(anagram);
			anagramBuilder.append(WORDS_SEPARATOR);
		}

		anagramBuilder.deleteCharAt(anagramBuilder.length() - 1);

		return anagramBuilder.toString();
	}

	private static String getAnagramFromWord(String word) {
		char[] chars = word.toCharArray();
		StringBuilder anagramBuilder = new StringBuilder();

		for (char ch : chars) {
			if (Character.isLetter(ch)) {
				anagramBuilder.append(ch);
			}
		}

		anagramBuilder.reverse();

		for (int charIndex = 0; charIndex < word.length(); charIndex++) {
			char ch = chars[charIndex];
			if (!Character.isLetter(ch)) {
				anagramBuilder.insert(charIndex, ch);
			}
		}

		return anagramBuilder.toString();
	}
}
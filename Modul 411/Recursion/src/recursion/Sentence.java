package recursion;

public class Sentence {
	private String text;

	/**
	 * Constructs a sentence.
	 * 
	 * @param aText the stripped sentence
	 */
	public Sentence(String aText) {
		text = aText;
	}

	/**
	 * Tests for a palindrome.
	 * 
	 * @return true if is a palindrome
	 */
	public boolean isPalindrome() {
		return isPalindrome(0, text.length() - 1);
	}
	
	/**
	Testet einen Substring auf Palindrom.
	@param start Index des ersten Zeichens des Substrings
	@param stop Index des letzten Zeichens des Substrings
	@return true falls Substring ein Palindrom ist
	*/
	public boolean isPalindrome(int start, int end) {
		if (text.substring(start, end).length() <= 1) {
			return true;
		} else if (!Character.isAlphabetic(text.charAt(start))) {
			return isPalindrome(start + 1, end);
		} else if (!Character.isAlphabetic(text.charAt(end))) {
			return isPalindrome(start, end - 1);
		} else if (text.toLowerCase().charAt(start) == text.toLowerCase().charAt(end)) {
			return isPalindrome(start + 1, end - 1);
		}
		return false;
	}
}

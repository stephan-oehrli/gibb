package recursion;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class SentenceTest {
	
	@Test
	public void sugusShouldBeAPalindrome() {
		Sentence sentence = new Sentence("Sugus!");
		assertTrue(sentence.isPalindrome());
	}

	@Test
	public void madamShouldBeAPalindrome() {
		Sentence sentence = new Sentence("Madam, I'm Adam.");
		assertTrue(sentence.isPalindrome());
	}
	
	@Test
	public void Sentence1ShouldBeAPalindrome() {
		Sentence sentence = new Sentence("A man, a plan, a canal, Panama!");
		assertTrue(sentence.isPalindrome());
	}
	
	@Test
	public void Sentence2ShouldBeAPalindrome() {
		Sentence sentence = new Sentence("Go hang a salami, I'm a lasagna hog.");
		assertTrue(sentence.isPalindrome());
	}
}

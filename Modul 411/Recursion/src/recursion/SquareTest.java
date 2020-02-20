package recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SquareTest {
	
	@Test
	public void getAreaShouldReturn4() {
		Square square = new Square(2);
		assertEquals(4, square.getArea());
	}
	
	@Test
	public void getAreaShouldReturn1() {
		Square square = new Square(1);
		assertEquals(1, square.getArea());
	}
	
	@Test
	public void getAreaShouldReturn0() {
		Square square = new Square(-1);
		assertEquals(0, square.getArea());
	}
	
	@Test
	public void getAreaShouldReturn64() {
		Square square = new Square(8);
		assertEquals(64, square.getArea());
	}
}

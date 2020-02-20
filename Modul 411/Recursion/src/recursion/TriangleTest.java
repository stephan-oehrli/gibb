package recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TriangleTest {
	
	@Test
	public void getAreaShouldReturn6() {
		Triangle triangle = new Triangle(3);
		assertEquals(6, triangle.getArea());
	}
	
	@Test
	public void getAreaShouldReturn1() {
		Triangle triangle = new Triangle(1);
		assertEquals(1, triangle.getArea());
	}
	
	@Test
	public void getAreaShouldReturn0() {
		Triangle triangle = new Triangle(-1);
		assertEquals(0, triangle.getArea());
	}

}

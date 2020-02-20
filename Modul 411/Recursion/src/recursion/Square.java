package recursion;

public class Square {
	
	private int width;
	
	public Square(int width) {
		this.width = width; 
	}

	public int getArea() {
		if (width == 1) return 1;
		if (width <= 0) return 0;
		Square square = new Square(width - 1);
		int border = width + width - 1;
		return square.getArea() + border;
	}
}

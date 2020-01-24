
/**
 * Problem: Check if two rectangles are overlapping with each other or
 * not(Collision Detection technique)
 * 
 * Solution: 1. Left edge of A is to the right of right edge of B 2. Right edge
 * of A is to the left of left edge of B 3. Top edge of A is below bottom edge
 * of B 4. Bottom edge of A is above top edge of B
 * 
 * References:
 * https://javarevisited.blogspot.com/2016/10/how-to-check-if-two-rectangle-overlap-in-java-algorithm.html
 **/

public class RectangleOverlap {

	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	private static class Rectangle {
		private final Point topLeft;
		private final Point bottomRight;

		public Rectangle(Point topLeft, Point bottomRight) {
			this.topLeft = topLeft;
			this.bottomRight = bottomRight;
		}

		private boolean isOverLapping(Rectangle other) {
			return this.topLeft.x > other.bottomRight.x // R1 is right to R2
					|| this.bottomRight.x < other.topLeft.x // R1 is left to R2
					|| this.topLeft.y < other.bottomRight.y // R1 is above R2
					|| this.bottomRight.y > other.topLeft.y;// R1 is below R1
		}
	}

	public static void main(String[] args) {
		Point l1 = new Point(0, 10);
		Point r1 = new Point(10, 0);
		Point l2 = new Point(5, 5);
		Point r2 = new Point(15, 0);

		Rectangle first = new Rectangle(l1, r1);
		Rectangle second = new Rectangle(l2, r2);

		if (first.isOverLapping(second))
			System.out.println("Yes, two rectangles are intersecting with each other");
		else
			System.out.println("No, two rectangles are not overlapping with each other");

	}
}

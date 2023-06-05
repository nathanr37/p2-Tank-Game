
public class Walls {
	private int x;
	private int y;
	private int width;
	private int height;
	public Walls(int ex, int wy, int w, int h) { //wall objects to make it easier for collision
		x = ex;
		y = wy;
		width = w;
		height = h;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}

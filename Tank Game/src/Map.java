import java.util.ArrayList;

//map class to store all wall objects for specific maps in one list for easy access
public class Map {
	ArrayList<Walls> map;
	public Map() {
		map = new ArrayList<Walls>();
	}
	public void addWall(int x, int y, int width, int height) {
		map.add(new Walls(x, y, width, height));
	}
	public ArrayList<Walls> getMap(){
		return map;
	}
}

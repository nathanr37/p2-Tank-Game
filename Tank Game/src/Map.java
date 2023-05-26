import java.util.ArrayList;

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

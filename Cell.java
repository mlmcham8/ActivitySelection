import java.util.ArrayList;
import java.util.List;

public class Cell {
	
	private int x; // The x coordinate of the cell
	private int y; // The y coordinate of the cell
	private Character vertex; // The character of the cell
	boolean seen;
	
	// The list of this cell's neighboring cells
	private List<Cell> neighbors = new ArrayList<Cell>();
	
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Character getCharacter() {
		return vertex;
	}

	public boolean isSeen(Cell c){
		return c.seen = true;
	}
	public void setCharacter(Character character) {
		this.vertex = character;
	}

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public List<Cell> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Cell> neighbors) {
		this.neighbors = neighbors;
	}

	public void addNeighbor(Cell cell) {
		this.neighbors.add(cell);
	}
}
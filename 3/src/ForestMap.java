import java.util.List;

public class ForestMap {

	private List<List<Boolean>> map;
	
	private int columncount;
	
	private int rowcount;
	
	private int rightsteps;
	
	private int downsteps;

	public List<List<Boolean>> getMap() {
		return map;
	}

	public void setMap(List<List<Boolean>> map) {
		this.map = map;
	}

	public int getColumncount() {
		return columncount;
	}

	public void setColumncount(int columncount) {
		this.columncount = columncount;
	}

	public int getRowcount() {
		return rowcount;
	}

	public void setRowcount(int rowcount) {
		this.rowcount = rowcount;
	}

	public int getRightsteps() {
		return rightsteps;
	}

	public void setRightsteps(int rightsteps) {
		this.rightsteps = rightsteps;
	}

	public int getDownsteps() {
		return downsteps;
	}

	public void setDownsteps(int downsteps) {
		this.downsteps = downsteps;
	}
	
}

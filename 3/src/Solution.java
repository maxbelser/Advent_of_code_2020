import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	static ForestMap map;
	
	private static final int FIRST_PROBLEM_STEPS_RIGHT = 3;
	private static final int FIRST_PROBLEM_STEPS_DOWN = 1;
	

	public static void main(String[] args) throws IOException {
		
		map = readInput();
		map.setDownsteps(FIRST_PROBLEM_STEPS_DOWN);
		map.setRightsteps(FIRST_PROBLEM_STEPS_RIGHT);

		System.out.println(firstProblem());
    }
	
	public static ForestMap readInput() throws IOException {
		ForestMap map = new ForestMap();
		List<List<Boolean>> input = new ArrayList<>();

        final var br = new BufferedReader(new FileReader("resources\\input\\input.txt"));
        String line;
        int i = 0;
        int linelength = 0;
        while ((line = br.readLine()) != null) {
        	if(i == 0) {
        		linelength = line.length();
        	}
        	for(int k = 0; k < line.length(); k++) {
        		input.add(new ArrayList<>());
            	if(line.charAt(k) == '.') {
            		input.get(i).add(false);
            	}
            	else {
            		input.get(i).add(true);
            	}
            }
            i++;
        }
        
        br.close();
        
        int rowcount = i;
        
        map.setMap(input);
        map.setColumncount(linelength);
        map.setRowcount(rowcount);
        
        return map;
    }
	
	private static int firstProblem() {
		int result = 0;
		int currentColumn = 0;
		for(int i = FIRST_PROBLEM_STEPS_DOWN; i < map.getRowcount(); i = i + FIRST_PROBLEM_STEPS_DOWN) {
			currentColumn += FIRST_PROBLEM_STEPS_RIGHT;
			if(currentColumn >= map.getColumncount()) {
				currentColumn = TreecountUtil.mutateColumn(currentColumn, map.getColumncount());
			}
			if(map.getMap().get(i).get(currentColumn)) {
				result++;
			}
		}
		return result;
	}
	
}

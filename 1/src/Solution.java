
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
	
    private final static int SUM = 2020;
    
    private static List<Integer> input;

    public static void main(String[] args) throws IOException {
        input = readInput();
        
        System.out.println(firstSolution());
        
        System.out.println(secondSolution());
    }

    public static List<Integer> readInput() throws IOException {
        List<Integer> input = new ArrayList<>();

        final var br = new BufferedReader(new FileReader("resources\\input\\input.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            input.add(Integer.parseInt(line));
        }
        
        return input;
        
    }
    
    private static int firstSolution() {
    	int result = 0;
    	int size = input.size();
    	int k;
    	for(int i = 0; i < size; i++) {
    		int a = input.get(i);
    		for(k = i + 1; k < size; k++) {
    			int b = input.get(k);
    			if(a+b == 2020) {
    				result = a * b;
    				break;
    			}
    		}
    		if(result != 0) {
    			break;
    		}
    	}
    	
    	return result;
    }
    
    private static int secondSolution() {
    	int result = 0;
    	int size = input.size();
    	int k, j;
    	for(int i = 0; i < size; i++) {
    		int a = input.get(i);
    		for(k = i + 1; k < size; k++) {
    			int b = input.get(k);
    			for(j = k + 1; j < size; j++) {
    				int c = input.get(j);
    				if(a+b+c == 2020) {
    					result = a * b *c;
    					break;
    				}
    			}
    			if(result != 0) {
    				break;
    			}
    		}
    		if(result != 0) {
    			break;
    		}
    	}
    	
    	return result;
    }
}
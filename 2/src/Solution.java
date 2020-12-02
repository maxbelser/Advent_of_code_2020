import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	private static List<PasswordValidaton> input;
	
	public static void main(String[] args) throws IOException {
        input = readInput();
        validatePasswords();
        System.out.println(input.stream().filter(x -> x.isFirstValid()).count());
        System.out.println(input.stream().filter(x -> x.isSecondValid()).count());
    }
	
	public static List<PasswordValidaton> readInput() throws IOException {
        List<PasswordValidaton> input = new ArrayList<>();

        final var br = new BufferedReader(new FileReader("resources\\input\\input.txt"));
        String line;
        while ((line = br.readLine()) != null) {
        	PasswordValidaton pwValidation = new PasswordValidaton();
            String[] splittedLine = line.split(" ");
            String[] splitagain = splittedLine[0].split("-");
            pwValidation.setMinNumber(Integer.parseInt(splitagain[0]));
            pwValidation.setMaxNumber(Integer.parseInt(splitagain[1]));
            pwValidation.setLetter(splittedLine[1].charAt(0));
            pwValidation.setPassword(splittedLine[2]);
            
            input.add(pwValidation);
            
        }
        
        return input;
        
    }
	
	private static void validatePasswords() {
		for(PasswordValidaton pwV : input) {
			pwV.firstValidation();
			pwV.secondValidation();
		}
	}

}

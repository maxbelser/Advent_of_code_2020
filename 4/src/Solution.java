import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		List<Passport> pp = readInput();
		
		int countValid1 = 0;
		int countValid2 = 0;
		
		for(Passport p : pp) {
			if(p.validatePart1()) {
				countValid1++;
			}
			if(p.validatePart2()) {
				countValid2++;
			}
		}

		System.out.println(countValid1);
		System.out.println(countValid2);
    }
	
	public static List<Passport> readInput() throws IOException {
		List<Passport> list = new ArrayList<>();
		
		final var br = new BufferedReader(new FileReader("resources\\input\\input.txt"));
		
		String line;
		
		Passport passport = new Passport();
		
		
		while ((line = br.readLine()) != null) {
        	
			PassportKey[] keys = PassportKey.values();
			
			if(line.length() > 0) {	
				String[] split = line.split(" ");
				for (int i = 0; i < split.length;  i++) {
					String[] characteristics = split[i].split(":");
					
					switch(PassportKey.searchEnum(PassportKey.class, characteristics[0])) {
					case BYR:
						passport.setBirthYear(characteristics[1]);
						break;
					case IYR:
						passport.setIssueYear(characteristics[1]);
						break;
					case EYR:
						passport.setExpirationYear(characteristics[1]);
						break;
					case HGT:
						passport.setHeight(characteristics[1]);
						break;
					case HCL:
						passport.setHairColor(characteristics[1]);
						break;
					case ECL:
						passport.setEyeColor(characteristics[1]);
						break;
					case PID:
						passport.setPassportID(characteristics[1]);
						break;
					case CID:
						passport.setCountryID(characteristics[1]);
						break;
					default:
						break;
					}
				}
				
	        }
			else {
				Passport finishedPassport = new Passport();
				finishedPassport = passport;
				list.add(finishedPassport);
				passport = new Passport();
			}
		}
		
		list.add(passport);
		
		br.close();
		
		return list;
    }

}

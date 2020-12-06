import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Passport {
	
	private String birthYear;
	
	private String issueYear;
	
	private String expirationYear;
	
	private String height;
	
	private String hairColor;
	
	private String eyeColor;
	
	private String passportID;
	
	private String countryID;

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getIssueYear() {
		return issueYear;
	}

	public void setIssueYear(String issueYear) {
		this.issueYear = issueYear;
	}

	public String getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getPassportID() {
		return passportID;
	}

	public void setPassportID(String passportID) {
		this.passportID = passportID;
	}

	public String getCountryID() {
		return countryID;
	}

	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}
	
	public boolean validatePart1() {
		if(birthYear == null) return false;
		if(expirationYear == null) return false;
		if(eyeColor == null) return false;
		if(hairColor == null) return false;
		if(height == null) return false;
		if(issueYear == null) return false;
		if(passportID == null) return false;
		
		return true;
	}
	
	public boolean validatePart2() {
		if(!validateBirthYear()) return false;
		if(!validateIssueYear()) return false;
		if(!validateExpirationYear()) return false;
		if(!validateHeight()) return false;
		if(!validateHairColor()) return false;
		if(!validateEyeColor()) return false;
		if(!validatePassportID()) return false;
		return true;
	}
	
	private boolean validateBirthYear() {
		if(birthYear ==  null) {
			return false;
		}
		try {  
		    int x = Integer.parseInt(birthYear);
		    if(!(x >= 1920 && x <= 2002)) {
		    	return false;
		    }
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		 }  
	}
	private boolean validateIssueYear() {
		if(issueYear ==  null) {
			return false;
		}
		try {  
		    int x = Integer.parseInt(issueYear);
		    if(!(x >= 2010 && x <= 2020)) {
		    	return false;
		    }
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		 }  

	}
	private boolean validateExpirationYear() {
		if(expirationYear ==  null) {
			return false;
		}
		try {  
		    int x = Integer.parseInt(expirationYear);
		    if(!(x >= 2020 && x <= 2030)) {
		    	return false;
		    }
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		 }
	}
	private boolean validateHeight() {
		if(height ==  null) {
			return false;
		}
		String sub1 = height.substring(0, height.length() - 2);
		String sub2 = height.substring(height.length() - 2);
		
		try {  
		    int x = Integer.parseInt(sub1);
		    if(sub2.equals("cm")) {
		    	if(!(x >= 150 && x <= 193)) {
			    	return false;
			    }
		    }
		    else if(sub2.equals("in")) {
		    	if(!(x >= 59 && x <= 76)) {
			    	return false;
			    }
		    }
		    else {
		    	return false;
		    }
		    
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		 }
	}
	private boolean validateHairColor() {
		if(hairColor ==  null) {
			return false;
		}

		Pattern pattern = Pattern.compile("^#[a-fA-F0-9]{6}");
		return pattern.matcher(hairColor).matches();
	}
	private boolean validateEyeColor() {
		if(eyeColor ==  null) {
			return false;
		}
		List<String> possibleEyeColors = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
		//possibleEyeColors.stream().anyMatch(posEyeCol -> posEyeCol.equals(eyeColor));
		
		boolean xy = false;
		for(String s : possibleEyeColors) {
			if(s.equals(eyeColor)) {
				xy = true;
			}
		}
		return xy;
	}
	
	private boolean validatePassportID() {
		if(passportID == null || passportID.length() != 9) {
			return false;
		}
		try {  
		    Integer.parseInt(passportID);

		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		 }
	}
}

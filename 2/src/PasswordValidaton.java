
public class PasswordValidaton {
	
	private int minNumber;
	
	private int maxNumber;
	
	private char letter;
	
	private String password;
	
	private boolean isFirstValid = false;
	
	private boolean isSecondValid = false;
	
	private int occurences = 0;

	public void setMinNumber(int minNumber) {
		this.minNumber = minNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isFirstValid() {
		return isFirstValid;
	}

	public void setFirstValid(boolean isFirstValid) {
		this.isFirstValid = isFirstValid;
	}

	public boolean isSecondValid() {
		return isSecondValid;
	}

	public void setSecondValid(boolean isSecondValid) {
		this.isSecondValid = isSecondValid;
	}

	public void setOccurences(int occurences) {
		this.occurences = occurences;
	}
	
	public void firstValidation() {
		for(int i = 0; i < password.length(); i++) {    
			if(password.charAt(i) == letter)    
				occurences++;    
		}
		if(occurences >= minNumber && occurences <= maxNumber) {
			setFirstValid(true);
		}
	}
	
	public void secondValidation() {
		setSecondValid(password.charAt(minNumber - 1) == letter ^ password.charAt(maxNumber - 1) == letter);
	}
}

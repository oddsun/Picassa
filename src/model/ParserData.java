package model;

public class ParserData {
	public int myCurrentPosition;
	public String myInput;

	public ParserData(String input, int pos) {
		myInput = input;
		myCurrentPosition = pos;
	}
	
	public void skipWhiteSpace() {
		while (notAtEndOfString() && Character.isWhitespace(currentCharacter())) {
			myCurrentPosition++;
		}
	}
	
	public char currentCharacter() {
		return myInput.charAt(myCurrentPosition);
	}

	public boolean notAtEndOfString() {
		return myCurrentPosition < myInput.length();
	}
}
package model;

public class ParserData {
	public int myCurrentPosition;
	public String myInput;
	public boolean isLet;

	public ParserData(String input, int pos) {
		myInput = input;
		myCurrentPosition = pos;
		isLet = false;
	}
}
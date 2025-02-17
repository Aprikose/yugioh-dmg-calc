package com.YuGiOhTournament;

public class LPCalcFormDigits {
	
	private int 	x;
	private char 	digit = ' ';
	private String 	action;
	private boolean intro_ended = false;
	
//X GET & SET 
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
//DIGIT GET & SET 
	public char getDigit() {
		return digit;
	}
	public void setDigit(char digit) {
		this.digit = digit;
	}
//ACTION GET & SET 
	public String getAction() {
		return this.action;
	}
	public void setAction(String action) {
		this.action = action;
	}
//INTRO ENDED GET & SET
	public boolean getIntro_ended() {
		return this.intro_ended;
	}
	public void setIntro_ended(boolean intro_ended) {
		this.intro_ended = intro_ended;
	}
	
}

package com.YuGiOhTournament;

public class LPCalcFormData {
	
	private int 	lpP1;
	private int		lpP2;
	private int 	x;
	private char 	digit = ' ';
	private String 	action;
	private boolean intro_ended; // = false;
	
//LP GET & SET 
	public int getLpP1() {
		return lpP1;
	}
	public void setLpP1(int lpP1) {
		this.lpP1 = lpP1;
	}
	public int getLpP2() {
		return lpP2;
	}
	public void setLpP2(int lpP2) {
		this.lpP2 = lpP2;
	}
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

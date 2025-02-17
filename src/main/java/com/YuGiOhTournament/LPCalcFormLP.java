package com.YuGiOhTournament;

public class LPCalcFormLP {
	
	private int 	lp;
	private String 	action;
	private boolean intro_ended = false;
	
//LP GET & SET 
	public int getLp() {
		return lp;
	}
	public void setLp(int lp) {
		this.lp = lp;
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

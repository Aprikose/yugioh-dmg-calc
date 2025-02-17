package com.YuGiOhTournamentBackend;

import java.util.ArrayList;

public class LPCalc {

//Player ID?
	
//default 8000 LP
	protected int m_lp = 8000;	
//History
	protected ArrayList<LPCalcHistory> m_history = new ArrayList<LPCalcHistory>();
		
//Constructor
	public LPCalc(  ){};
//Constructor mit Start LP Parameter
	public LPCalc( int lp ){
		this.m_lp = lp;
	};
//Aktuelle LP holen
	public int lp_get(  ) {
		return m_lp;
	}
//LP setzen
	public void lp_set( int lp_new ) throws Exception {
		lp_history_write( this.m_lp, ' ', 0, lp_new );
		this.m_lp = lp_new;
		if(this.m_lp <= 0) {
			throw new Exception( "Game Over" );
		}
	}
	//LP halbieren
	public void lp_halve(  ) throws Exception{
		int x = this.m_lp / 2;
		if(x*2 != this.m_lp) {	//aufrunden bei dezimal Zahlen
			x++;
		}
		lp_history_write( this.m_lp, '/', 2, x );
		this.m_lp = x;
	}
//LP verdoppeln
	public void lp_double() throws Exception{
		lp_history_write( this.m_lp, '*', 2, this.m_lp * 2 );
		this.m_lp *= 2;
	}
//LP hinzufügen
	public void lp_add( int x ) throws Exception{
		lp_history_write( this.m_lp, '+', x, this.m_lp + x );
		this.m_lp += x;
	}
//LP abziehen
	public void lp_subtract( int x ) throws Exception{
		lp_history_write( this.m_lp, '-', x, this.m_lp - x );
		this.m_lp -= x;
		if(this.m_lp <= 0) {
			throw new Exception( "Game Over" );
		}
	}
//History schreiben
	public void lp_history_write( int 	lp_old, 
								  char 	operation,
								  int	x,
								  int 	lp_new ){
		this.m_history.add( new LPCalcHistory( lp_old, operation, x, lp_new ) );
	}
		
	public ArrayList<String> lp_history_get(){
		ArrayList<String> history_string = new ArrayList<String>();
		for ( int i = 0; i < this.m_history.size(); i++) {
			history_string.add( this.m_history.get(i).history_get() );
		}
		
		return history_string;
	}

}

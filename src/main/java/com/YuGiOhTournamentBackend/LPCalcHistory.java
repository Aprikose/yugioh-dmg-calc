package com.YuGiOhTournamentBackend;

public class LPCalcHistory {
	//lp_old 	operation 	x 		--> lp_new
	//8000		-			1500 	--> 6500
		private int 	lp_old;
		private char 	operation; //+, -, *, /
		private int		x;
		private int 	lp_new;
		
		LPCalcHistory( int 	lp_old, 
				 char 	operation,
				 int	x,
				 int 	lp_new ){
			this.lp_old 	= lp_old;
			this.operation 	= operation;
			this.x 			= x;
			this.lp_new 	= lp_new;
		}
		
		LPCalcHistory( int lp_old,
				 int lp_new ){
			this.lp_old = lp_old;
			this.lp_new = lp_new;
		}
		
		public String history_get( ){
			String history = String.valueOf(this.lp_old);
			if( this.operation 	!= ' ' &&
				this.x			!= 0 ) {
				history += " " + this.operation + " " + this.x;
			}
			history += " --> " + String.valueOf(this.lp_new);
			return history;
		}
}

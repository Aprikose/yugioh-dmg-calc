package com.YuGiOhTournament;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LPCalcController {
	
	private com.YuGiOhTournamentBackend.LPCalc 	m_p1;					//Backendklasse für Calculator Player 1
	private com.YuGiOhTournamentBackend.LPCalc 	m_p2;					//Backendklasse für Calculator Player 2
	private LPCalcFormData 						m_lpCalcFormData;		//Datenmodell für MVC
	private boolean 							m_intro_ended;			//Flag für Visibility Steuerung Intro Video und Calculator
	

	@GetMapping("/LPCalc")
	public String LPCalc(@RequestParam(name="skip_intro", required=false, defaultValue="false") boolean skip_intro, Model model){
		//Calculator instanziieren
		if(this.m_p1 == null) {
			this.m_p1 = new com.YuGiOhTournamentBackend.LPCalc( 16000 );
		}
		if(this.m_p2 == null) {
			this.m_p2 = new com.YuGiOhTournamentBackend.LPCalc( 16000 );
		}
		//Frontend Datenklasse instanziieren
		if(this.m_lpCalcFormData == null) {
			this.m_lpCalcFormData = new LPCalcFormData();
			this.m_lpCalcFormData.setLpP1(this.m_p1.lp_get());
			this.m_lpCalcFormData.setLpP2(this.m_p2.lp_get());
			this.m_intro_ended = skip_intro;
			this.m_lpCalcFormData.setIntro_ended(this.m_intro_ended);
		}
		//Frontend Datenklassen zum Model hinzufügen
		if(model.containsAttribute("lpCalcFormData") == false){
			model.addAttribute("lpCalcFormData", this.m_lpCalcFormData);
		}
		return "LPCalc";
	}
	
	@PostMapping("/LPCalc")
	public String LPCalcSubmit(@ModelAttribute("lpCalcFormData") LPCalcFormData lpCalcFormData) {
		handleAction(lpCalcFormData);
		return "LPCalc";
	}
	
	private void handleAction(LPCalcFormData lpCalcFormData) {
		
		String 	action 		= lpCalcFormData.getAction();
		int 	lpP1 		= lpCalcFormData.getLpP1();
		int 	lpP2 		= lpCalcFormData.getLpP2();
		int 	x 			= lpCalcFormData.getX();
		char 	digit_c 	= lpCalcFormData.getDigit();
		boolean intro_ended = lpCalcFormData.getIntro_ended();
		
		int x_current 	= 0;
		int x_new		= 0;
		
		if(intro_ended == true) {
			this.m_intro_ended = intro_ended;
		}
		lpCalcFormData.setIntro_ended(this.m_intro_ended);
		
		if(digit_c != ' ') {
			int	digit_i	= digit_c - '0';	//char zu int konvertieren
			if(digit_i >= 0 && digit_i <= 9) {	//wurde eine Nummer eingegeben? (0-9)
				//x auf max 5 Stellen beschränkt --> ab 6. Stelle wird 99999 verwendet
				x_current = this.m_lpCalcFormData.getX();				
				if(x_current <= 9999) {
					x_new = x_current * 10 + digit_i;
				}else {
					x_new = 99999;
				}
				this.m_lpCalcFormData.setX(x_new);	
			}
		}
		
		try {
			if(action != null) {
				switch(action) {
				case "+_p1":
					this.m_p1.lp_add(this.m_lpCalcFormData.getX());
					this.m_lpCalcFormData.setX(0);
					break;
				case "+_p2":
					this.m_p2.lp_add(this.m_lpCalcFormData.getX());
					this.m_lpCalcFormData.setX(0);
					break;
				case "-_p1":
					this.m_p1.lp_subtract(this.m_lpCalcFormData.getX());
					this.m_lpCalcFormData.setX(0);
					break;
				case "-_p2":
					this.m_p2.lp_subtract(this.m_lpCalcFormData.getX());
					this.m_lpCalcFormData.setX(0);
					break;
				case "half_p1":
					this.m_p1.lp_halve();
					this.m_lpCalcFormData.setX(0);
					break;
				case "half_p2":
					this.m_p2.lp_halve();
					this.m_lpCalcFormData.setX(0);
					break;
				case "del":
					this.m_lpCalcFormData.setX(this.m_lpCalcFormData.getX()/10);	
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
//Backend Daten zu Controller Daten mappen
		this.m_lpCalcFormData.setLpP1(this.m_p1.lp_get());
		this.m_lpCalcFormData.setLpP2(this.m_p2.lp_get());
		
//Controller Daten zu View Daten Mappen
		//lpCalcFormData.setAction("");
		lpCalcFormData.setLpP1(this.m_lpCalcFormData.getLpP1());
		lpCalcFormData.setLpP2(this.m_lpCalcFormData.getLpP2());
		lpCalcFormData.setX(this.m_lpCalcFormData.getX());
		//lpCalcFormData.setDigit(' ');
	}
	
}
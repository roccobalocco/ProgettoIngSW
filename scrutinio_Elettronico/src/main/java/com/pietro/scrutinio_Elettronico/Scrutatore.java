package com.pietro.scrutinio_Elettronico;

import java.time.LocalDateTime;

/*Overview: 
 * Le istanze di questa classe rappresentano oggetti immutabili Scrutatore, condividono le caratteristiche
 * degli oggetti Utenti, implementando peró metodi specifici per la gestione delle votazioni.
 */
public class Scrutatore extends Utente {
	@SuppressWarnings("unused")
	private /*@ spec_public non_null @*/ int id;
	
	/*@
	 *also;
	 @*/
	public Scrutatore(String n, String c) {
		super(n, c);
		
	}
	
	/*@
	 *requires psw != null && !psw.equals("") ;
	 @*/
	public boolean authentication(String psw) {
		return false;
	}
	
	public boolean chooseVotationType() {
		return false;
	}
	
	public boolean chooseCondition() {
		return false;
	}
	
	/*@
	 *requires stop != null && stop.compareTo(LocalDateTime.now()) > 0;
	 @*/
	public boolean chooseDate(LocalDateTime stop) {
		return false;
	}
	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}

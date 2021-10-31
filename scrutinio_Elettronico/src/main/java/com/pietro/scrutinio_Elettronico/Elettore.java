package com.pietro.scrutinio_Elettronico;

import java.time.LocalDate;

/*Overview: 
 * Le istanze di questa classe rappresentano oggetti immutabili Elettore, condividono le caratteristiche
 * degli oggetti Utenti, implementando peró metodi specifici per le votazioni, sono inoltre rappresentati
 * da piú dati anagrafici per riconoscerli in fase di votazione, mantenendo l'anonimato di questi dati
 * all'esterno del sistema.
 */
public class Elettore extends Utente {
	@SuppressWarnings("unused")
	private String CF, provincia, comune, indirizzo, num_carta_id;
	@SuppressWarnings("unused")
	private LocalDate data_nascita;
	
	/*@
	 *also;
	 *requires cf != null && !cf.equals("") && p != null && !p.equals("") && cm != null && !cm.equals("") &&
	 *         in != null && !in.equals("") && nid != null && !nid.equals("") &&
	 *         day > 0 && month > 0 && year > 2020;
	 @*/
	public Elettore(String n, String c, String cf, String p, String cm, String in, String nid, int day, int month, int year) {
		super(n, c); 
		CF = cf; comune = cm; indirizzo = in; num_carta_id = nid; 
		if (day < 10) {
			data_nascita = LocalDate.parse(year+"-"+month+"-0"+day);
		}else {
			data_nascita = LocalDate.parse(year+"-"+month+"-"+day);
		}
	}
	
	public boolean canVote() {
		return false;
	}
	
	public boolean vote() { 
		return false; 
	}
	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}

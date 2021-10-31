package com.pietro.scrutinio_Elettronico;

/*Overview: 
 * Le istanze di questa classe rappresentano oggetti immutabili Utente
 * a cui viene assegnato un nome ed un cognome sotto forma di stringhe
 * per riconoscerli
 */
public abstract class Utente {
	protected String nome, cognome;
	
	/*@
	 *requires n != null && c != null && !n.equals("") && !c.equals("");
	 @*/
	public Utente(String n, String c) {
		nome = n; cognome = c;
	}
	
	public abstract boolean equals(Object o); 

}

package scrutinio_Elettronico.src.main.java.com.pietro.scrutinio_Elettronico;

/*Overview: 
 * Le istanze di questa classe rappresentano oggetti immutabili Utente
 * a cui viene assegnato un nome ed un cognome sotto forma di stringhe
 * per riconoscerli 
 */
public abstract class Utente {
	protected final String nome, cognome, mail;
	
	/*@
	 *requires n != null && c != null && !n.equals("") && !c.equals("") && m != null && !m.equals("");
	 @*/
	public Utente(String n, String c, String m) {
		nome = n; cognome = c; mail = m;
	}
	
	public abstract boolean equals(Object o); 

}

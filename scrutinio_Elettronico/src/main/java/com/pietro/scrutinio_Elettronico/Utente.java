package scrutinio_Elettronico.src.main.java.com.pietro.scrutinio_Elettronico;

/*Overview: 
 * Le istanze di questa classe rappresentano oggetti immutabili Utente
 * a cui viene assegnato un nome ed un cognome sotto forma di stringhe
 * per riconoscerli 
 */
public abstract class Utente {
	/*@public invariant nome != null && cognome != null && !nome.equals("") && !cognome.equals(""); @*/
	protected /*@ spec_public @*/ final String nome, cognome;
	
	public Utente(String n, String c) {
		nome = n; cognome = c;
	}
	
	public abstract boolean equals(Object o); 

}

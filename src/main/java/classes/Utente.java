package classes;

/*Overview: 
 * Le istanze di questa classe rappresentano oggetti immutabili Utente
 * a cui viene assegnato un nome ed un cognome sotto forma di stringhe
 * per riconoscerli 
 */
public abstract class Utente {
	private String username;
	
	Utente(String user){
		this.username = user;
	}

	public String getUsername() {
		return username;
	}

}

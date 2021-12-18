package classes;

/*Overview: 
 * Le istanze di questa classe rappresentano oggetti immutabili Scrutatore, condividono le caratteristiche
 * degli oggetti Utenti, implementando pero' metodi specifici per la gestione delle votazioni.
 */
public class Scrutatore extends Utente {
	private String nome, cognome, mail; 
	private int id;
	
	public Scrutatore(String user, String nome, String cognome, String mail, int identifier) {
		super(user);
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.id = identifier;
	}

	public int getId() {
		return id;
	}

	public String getMail() {
		return mail;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}


}

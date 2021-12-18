package classes;


/*Overview: 
 * Le istanze di questa classe rappresentano oggetti immutabili Elettore, condividono le caratteristiche
 * degli oggetti Utenti, implementando per� metodi specifici per le votazioni, sono inoltre rappresentati
 * da pi� dati anagrafici per riconoscerli in fase di votazione, mantenendo l'anonimato di questi dati
 * all'esterno del sistema.
 */
public class Elettore extends Utente {
	private int id;
	
	public Elettore(String user, int identifier) {
		super(user);
		this.id = identifier;
	}

	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "username: " + super.getUsername() + " id:" + id;
	}
}


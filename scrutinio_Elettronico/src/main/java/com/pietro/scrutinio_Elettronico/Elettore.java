package scrutinio_Elettronico.src.main.java.com.pietro.scrutinio_Elettronico;

import java.time.LocalDate;

/*Overview: 
 * Le istanze di questa classe rappresentano oggetti immutabili Elettore, condividono le caratteristiche
 * degli oggetti Utenti, implementando peró metodi specifici per le votazioni, sono inoltre rappresentati
 * da piú dati anagrafici per riconoscerli in fase di votazione, mantenendo l'anonimato di questi dati
 * all'esterno del sistema.
 */
public class Elettore extends Utente {
	private final String nazione_nascita, comune_nascita;
	private final /*@ spec_public @*/ LocalDate data_nascita;
	private final char sesso;
	private final char[] cf;
	private boolean /*@ spec_public @*/ voto;
	
	/*@
	 *also;
	 *requires (sex == 'm' || sex == 'f') && (nazione.equals("Italia") ==> comune != null);
	 *ensures data_nascita.isBefore(LocalDate.now()) && cf_isOk(cf);
	 @*/
	public Elettore(String n, String c, String m, char[] cf, String comune, String nazione, char sex, int day, int month, int year) {
		super(n, c, m);
		data_nascita = LocalDate.of(year,  month, day);
		if (!data_nascita.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException(data_nascita.toString()+" non é una data di nascita ammissibile \n");
		}
		if(!cf_isOk(cf)) {
			throw new IllegalArgumentException("Il codice fiscale inserito non é valido \n");
		}
		this.cf = cf;
		nazione_nascita = nazione;
		comune_nascita = comune;
		sesso = sex;
		voto = false;
	}
	
	private int getMonthEnum(char x) {
		switch(x) {
		case 'a': return 1; case 'b': return 2; case 'c': return 3; case 'd': return 4; case 'e': return 5; case 'f': return 6;
		case 'g': return 7; case 'h': return 8; case 'i': return 9; case 'j': return 10; case 'k': return 11; case 'l': return 12;
		default: throw new IllegalArgumentException("Il mese inserito non esiste \n");
		}
	}
	
	private boolean /*@ spec_public @*/  cf_isOk(char[] x) {
		boolean val = (Character.isLetter(x[0]) && Character.isLetter(x[1]) && Character.isLetter(x[2]) && Character.isLetter(x[3]) && Character.isLetter(x[4]) && Character.isLetter(x[5]));
		if (!val) { return false; }
		val = (this.data_nascita.getYear() == Integer.parseInt(String.valueOf(x[6])+String.valueOf(x[7])));
		if (!val) { return false; }
		val = (this.data_nascita.getMonthValue() == getMonthEnum(x[8]) && Character.isDigit(x[9]) && Character.isDigit(x[10]));
		if (!val) { return false; }
		/*controllo necessario sugli ultimi 5 elementi, ANCHE IN JML */
		return val;
	}
	
	public boolean esprimi_voto(/*something relate to votation */) {
		if (!this.voto) {
			voto = true;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		return "";
	}

}


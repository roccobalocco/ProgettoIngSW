import java.time.LocalDate;
import java.time.Period;

import java.lang.StringBuilder;

/*Overview: 
 * Le istanze di questa classe rappresentano oggetti immutabili Elettore, condividono le caratteristiche
 * degli oggetti Utenti, implementando peró metodi specifici per le votazioni, sono inoltre rappresentati
 * da piú dati anagrafici per riconoscerli in fase di votazione, mantenendo l'anonimato di questi dati
 * all'esterno del sistema.
 */
public class Elettore extends Utente {
	/*@ public invariant nazione_nascita != null && (nazione_nascita.equals("Italia") ==> comune_nascita != null);@*/
	private final /*@ spec_public @*/ String nazione_nascita, comune_nascita;
	/*@ public invariant data_nascita.isBefore(LocalDate.now()); @*/
	private final /*@ spec_public @*/ LocalDate data_nascita;
	/*@ public invariant sesso == 'm'|| sesso == 'f'; @*/
	private final /*@ spec_public @*/ char sesso;
	/*@ public invariant this.cf_isOk(); @*/
	private final /*@ spec_public @*/ char[] cf;
	private /*@ spec_public @*/ boolean voto;
	
	public Elettore(String n, String c, char[] cf, String comune, String nazione, char sex, int day, int month, int year) {
		super(n, c);
		data_nascita = LocalDate.of(year,  month, day);
		if (!data_nascita.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException(data_nascita.toString()+" non e' una data di nascita ammissibile \n");
		}
		this.cf = cf;
		if(!cf_isOk()) {
			throw new IllegalArgumentException("Il codice fiscale inserito non e' valido \n");
		}
		nazione_nascita = nazione;
		comune_nascita = comune;
		sesso = Character.toLowerCase(sex);
		voto = false;
	}
	
	
	// il seguente metodo restituisce true se il codice fiscale inserito e' valido altrimenti restituisce false
	private /*@ pure spec_public @*/ boolean cf_isOk() {
		return CodiceFiscale.getLetter(this.nome).contentEquals(String.valueOf(this.cf, 0, 3)) 
				&& CodiceFiscale.getLetter(this.cognome).contentEquals(String.valueOf(this.cf, 3, 3))
				&& Integer.valueOf(CodiceFiscale.getYear(this.data_nascita.getYear())) == Integer.valueOf(String.valueOf(this.cf, 6, 2)) 
				&& CodiceFiscale.getMonth(this.data_nascita.getMonthValue()).equals(String.valueOf(this.cf[8]))
				&& CodiceFiscale.getDay(this.data_nascita.getDayOfMonth(), this.sesso).equals(String.valueOf(this.cf, 9, 2))
				&& CodiceFiscale.getLetNum(this.nazione_nascita, this.comune_nascita).equals(String.valueOf(this.cf[11]))
				&& Character.isDigit(this.cf[12]) && Character.isDigit(this.cf[13]) && Character.isDigit(this.cf[14]) && Character.isLetter(this.cf[15]);
	}
	
	// il seguente metodo restituisce true se l'elettore e' maggiorenne altrimenti restituisce false
	private /*@ pure spec_public @*/ static boolean isAdult(LocalDate birth_date) {
		Period p = Period.between(birth_date, LocalDate.now());
		if (p.getYears() >= 18) {
			return true;
		}
		return false;
	}
	
	//@ requires this.voto == false;
	//@ ensures isAdult(this.data_nascita);
	public boolean esprimi_voto(/*something relates to votation */) {
		if (!this.voto && isAdult(this.data_nascita)) {
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
		StringBuilder s = new StringBuilder("Nome: "+super.nome+"/nCognome: "+super.cognome);
		s.append("\nCodice fiscale: ");
		s.append(this.cf);
		s.append("\nNazione di nascita: "+this.nazione_nascita.toString()+". Comune di nascita: "+this.comune_nascita);
		s.append("\nSesso: "+this.sesso);
		return s.toString();
	}

}


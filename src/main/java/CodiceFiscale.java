public class CodiceFiscale {
 
	/*@ per ottenere le 3 lettere del nome e del cognome @*/
	public static String getLetter(String x){
		StringBuilder s = new StringBuilder();
		if (x.length() < 3) {
			throw new IllegalArgumentException("L'input deve essere lungo almeno 3 caratteri");
		}
		s.append(getThree(x));
		return "";
	}
	
	private static String getThree(String x) {
		x = x.toUpperCase();
		String y = "";
		int counter = 0;
		for (int i = 0; i < x.length() && counter < 3; i++) {
			if (!isVocal(x.charAt(i))){
				counter++;
				y = y + String.valueOf(x.charAt(i));
			}
		}
		if (counter < 3) {
			for (int i = 0; i < x.length() && counter < 3; i++) {
				if (isVocal(x.charAt(i))){
					counter++;
					y = y + String.valueOf(x.charAt(i));
				}
			}
		}
		return x;
	}

	private static boolean isVocal(char x) { return x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U'; }

	/*@ per ottenere l'anno nel cf @*/
	public static String getYear(int x){
		String y = String.valueOf(x);
		return y.substring(y.length() - 3);
	}
	
	/*@ per ottenere la lettera del mese del codice fiscale @*/
	public static String getMonth(int x){
		switch(x) {
			case 1: return "A";
			case 2: return "B";
			case 3: return "C";
			case 4: return "D";
			case 5: return "E";
			case 6: return "H";
			case 7: return "L";
			case 8: return "M";
			case 9: return "P";
			case 10: return "R";
			case 11: return "S";
			case 12: return "T";
			default: throw new IllegalArgumentException("Il mese inserito non esiste\n");
		}
	}
	
	/*@ per ottenere il giorno di nascita del codice fiscale @*/
	public static String getDay(int x, char y){
		if(y == 'f') {
			return String.valueOf(x+40);
		}
		if(x < 10) {
			return "0"+String.valueOf(x);
		}
		return String.valueOf(x);
	}
	
	/*@ per ottenere la prime delle 4 lettere da nazione e comune di nascita @*/
	public static String getLetNum(String x, String y){
		if (x.toUpperCase() == "ITALIA") {
			return y.substring(0, 1).toUpperCase(); 
		}
		return "Z";
	}

}

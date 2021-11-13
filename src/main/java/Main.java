

public class Main {
	public static void main(String[] args) {
		char[] cf = {'M','S','L','P','T','R','0','0','S','0','7','C','6','2','3','M'};
		Elettore e = new Elettore("Pietro", "Masolini", cf, "Chiavenna", "Italia", 'M', 7, 11, 2000);
		System.out.println(e.toString());
	}
}

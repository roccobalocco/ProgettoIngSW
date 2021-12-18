package classes;

import java.util.List;

public interface ScrutatoreDao {
	public List<Scrutatore> getAllElettori();
	public Scrutatore getUtenteByUserPassword(String user, String psw);
	public List<Scrutatore> getUtenteByUser(String user);
}

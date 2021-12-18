package classes;

import java.util.List;

public interface ElettoreDao {
	public List<Elettore> getAllElettori();
	public Elettore getUtenteByUserPassword(String user, String psw);
	public List<Elettore> getUtenteByUser(String user);
}

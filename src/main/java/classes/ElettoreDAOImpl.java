package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ElettoreDAOImpl implements ElettoreDao {

	@Override
	public List<Elettore> getAllElettori() {
		List<Elettore> list = new LinkedList<>();
		
		try{
	      //apro connessione
	      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/votazioni?user=root&password=admin");
	      //scrivo query
	      String query = "SELECT * FROM utenti";
	      //creo oggetto statement per esecuzione query
	      PreparedStatement statement = conn.prepareStatement(query);
	      //eseguo la query
	      ResultSet resultSet = statement.executeQuery();
	      //guarda se ci sono risultati
	      while(resultSet.next()) 
	    	  if (!resultSet.getBoolean(4))
	    		  list.add(new Elettore(resultSet.getString(2), resultSet.getInt(1)));
	      
	      //chiudo resultset e connessione
	      resultSet.close();
	      conn.close();
	    }catch(SQLException e){
	      System.out.println("SQLException: " + e.getMessage());
	      System.out.println("SQLState: " + e.getSQLState());
	      System.out.println("VendorError: " + e.getErrorCode());
	    }
		return list;
	}

	@Override
	public Elettore getUtenteByUserPassword(String user, String psw) {
		Elettore utente = null;
		try{
	      //apro connessione
	      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/votazioni?user=root&password=admin");
	      //scrivo query
	      String query = "SELECT * FROM utenti WHERE username = \"" + user + " \" AND MD5(password) = \"" + psw + "\"";
	      //creo oggetto statement per esecuzione query
	      PreparedStatement statement = conn.prepareStatement(query);
	      //eseguo la query
	      ResultSet resultSet = statement.executeQuery();
	      //guarda se ci sono risultati
	      if(resultSet.next()) 
	    	  if (!resultSet.getBoolean(4))
	    		  utente = new Elettore(resultSet.getString(2), resultSet.getInt(1));
	      //chiudo resultset e connessione
	      resultSet.close();
	      conn.close();
	    }catch(SQLException e){
	      System.out.println("SQLException: " + e.getMessage());
	      System.out.println("SQLState: " + e.getSQLState());
	      System.out.println("VendorError: " + e.getErrorCode());
	    }
		return utente;
	}

	@Override
	public List<Elettore> getUtenteByUser(String user) {
		List<Elettore> list = new LinkedList<>();
		
		try{
	      //apro connessione
	      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/votazioni?user=root&password=admin");
	      //scrivo query
	      String query = "SELECT * FROM utenti WHERE username = \"" + user + " \"";
	      //creo oggetto statement per esecuzione query
	      PreparedStatement statement = conn.prepareStatement(query);
	      //eseguo la query
	      ResultSet resultSet = statement.executeQuery();
	      //guarda se ci sono risultati
	      while(resultSet.next()) 
	    	  if (!resultSet.getBoolean(4))
	    		  list.add(new Elettore(resultSet.getString(2), resultSet.getInt(1)));
	      
	      //chiudo resultset e connessione
	      resultSet.close();
	      conn.close();
	    }catch(SQLException e){
	      System.out.println("SQLException: " + e.getMessage());
	      System.out.println("SQLState: " + e.getSQLState());
	      System.out.println("VendorError: " + e.getErrorCode());
	    }
		return list;
	}

}

package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ScrutatoreDAOImpl implements ScrutatoreDao {

	@Override
	public List<Scrutatore> getAllElettori() {
		List<Scrutatore> list = new LinkedList<>();
		
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
	    	  if (resultSet.getBoolean(4))
	    		  list.add(new Scrutatore(resultSet.getString(2), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(1)));
	   
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
	public Scrutatore getUtenteByUserPassword(String user, String psw) {
		Scrutatore scrutatore = null;
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
	    	  if (resultSet.getBoolean(4))
	    		  scrutatore = new Scrutatore(resultSet.getString(2), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(1));
	    		  
	      //chiudo resultset e connessione
	      resultSet.close();
	      conn.close();
	    }catch(SQLException e){
	      System.out.println("SQLException: " + e.getMessage());
	      System.out.println("SQLState: " + e.getSQLState());
	      System.out.println("VendorError: " + e.getErrorCode());
	    }
		return scrutatore;
	}

	@Override
	public List<Scrutatore> getUtenteByUser(String user) {
		List<Scrutatore> list = new LinkedList<>();
		
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
	    	  if (resultSet.getBoolean(4))
	    		  list.add(new Scrutatore(resultSet.getString(2), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(1)));
	      
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

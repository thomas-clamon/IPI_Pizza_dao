package IMPLEMENTATION;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import DAO.PizzaDAO;
import INTERFACE.IClientService;
import MODEL.Client;

public class ClientService implements IClientService{
	
	private PizzaDAO dao = new PizzaDAO();

	@Override
	public int ajouterClient(Client c) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Client recuperer(String id) {
		
		String SQL = String.format("SELECT * FROM clients WHERE mail = '%s'", id);
		
		// on execute la requete
		try {
			ResultSet rs = dao.getStatement().executeQuery(SQL);
			while(rs.next()) {
				String mail = rs.getString(1);
				String Nom = rs.getString(2);
				String Prenom = rs.getString(3);
				Date dateSQL = rs.getDate(4);
				
				LocalDate date_naissance = dateSQL.toLocalDate(); // on convertie la Date format SQL en local Date
				
				return new Client(mail, Nom, Prenom, date_naissance);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
		
	}
}

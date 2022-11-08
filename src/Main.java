import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws SQLException {

		Pizza p= new Pizza(1);
		
		System.out.println(p);
		
		p.setPrix(400);
		
		PizzaDAO dao = new PizzaDAO();
		
		dao.updatePizza(p);
		
		dao.deletePizza(1);
		
		

	}

}

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pizza {
	
	private int ID;
	private String Nom;
	private float Prix;
	private Taille_pizza taille;
	
	private PizzaDAO dao = new PizzaDAO();
	
	public Pizza(String nom, float prix, Taille_pizza taille) {
		Nom = nom;
		Prix = prix;
		this.taille = taille;
	}

	public Pizza (int ID) {
		
		Statement sts = dao.getStatement();
		
		String SQL = "SELECT * FROM Pizzas WHERE ID = " + ID;
		
		try {
			ResultSet rs = sts.executeQuery(SQL);
			
			
			while(rs.next())
			{
				this.ID = rs.getInt("ID"); 
				this.Nom = rs.getString("Nom");
				this.Prix = rs.getFloat("Prix");
				this.taille = Taille_pizza.valueOf(rs.getString("Taille"));
				
			}
			if (this.ID == 0)
				return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Pizza [ID=" + ID + ", Nom=" + Nom + ", Prix=" + Prix + ", taille=" + taille + "]";
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}


	public float getPrix() {
		return Prix;
	}


	public void setPrix(float prix) {
		Prix = prix;
	}


	public Taille_pizza getTaille() {
		return taille;
	}


	public void setTaille(Taille_pizza taille) {
		this.taille = taille;
	}
	
	
	
	
	
	
	

}

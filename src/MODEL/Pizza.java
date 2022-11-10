package MODEL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import IMPLEMENTATION.PizzaService;

public class Pizza {
	
	private int ID;
	private String Nom;
	private float Prix;
	private Taille_pizza taille;
	
	private List <Ingredient> list_ingredient;
	
	private PizzaService service;
	
	public Pizza(String nom, float prix, Taille_pizza taille) {
		Nom = nom;
		Prix = prix;
		this.taille = taille;
		this.service = new PizzaService();
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

	public List<Ingredient> getList_ingredient() {
		this.list_ingredient = service.getIngredient(this.ID);
		return list_ingredient;
	}

	
	
	
	
	

}

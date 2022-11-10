import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DAO.PizzaDAO;
import IMPLEMENTATION.ClientService;
import IMPLEMENTATION.IngredientsService;
import IMPLEMENTATION.PizzaService;
import INTERFACE.IClientService;
import INTERFACE.IIngredientService;
import INTERFACE.IPizzaService;
import MODEL.Client;
import MODEL.Pizza;
import MODEL.Taille_pizza;

public class Main {
	

	private static IIngredientService service = new IngredientsService();
	
	private static IClientService clientService = new ClientService();
	
	private static IPizzaService pizzaService = new PizzaService();

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Que voulez vous faire :");
		System.out.println("1 | Ajouter une nouvelle pizza" );
		System.out.println("2 | Supprimer Pizza" );
		System.out.println("3 | Afficher un ingredient" );
		System.out.println("4 | Afficher les ingredients d'une Pizza" );
		System.out.println("5| Afficher un Client ");
		int choix = sc.nextInt();
		
		switch(choix) {
		
		case 1 :
			AjouterPizza(sc);
		case 2 :
			System.out.println("numero de la pizza");
			int id = sc.nextInt();
			pizzaService.delete(id);
			break;
		case 3 :
			System.out.println("numero de l'ingredients");
			id = sc.nextInt();
			System.out.println(service.get(id));
		
		case 4 :
			System.out.println("veuillez entrer l'ID");
			int ID = sc.nextInt();
			Pizza p = pizzaService.get(ID);
			System.out.println(p.getList_ingredient());
			break;
			
		case 5 :
	
			System.out.println("veuillez saisir l'id");
			String mail = sc.next();
			Client c = clientService.recuperer(mail); 
			System.out.println(c);
			break;
			
			
		default :
			throw new Exception("Choix incorrect");
			// on declenche une exeption
		}
	
		

	}
	
	public static void AjouterPizza(Scanner sc) throws Exception {
		
		System.out.println("choix de la taille :");
		System.out.println("1 | PETITE" );
		System.out.println("2 | MOYENNE" );
		System.out.println("3 | GRANDE" );
		
		int choix = sc.nextInt();
		Taille_pizza taille = null;
		
		switch(choix) {
		
			case 1 :
				taille = Taille_pizza.PETITE;
			break;
			case 2 :
				taille = Taille_pizza.MOYENNE;
			break;
			case 3 :
				taille = Taille_pizza.GRANDE;
			break;
			default :
				throw new Exception("Choix incorrect");// on declenche une exeption
			
		}
		
		System.out.println("saisir le prix de la pizza");
		float prix = sc.nextFloat();

		System.out.println("veuiller saisir le nom de la pizza");
		String nom = sc.next();

		
		// on enrigistre la pizza dans la memoire java
		Pizza p = new Pizza(nom, prix,taille); 
		
		// on demande au DAO d'enrigistrer la pizza en base
		
		pizzaService.enregistrerPizza(p);
		
		System.out.println("la pizza a été enregistré");
		
	}
}

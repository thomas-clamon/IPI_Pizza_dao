package INTERFACE;
import MODEL.Client;

public interface IClientService {
	
	public int ajouterClient(Client c);
	
	public Client recuperer(String id);

}

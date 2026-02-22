package ReviewSite;
public class Utilisateur {
	private Boolean role;
	private String name;
	
	public Utilisateur() {
		role = false;
		name = "";
	}
	// Ajoutez un constructeur avec un argument pour spécifier le nom
	public Utilisateur(String nom) {
		role = false;
		name = nom;
	}
	public String getName() {
		return name;
	}
	// Modifiez setName pour prendre un argument et définir le nom
	public void setName(String nom) {
		name = nom;
	}
	public void setRole(Boolean b) {
		role = b;
	}
	public void display() {
		System.out.println("Nom: " + name);
	}
}



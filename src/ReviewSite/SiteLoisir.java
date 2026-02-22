package ReviewSite;

public class SiteLoisir extends ObjetEvaluation{
	private String ville;
	private String pays;
	private String type;
	
	public SiteLoisir(String categorie, String nomComplet, String ville, String pays, String type) {
		super(categorie, nomComplet);
		this.ville = ville;
		this.pays = pays;
		this.type = type;
	}
	public String getVille() {
		return ville;
	}
	public String getPays() {
		return pays;
	}
	public String getType() {
		return type;
	}
	public void display() {
		super.display();
		System.out.println("Ville: " + ville);
		System.out.println("Pays: " + pays);
		System.out.println("Type: " + type);
	}
}


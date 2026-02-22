package ReviewSite;

public class ObjetEvaluation {
	private String categorie;
	private String nomComplet;
	
	public ObjetEvaluation(String categorie, String nomComplet) {
		this.categorie = categorie;
		this.nomComplet = nomComplet;
	}
	public String getCategorie() {
		return categorie;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void display() {
		System.out.println("Catégorie: " + categorie);
		System.out.println("Nom Complet: " + nomComplet);
	}
}


package ReviewSite;

public class Avis {
	private Utilisateur utilisateur;
	private ObjetEvaluation objetEvaluation;
	private int note;
	private String commentaire;
	
	public Avis(Utilisateur utilisateur, ObjetEvaluation objetEvaluation, int note, String commentaire) {
		this.utilisateur = utilisateur;
		this.objetEvaluation = objetEvaluation;
		this.note = note;
		this.commentaire = commentaire;
	}
	public void display() {
		System.out.println("Avis de " + utilisateur.getName());
		objetEvaluation.display();
		System.out.println("Note: " + note + " étoiles");
		System.out.println("Commentaire: " + commentaire);
	}
	public int getNote() {
		return note;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public ObjetEvaluation getObjetEvaluation() {
		return objetEvaluation;
	}
}


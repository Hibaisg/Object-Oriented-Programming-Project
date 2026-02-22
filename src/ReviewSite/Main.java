package ReviewSite;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class Main {
private static int totalAvisProduit = 0;
	private static int totalAvisSiteLoisir = 0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Création d'une liste pour stocker les avis
		ArrayList<Avis> listeAvis = new ArrayList<>();
		
		// Création d'une liste pour stocker les visiteurs
		HashMap <String,Visitor> listeVisiteur = new HashMap<>();
		
		Utilisateur utilisateur;
		utilisateur = new Administrator();
		Administrator admin = (Administrator) utilisateur;
		
		while (true) {
			// Menu principal
			System.out.println("Menu Principal:");
			System.out.println("1. Administrateur");
			System.out.println("2. Visiteur");
			System.out.println("3. Quitter");
			int mainChoice;
			
			try {
				mainChoice = scanner.nextInt();
				scanner.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("Entrée non valide. Veuillez entrer un nombre entier.");
				scanner.nextLine(); // Nettoyer le scanner pour éviter une boucle infinie
				continue;
			}
			
			if (mainChoice == 3) {
				System.out.println("Fin du programme.");
				break;
			}
			
			//Utilisateur utilisateur;
			//utilisateur = new Administrator();
			//Administrator admin = (Administrator) utilisateur;
			
			if (mainChoice == 1) {
				//utilisateur = new Administrator();
				//Administrator admin = (Administrator) utilisateur;
				
				// Demander le code à l'administrateur
				System.out.print("Entrez votre code administrateur : ");
				String enteredCode = scanner.next();
				
				if (admin.verifyCode(enteredCode)) {
					while (true) {
						// Menu pour l'administrateur
						System.out.println("Menu Administrateur:");
						System.out.println("1. Consulter la totalité des avis");
						System.out.println("2. Supprimer un avis");
						System.out.println("3. Afficher les statistiques");
						System.out.println("4. Changer Votre CODE");
						System.out.println("5. Quitter");
						int adminChoice;
						
						try {
							adminChoice = scanner.nextInt();
							scanner.nextLine();
						} catch (InputMismatchException e) {
							System.out.println("Entrée non valide. Veuillez entrer un nombre entier.");
							scanner.nextLine(); // Nettoyer le scanner pour éviter une boucle infinie
							continue;
						}
						
						switch (adminChoice) {
							case 1:
								// Consulter la totalité des avis par catégorie
								boolean exist = false;
								for (Avis avis : listeAvis) {
									if (avis.getObjetEvaluation().getCategorie().equals("Produit")) {																				
										if (exist == false) {
											System.out.println("------------------------------------");
											System.out.println("Liste des avis des PRODUITS:");
											System.out.println("------------------------------------");
										}
										avis.display();
										System.out.println("------------------------------------");
										exist = true;
									}
								}
								
								boolean existS = false;
								for (Avis avis : listeAvis) {
									if (avis.getObjetEvaluation().getCategorie().equals("Site De Loisir")) {
										if (existS == false) {
											System.out.println("------------------------------------");
											System.out.println("Liste des avis des SITES DE LOISIR:");
											System.out.println("------------------------------------");
										}
										avis.display();
										System.out.println("------------------------------------");
										existS = true;
									}
								}
								if (existS == false && exist == false) {
									System.out.println("------------------------------------");
									System.out.println("Aucun avis n'est publié !");
									System.out.println("------------------------------------");
								}
								break;
							case 2:
								// Supprimer un avis basé sur le commentaire
								System.out.print("Entrez le commentaire à rechercher et supprimer : ");
								String commentaireToDelete = scanner.nextLine();
								
								// Parcourir la liste des avis et supprimer ceux avec le commentaire spécifié
								boolean avisSupprime = false;
								
								for (Avis avis : listeAvis) {
									if (avis.getCommentaire().equalsIgnoreCase(commentaireToDelete)) {
										listeAvis.remove(avis);
										avisSupprime = true;
										System.out.println("Avis supprimé avec succès.");
										break; // Sortir de la boucle dès qu'un avis est supprimé
									}
								}
								if (!avisSupprime) {
									System.out.println("Aucun avis trouvé avec le commentaire spécifié.");
								}
								System.out.println("---------------------------------------------");
								break;
							case 3:
								// Afficher les statistiques
								System.out.println("Statistiques :");
								System.out.println("Nombre total d'avis : " + listeAvis.size());
								System.out.println("Nombre total d'avis Produit : " + totalAvisProduit);
								System.out.println("Nombre total d'avis Site De Loisir : " + totalAvisSiteLoisir);
								System.out.println("--------------------------------------");
								
								System.out.println("Liste de visiteurs :" + listeVisiteur.size() + " Visiteurs");
								for (Map.Entry<String, Visitor> entry : listeVisiteur.entrySet()) {
									Visitor visiteur = entry.getValue();
									visiteur.display();
									System.out.println("-----------------------");
								}
								break;
							case 4:
								System.out.print("Entrez votre code administrateur actuel: ");
								enteredCode = scanner.next();
								
								if (admin.verifyCode(enteredCode)) {
									admin.setCode();
								}
								
								else	System.out.print("CODE incorrect! Impossible de changer le CODE! ");
								System.out.println("-----------------------------------------");
								
								break;
							case 5:
								// Retourner au menu principal
								break;
							default:
								System.out.println("Choix non valide.");
						}
						if (adminChoice == 5) {
							break; // Retourner au menu principal
						}
					}
				} 
				else {
					System.out.println("Code administrateur incorrect.");
				}
			} 
			else if (mainChoice == 2) {
				utilisateur = new Visitor();
				
				while (true) {
					// Menu pour le visiteur
					System.out.println("Menu Visiteur:");
					System.out.println("1. Publier un avis");
					System.out.println("2. Consulter la totalité des avis par catégorie");
					System.out.println("3. Rechercher un objet bien déterminé et consulter les avis publiés");
					System.out.println("4. Quitter");
					int visitorChoice;
					
					try {
						visitorChoice = scanner.nextInt();
						scanner.nextLine();
					} catch (InputMismatchException e) {
						System.out.println("Entrée non valide. Veuillez entrer un nombre entier.");
						scanner.nextLine(); // Nettoyer le scanner pour éviter une boucle infinie
						continue;
					}
					
					switch (visitorChoice) {
						case 1:
							// Publier un avis
							publierAvis(listeAvis, (Visitor) utilisateur, listeVisiteur);
							break;
						case 2:
						// Consulter la totalité des avis par catégorie
							int categoryChoice;
							do {
								try {
								 	System.out.print("Choisissez la catégorie (1: Produit / 2: Site de Loisir) : ");
								 	categoryChoice = scanner.nextInt();
								 	scanner.nextLine();
								} catch (InputMismatchException e) {
									 System.out.println("Entrée non valide. Veuillez entrer 1 ou 2.");
									 scanner.nextLine(); // Nettoyer le scanner pour éviter une boucle infinie
									 categoryChoice = -1;
								}
							}while (categoryChoice < 1 || categoryChoice > 2);
							
							boolean publie = false;
							if (categoryChoice == 1) {								
								for (Avis avis : listeAvis) {
									if (avis.getObjetEvaluation().getCategorie().equals("Produit")) {
										if (publie == false) {
											System.out.println("------------------------------");
											System.out.println("Liste des avis des PRODUITS:");
											System.out.println("------------------------------");
										}
										avis.display();
										System.out.println("------------------------------");
										publie = true;
									}
								}
								if (publie == false) {
									System.out.println("------------------------------------");
									System.out.println("Aucun avis n'est publié !");
									System.out.println("------------------------------------");
								}
							}
							
							publie = false;
							if (categoryChoice == 2) {								
								for (Avis avis : listeAvis) {
									if (avis.getObjetEvaluation().getCategorie().equals("Site De Loisir")) {
										if (publie == false) {
											System.out.println("------------------------------------");
											System.out.println("Liste des avis des SITES DE LOISIR:");
											System.out.println("------------------------------------");
										}
										avis.display();
										System.out.println("------------------------------");
										publie = true;
									}
								}
								if (publie == false) {
									System.out.println("------------------------------------");
									System.out.println("Aucun avis n'est publié !");
									System.out.println("------------------------------------");
								}
							}
							break;
						case 3:
							// Rechercher un objet bien déterminé et consulter les avis publiés
							System.out.print("Entrez le nom complet de l'objet : ");
							String searchObject = scanner.next();
							
							boolean objetTrouve = false;
							
							System.out.println("Avis pour l'objet " + searchObject + " :");
							
							for (Avis avis : listeAvis) {
								if (avis.getObjetEvaluation().getNomComplet().equalsIgnoreCase(searchObject)) {
									avis.display();
									System.out.println("------------------------------");
									objetTrouve = true;
								}
							}
							if (!objetTrouve) {
								System.out.println("Aucun avis trouvé pour l'objet " + searchObject + ".");
							}
							break;
						case 4:
							// Retourner au menu principal
							break;
						default:
							System.out.println("Choix non valide.");
					}
					if (visitorChoice == 4) {
					break; // Retourner au menu principal
					}
				}
			} 
			else {
				System.out.println("Choix non valide. Veuillez entrer 1, 2 ou 3.");
			}
		}
		scanner.close(); // Fermer le scanner à la fin
	}
	
	
	
	// Méthode pour la publication d'un avis
	private static void publierAvis(ArrayList<Avis> listeAvis, Visitor visiteur, HashMap<String, Visitor> listeVisiteur) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-----------------------------------------------");
		
		// Saisir le nom de l'utilisateur
		System.out.print("Votre Nom : ");
		String nomUtilisateur = scanner.nextLine();
		
		String id = authentifierVisiteur(scanner, visiteur, listeVisiteur);
		
		Visitor nouvelVisiteur = new Visitor(nomUtilisateur, id);
		listeVisiteur.put(id, nouvelVisiteur);
		
		// Créer un nouvel objet d'évaluation (produit ou site de loisir)
		ObjetEvaluation objetEvaluation = creerObjetEvaluation(scanner);
		
		// Saisir l'évaluation (note et commentaire)
		int note;
		do {
			try {
				System.out.print("Entrez votre note (entre 0 et 5 étoiles) : ");
				note = scanner.nextInt();
				scanner.nextLine(); // Consommer la nouvelle ligne après la saisie d'un entier
				} catch (InputMismatchException e) {
					System.out.println("Entrée non valide. Veuillez entrer un nombre entier.");
					scanner.nextLine(); // Nettoyer le scanner pour éviter une boucle infinie
					note = -1; // Valeur invalide pour continuer la boucle
				}
			} while (note < 0 || note > 5);
			
			System.out.print("Entrez votre commentaire : ");
			String commentaire = scanner.nextLine();
			
			// Créer un nouvel avis avec le nom de l'utilisateur saisi
			Avis nouvelAvis = new Avis(nouvelVisiteur, objetEvaluation, note, commentaire);
			
			// Ajouter l'avis à la liste
			listeAvis.add(nouvelAvis);
			
			// Mettre à jour les compteurs en fonction de la catégorie de l'objet évalué
			if (objetEvaluation.getCategorie().equalsIgnoreCase("Produit")) {
				totalAvisProduit++;
			} 
			else if (objetEvaluation.getCategorie().equalsIgnoreCase("Site De Loisir")) {
				totalAvisSiteLoisir++;
			}
			
			System.out.println("Avis publié avec succès.");
			System.out.println("----------------------------------");
		}
		
		
		
		private static String authentifierVisiteur(Scanner scanner, Visitor vis, HashMap <String,Visitor> listeVisiteur) { 	
			System.out.println("1. Saisir Votre Identifiant");
			System.out.println("2. Créer un compte");
			
			int x;
			do {
				 try {
				 	x = scanner.nextInt();
				 	scanner.nextLine();
				 } catch (InputMismatchException e) {
					 System.out.println("Entrée non valide. Veuillez entrer 1 ou 2.");
					 scanner.nextLine();
					 x = -1;
				 }
				}while (x < 1 || x > 2);
			
			int test = 1;
			if (x == 1) {
				do {
				 	System.out.print("Entrez Votre Identifiant : ");
				 	String Id = scanner.next();
				 	
				 	if (listeVisiteur.containsKey(Id))	{test--; return Id;}
				 	else	test++;
				}while (test>=1 && test<=3);
			}
			
			if (x == 2 || test > 3) {
				vis.setID();
				return vis.getID();
			}
			return "";
		}
		
		
		
		private static ObjetEvaluation creerObjetEvaluation(Scanner scanner) {
			int categorie;
			do {
				 try {
				 	System.out.print("Choisissez la catégorie (1: Produit / 2: Site de Loisir) : ");
				 	categorie = scanner.nextInt();
				 	scanner.nextLine();
				 } catch (InputMismatchException e) {
					 System.out.println("Entrée non valide. Veuillez entrer 1 ou 2.");
					 scanner.nextLine(); // Nettoyer le scanner pour éviter une boucle infinie
					 categorie = -1;
				 }
			}while (categorie < 1 || categorie > 2);
			
			System.out.print("Entrez le nom complet de l'objet : ");
			String nomComplet = scanner.next();
			
			if (categorie == 1) {
				System.out.print("Entrez la marque du produit : ");
				String marque = scanner.next();
				return new Produit("Produit", nomComplet, marque);
			}
			else{
				System.out.print("Entrez la ville du site : ");
				String ville = scanner.next();
				
				System.out.print("Entrez le pays du site : ");
				String pays = scanner.next();
				
				System.out.print("Entrez le type du site ");
				System.out.print("(Restaurant, Café, Hôtel, Maison d'hôte, etc..) : ");
				String type = scanner.next();
				
				return new SiteLoisir("Site De Loisir", nomComplet, ville, pays, type);
			}
		}
	}












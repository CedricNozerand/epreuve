package presentation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import metier.Enseignant;
import metier.Ensup;
import metier.Etudiant;

public class Launcher {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			
           System.out.println("Bienvenue sur le logiciel de gestion d'établissement scolaire");
           
           System.out.print("Login : ");
           String login = br.readLine();
           System.out.print("");
           System.out.print("Mot de passe : ");
           String mdp = br.readLine();
           System.out.print("");
			
           if(Enseignant.authentification(login, mdp)) {
        	   String choix;
        	   do {
	        	   System.out.println("1 - Créer un étudiant: ");
	        	   System.out.println("2 - Associer un cour à un étudiant: ");
	        	   System.out.println("3 - Lire les informations d'un étudiant: ");
	        	   System.out.println("4 - Modifier les informations d'un étudiant: ");
	        	   System.out.println("5 - Supprimer un étudiant: ");
	        	   System.out.println("6 - Lister l'ensemble des étudiants de l'école: ");
	        	   
	        	   choix = br.readLine();
        	   }while(!choix.equals("1") && !choix.equals("2") && !choix.equals("3") && !choix.equals("4") && !choix.equals("5") && !choix.equals("6"));
        	   
        	   if(choix.equals("1")) {
        		   System.out.print("Nom etudiant : ");
                   String nom = br.readLine();
                   System.out.print("");
                   System.out.print("Prénom etudiant : ");
                   String prenom = br.readLine();
                   System.out.print("");
                   System.out.print("Mail etudiant : ");
                   String mail = br.readLine();
                   System.out.print("");
                   System.out.print("Adresse etudiant : ");
                   String adresse = br.readLine();
                   System.out.print("");
                   System.out.print("Téléphone etudiant : ");
                   String telephone = br.readLine();
                   System.out.print("");
                   System.out.print("Date de naissance etudiant : ");
                   String dateNaissance = br.readLine();
                   System.out.print("");
                   
                   Etudiant.creer(nom, prenom, mail, adresse, telephone, dateNaissance);
        	   }else if(choix.equals("2")) {
        		   System.out.print("Identifiant de l'etudiant : ");
                   int id_etudiant = Integer.parseInt(br.readLine());
                   System.out.print("");
                   System.out.print("Identifiant du cour : ");
                   int id_cour = Integer.parseInt(br.readLine());
                   System.out.print("");
                   Etudiant.associerCour(id_etudiant, id_cour);
           	   }else if(choix.equals("3")) {
        		   System.out.print("Identifiant de l'etudiant : ");
                   int id = Integer.parseInt(br.readLine());
                   System.out.print("");
                   Etudiant.afficherEtudiant(id);
           	   }else if(choix.equals("4")) {
        		   System.out.print("Identifiant de l'etudiant : ");
                   int id = Integer.parseInt(br.readLine());
                   System.out.print("");
        		   System.out.print("Nouveau nom etudiant : ");
                   String nom = br.readLine();
                   System.out.print("");
                   System.out.print("Nouveau prénom etudiant : ");
                   String prenom = br.readLine();
                   System.out.print("");
                   System.out.print("Nouveau mail etudiant : ");
                   String mail = br.readLine();
                   System.out.print("");
                   System.out.print("Nouvelle adresse etudiant : ");
                   String adresse = br.readLine();
                   System.out.print("");
                   System.out.print("Nouveau téléphone etudiant : ");
                   String telephone = br.readLine();
                   System.out.print("");
                   System.out.print("Nouvelle date de naissance etudiant : ");
                   String dateNaissance = br.readLine();
                   System.out.print("");
                   
                   Etudiant.modifier(id, nom, prenom, mail, adresse, telephone, dateNaissance);
        	   }else if(choix.equals("5")) {
        		   System.out.print("Identifiant de l'etudiant : ");
                   int id = Integer.parseInt(br.readLine());
                   System.out.print("");
        		   Etudiant.supprimer(id);
        	   }else if(choix.equals("6")) {
        		   System.out.print("Identifiant de l'école : ");
                   int id = Integer.parseInt(br.readLine());
                   System.out.print("");
        		   Ensup.afficherEtudiants(id);
        	   }
        	   
           }else {
        	   System.out.println("Authentification échoue");
           }
           
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

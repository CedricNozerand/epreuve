package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ensup {

	private String nom, mail, adresse, telephone, directeur;
	
	// variables bdd
	static String url = "jdbc:mysql://localhost/epreuve";
	static String login = "root";
	static String passwd = "";
	
	public Ensup(String nom, String mail, String adresse, String telephone, String directeur) {
		super();
		this.nom = nom;
		this.mail = mail;
		this.adresse = adresse;
		this.telephone = telephone;
		this.directeur = directeur;
	}

	// Affiche toutes les informations de tous les étudiant d'une école en fonction de l'id de l'école
	public static void afficherEtudiants(int id_ecole) {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT * FROM etudiants WHERE id_ecole = '"+id_ecole+"'";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String mail = rs.getString("mail");
				String adresse = rs.getString("adresse");
				String telephone = rs.getString("tel");
				String dateNaissance = rs.getString("naissance");
				
				System.out.println(nom + " - " + prenom + " - " + mail + " - " + adresse + " - " + telephone + " - " + dateNaissance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e ) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// GETTERS SETTERS //
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDirecteur() {
		return directeur;
	}

	public void setDirecteur(String directeur) {
		this.directeur = directeur;
	}
}

package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Etudiant extends Utilisateur {

	private String dateNaissance;
	
	public Etudiant(int id, String nom, String prenom, String mail, String adresse, String telephone, String dateNaissance) {
		super(id, nom, prenom, mail, adresse, telephone);
		this.dateNaissance = dateNaissance;
	}

	// Créer un étudiant dans la base de données avec en paramètre toutes les informations nécessaires
	public static boolean creer(String nom, String prenom, String mail, String adresse, String telephone, String dateNaissance) {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "INSERT into etudiants (nom, prenom, mail, adresse, tel, naissance) VALUES "
					+ "('"+nom+"'"
					+ ",'"+prenom+"'"
					+ ",'"+mail+"'"
					+ ", '"+adresse+"'"
					+ ", '"+telephone+"'"
					+ ", '"+dateNaissance+"'"
					+")";
			st.executeUpdate(sql);
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
		return true;
	}
	
	// Afficher toute les informations d'un étudiant en fonction de son id
	public static void afficherEtudiant(int id_etudiant) {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT * FROM etudiants WHERE id = '"+id_etudiant+"'";
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
	
	// Modifier chacune des information d'un étudiant avec en premier paramètre l'id de l'étudiant
	public static boolean modifier(int id_etudiant, String nom, String prenom, String mail, String adresse, String telephone, String dateNaissance) {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "UPDATE etudiants SET nom = '"+nom+"', prenom = '"+prenom+"', mail = '"+mail+"', adresse = '"+adresse+"', tel = '"+telephone+"', naissance = '"+dateNaissance+"' WHERE id = '"+id_etudiant+"'";
			st.executeUpdate(sql);
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
		return true;
	}
	
	// Supprimer un étudiant en fonction d'un id
	public static boolean supprimer(int id_etudiant) {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "DELETE FROM etudiants WHERE id = '"+id_etudiant+"'";
			st.executeUpdate(sql);
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
		return true;
	}
	
	// Associer un cour à un étudiant en fonction de l'id de l'étudiant et l'id du cour
	public static boolean associerCour(int id_etudiant, int id_cour) {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "UPDATE etudiants SET id_cour = '"+id_cour+"' WHERE id = '"+id_etudiant+"'";
			st.executeUpdate(sql);
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
		return true;
	}
	
	// GETTERS SETTERS //
	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
}

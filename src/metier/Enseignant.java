package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Enseignant extends Utilisateur {
	
	private String matiereEnseigne;
	
	public Enseignant(int id, String nom, String prenom, String mail, String adresse, String telephone, String matiereEnseigne) {
		super(id, nom, prenom, mail, adresse, telephone);
		this.matiereEnseigne = matiereEnseigne;
	}

	public static boolean authentification(String mail, String mdp) {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT * FROM enseignants WHERE mail = '"+mail+"' AND mdp = '"+mdp+"'";
			
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				return true;
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
		
		return false;
	}
	
	// GETTERS SETTERS //
	public String getMatiereEnseigne() {
		return matiereEnseigne;
	}

	public void setMatiereEnseigne(String matiereEnseigne) {
		this.matiereEnseigne = matiereEnseigne;
	}
}

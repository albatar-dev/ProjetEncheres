package com.example.ProjetEncheres.bdd;

import com.example.ProjetEncheres.bo.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UtilisateurDAO {

    public static int add(Utilisateur utilisateur) throws Exception {
        Connection cnx = Connect.getConnection();
        String sql = "INSERT INTO utilisateurs( pseudo, nom, prenom, email, telephone, code_postal, ville, mot_de_passe, credit, administrateur )" +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1,utilisateur.getPseudo());
        stmt.setString(2,utilisateur.getNom());
        stmt.setString(3,utilisateur.getPrenom());
        stmt.setString(4,utilisateur.getEmail());
        stmt.setString(5,utilisateur.getTelephone());
        stmt.setString(6,utilisateur.getCodePostal());
        stmt.setString(7, utilisateur.getVille());
        stmt.setString(8,utilisateur.getMotDePasse());
        stmt.setInt(9,utilisateur.getCredit());
        stmt.setInt(10,utilisateur.isAdministrateur()?1:0);
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        int key = 0;
        if(keys!=null && keys.next()){
            key = keys.getInt(1);
        }
        cnx.close();
        return key;
    }

    public static ResultSet getUtilisateurByPseudo(String pseudo) throws Exception {
        Connection cnx = Connect.getConnection();
        String sql = "SELECT * FROM utilisateurs " +
                "WHERE pseudo = ?";
        PreparedStatement stmt = cnx.prepareStatement(sql);
        stmt.setString(1, pseudo);
        return stmt.executeQuery();
    }

    public static ResultSet getUtilisateurByEmail(String email) throws Exception {
        Connection cnx = Connect.getConnection();
        String sql = "SELECT * FROM utilisateurs " +
                "WHERE email LIKE ?";
        PreparedStatement stmt = cnx.prepareStatement(sql);
        stmt.setString(1, email);
        System.out.println(stmt);
        return stmt.executeQuery();
    }
}

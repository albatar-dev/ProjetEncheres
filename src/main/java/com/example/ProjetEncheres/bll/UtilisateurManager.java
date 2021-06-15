package com.example.ProjetEncheres.bll;

import com.example.ProjetEncheres.bo.Utilisateur;
import com.example.ProjetEncheres.exceptions.ValidationException;
import com.example.ProjetEncheres.bdd.UtilisateurDAO;

import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilisateurManager {

    private static boolean validateEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean validatePseudo(String pseudo) {
        String regex = "^[a-zA-Z0-9_]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pseudo);
        return matcher.matches();
    }

    private static boolean validateUniquePseudo(String pseudo) throws Exception {
        ResultSet utilisateurs = UtilisateurDAO.getUtilisateurByPseudo(pseudo);
        return !utilisateurs.next();
    }

    private static boolean validateUniqueEmail(String email) throws Exception {
        ResultSet utilisateurs = UtilisateurDAO.getUtilisateurByEmail(email);
        return !utilisateurs.next();
    }

    public static Utilisateur create(String pseudo, String nom, String prenom, String email, String telephone, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) throws Exception {
        if(!validateEmail(email)){
            throw new ValidationException("format de l'email invalide");
        }
        if(!validatePseudo(pseudo)){
            throw new ValidationException("Le pseudo ne doit contenir que des caractères alphanumériques");
        }
        if(!validateUniqueEmail(email)) {
            throw new ValidationException("Il y a déjà un compte associé à cette adresse");
        }
        if(!validateUniquePseudo(pseudo)) {
            throw new ValidationException("Il y a deja un compte associé à ce pseudo");
        }
        return new Utilisateur(pseudo, nom, prenom, email, telephone, codePostal, ville, motDePasse, credit, administrateur);
    }

}

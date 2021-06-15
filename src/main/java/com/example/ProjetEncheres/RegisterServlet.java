package com.example.ProjetEncheres;

import com.example.ProjetEncheres.bll.UtilisateurManager;
import com.example.ProjetEncheres.bo.Utilisateur;
import com.example.ProjetEncheres.exceptions.ValidationException;
import com.example.ProjetEncheres.bdd.UtilisateurDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/utilisateur/register.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pseudo = request.getParameter("pseudo");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone") != null ? request.getParameter("telephone") : "";
        String code_postal = request.getParameter("code_postal");
        String ville = request.getParameter("ville");
        String mot_de_passe = request.getParameter("mot_de_passe");
        int credit = 0;
        boolean administrateur = false;
        try {
            Utilisateur utilisateur = UtilisateurManager.create(pseudo, nom, prenom, email, telephone, code_postal, ville, mot_de_passe,credit, administrateur);
            UtilisateurDAO.add(utilisateur);
        }catch(ValidationException e) {
            request.getSession().setAttribute("error", e.getMessage());
        } catch (Exception e) {
            request.getSession().setAttribute("error", e.getMessage());
        }
        doGet(request,response);
    }
}

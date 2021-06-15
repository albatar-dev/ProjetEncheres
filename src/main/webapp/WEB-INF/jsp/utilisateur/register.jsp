<%--
  Created by IntelliJ IDEA.
  User: joce
  Date: 15/06/2021
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.js"></script>
</head>
<body>
 <h1>test</h1>
 <% if(request.getSession().getAttribute("error") != null) {
    String error = (String) request.getSession().getAttribute("error");
    request.getSession().setAttribute("error",null);%>
    <div style="background-color: rgba(255,0,0,0.3);border-radius: 0.5rem;"><%= error %></div>
 <% } %>
    <form method="post" action="">
        <div class="form-group">
            <label for="pseudo">Pseudo(*) :</label>
            <input type="text" name="pseudo" id="pseudo" required class="form-control">
        </div>
        <div class="form-group">
            <label for="nom">Nom(*) :</label><input type="text" name="nom" id="nom" required>
        </div>
        <div class="form-group">
            <label for="prenom">Prenom(*) :</label><input type="text" name="prenom" id="prenom" required>
        </div>
        <div class="form-group">
            <label for="email">Email(*) :</label><input type="email" name="email" id="email" required>
        </div>
        <div class="form-group">
            <label for="telephone">Téléphone :</label><input type="text" name="telephone" id="telephone">
        </div>
        <div class="form-group">
            <label for="code_postal">Code Postal :</label><input type="text" name="code_postal" id="code_postal" required>
        </div>
        <div class="form-group">
            <label for="ville">Ville :</label><input type="text" name="ville" id="ville" required>
        </div>
        <div class="form-group">
            <label for="mot_de_passe">Mot de Passe :</label><input type="password" name="mot_de_passe" id="mot_de_passe" required>
        </div>
        <div class="form-group">
            <label for="confirm_mot_de_passe">Confirmation Mot de Passe :</label><input type="password" name="confirm_mot_de_passe" id="confirm_mot_de_passe" required>
        </div>
        <div class="form-group">
        <button>Valider</button>
        </div>
    </form>
</body>
</html>

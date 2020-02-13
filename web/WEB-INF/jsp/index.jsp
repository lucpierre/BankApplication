<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <title>Login Page</title>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class ="col">
                    <h1> Bienvenue sur notre site de banque en ligne </h1>
                </div>
                <div class="w-100"></div>
                <div class="col">
                    <div>
                        <img src="${pageContext.request.contextPath}/img/logo.png" class="w-25" alt="">
                     </div>
                </div>
                <div class="w-100"></div>
                <div class ="col">
                    <h2> Connexion </h2>
                    <form method="POST" action="result.htm">
                        <div class="form-group">
                            <label>Entrez votre nom de compte : </label>
                            <input type="text" class="form-control" name="ndc" placeholder="Nom de compte">
                        </div>
                        <div class="form-group">
                            <label>Entrez votre mot de passe : </label>
                            <input type="password" class="form-control" name="mdp" placeholder="Mot de passe">
                        </div>
                        <button type="submit" class="btn btn-primary">Connexion</button>
                        <small class="form-text text-muted">Ne jamais partager son nom de compte et son mot de passe : ce sont des informations PERSONNELLES</small>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/styleLogin.css">
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
                    <div class="card">
                        <img src="${pageContext.request.contextPath}/img/logo.png" class="card-img-top" alt="">
                     </div>
                </div>
                <div class="w-100"></div>
                <div class ="col">
                    <h2> Connexion </h2>
                    <form method="POST" action="result.htm">
                        <fieldset>
                            <div>Entrez votre login : <input type=text name=login></div>
                            <div>Entrez votre mot de passe : <input type=text name=mdp></div>
                            <input type=submit value="OK">
                        </fieldset>
                    </form>
                </div>
                <div class="w-100"></div>
                <div class ="col">
                    <h2> Inscription </h2>
                    <form method="POST" action="result.htm">
                        <fieldset>
                            <div>Ma civilité <input type=radio name=madame><input type=radio name=monsieur></div>
                            <div>Entrez votre nom : <input type=text name=nom></div>
                            <div>Entrez votre prenom : <input type=text name=prenom></div>
                            <div>Votre numéro de téléphone <input type=tel name=phone></div>
                            <div>Entrez votre adresse mail : <input type=email name=mail></div>
                            <div>Entrez votre date de naissance : <input type=date name=dateB></div>
                            <div>Entrez votre login : <input type=text name=loginP></div>
                            <div>Entrez votre mot de passe : <input type=password name=mdpP></div>
                            <div>Professionnel (cocher la case si oui) : <input type=radio name=pro></div>
                            <div>N°Siret : <input type=text name=nSiret></div>
                            <div>Entrez votre identifiant de compte : <input type=text name=idCompte></div>
                            <input type=submit value="OK">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

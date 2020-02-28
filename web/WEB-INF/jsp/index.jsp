<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="dependencies_css.jsp"%>
        <title>Login Page</title>
    </head>

    <body class="connexion-page mt-5">
        <div class="container">
            <div class="row">
                <div class="col-2"></div>
                <div class ="col-8">
                    <div class="text-center">
                        <img src="${pageContext.request.contextPath}/img/logo.png" class="w-25" alt="logo">
                    </div>
                    
                    <form method="POST" action="login.htm">
                        <div class="form-group">
                            <label for="input_login">Login : </label>
                            <input type="text" id="input_login" class="form-control" name="login" placeholder="Login">
                        </div>
                        
                        <div class="form-group">
                            <label for="input-mot-de-passe">Mot de passe : </label>
                            <input type="password" id="input-mot-de-passe" class="form-control" name="password" placeholder="Mot de passe">
                        </div>
                        
                        <button type="submit" class="btn btn-primary">Connexion</button>
                        <small class="form-text text-muted">Ne jamais partager ses identifiants : ce sont des informations PERSONNELLES !</small>
                    </form>
                </div>
                <div class="col-2"></div>
            </div>
        </div>
        
        <%@include file="dependencies_js.jsp"%>
    </body>
</html>
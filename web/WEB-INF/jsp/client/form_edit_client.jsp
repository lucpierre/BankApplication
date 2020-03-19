<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../dependencies_css.jsp"%>
        <title>Management Clients</title>
    </head>
    <body>
        <div class="container-fluid row">
            
            <%@include file="../menuAdvisor.jsp"%>
            
            <div class="col-9">
                
                <!-- Section pour le formulaire d'édition d'un client -->
                <section>
                    <div class="section-title">
                        <h2>Modification de profil ${client.civility} ${client.lastName}</h2>
                    </div>
                    
                    <form>
                        <div class="container-fluid row">
                            <div class="form-group col">
                                <label for="last_name_input">Nom</label>
                                <input type="text" class="form-control" id="last_name_input">
                            </div>
                            
                            <div class="form-group col">
                                <label for="first_name_input">Prénom</label>
                                <input type="text" class="form-control" id="first_name_input">
                            </div>
                        </div>
                        
                        <div class="container-fluid row">
                            <div class="form-group col">
                                <label for="login_input">Login</label>
                                <input type="text" class="form-control" id="login_input">
                            </div>

                            <div class="form-group col">
                                <label for="password_input">Mot de passe</label>
                                <input type="password" class="form-control" id="password_input">
                            </div>
                        </div>
                            
                        
                        <div class="form-group">
                            <label for="email_input">Adresse mail</label>
                            <input type="email" class="form-control" id="email_input">
                        </div>
                        
                        <div class="form-group">
                            <label for="phone_input">Téléphone</label>
                            <input type="tel" class="form-control" id="phone_input"  pattern="([0-9]{2}-){4}[0-9]{2}">
                            <small>Format attendu : XX-XX-XX-XX-XX</small>
                        </div>
                        
                        <div class="form-group">
                            <label for="address_input">Adresse</label>
                            
                            <textarea class="form-control" id="address_input" rows="6" cols="50"></textarea>
                        </div>
                        
                        <div class="form-group">
                            <label for="birthday_input">Jour de naissance</label>
                            <input type="date" class="form-control" id="birthday_input">
                        </div>
                        
                        <div class="form-group text-right mt-5 mb-5">
                            <c:if test = "${null == client}">
                                <button type="submit" class="btn btn-secondary">Ajouter</button>
                            </c:if>

                            <c:if test = "${null != client}">
                                <button type="submit" class="btn btn-secondary">Modifier</button>
                            </c:if>
                        </div>
                            
                    </form>
                </section>
                
            </div>
        </div>
            
        <%@include file="../dependencies_js.jsp"%>
    </body>
</html>

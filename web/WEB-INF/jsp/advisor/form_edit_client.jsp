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
            
            <%@include file="menuAdvisor.jsp"%>
            
            <div class="col-9">
                
                <!-- Section pour le formulaire d'édition d'un client -->
                <section>
                    <div class="section-title">
                        <h2>Modification de profil ${client.civility} ${client.lastName}</h2>
                    </div>
                    
                    <form method="POST" action="edit_client.htm?id=${client.id}">
                        
                        <c:if test="${null != alert_msg}">
                            <div class="alert alert-danger" role="alert">
                                <i class="material-icons mr-2 align-bottom">info</i> ${alert_msg}
                            </div>
                        </c:if>
                        
                        <c:if test="${null != info_msg}">
                            <div class="alert alert-info" role="alert">
                                <i class="material-icons mr-2 align-bottom">info</i> ${info_msg}
                            </div>
                        </c:if>
                        
                        <div class="container-fluid row pr-0">
                            <div class="form-group col pr-0">
                                <label for="last_name_input">Nom</label>
                                <input type="text" class="form-control" id="last_name_input" name="last_name_input" value="${client.lastName}">
                            </div>
                            
                            <div class="form-group col pr-0">
                                <label for="first_name_input">Prénom</label>
                                <input type="text" class="form-control" id="first_name_input" name="first_name_input" value="${client.firstName}">
                            </div>
                        </div>
                        
                        <div class="container-fluid row pr-0">
                            <div class="form-group col pr-0">
                                <label for="login_input">Login</label>
                                <input type="text" class="form-control" id="login_input" name="login_input" value="${client.login}">
                            </div>

                            <div class="form-group col pr-0">
                                <label for="password_input">Mot de passe</label>
                                <input type="password" class="form-control" id="password_input" name="password_input" value="${client.password}">
                            </div>
                        </div>
                            
                            <div class="container-fluid">
                            <div class="form-group">
                                <label for="mail_input">Adresse mail</label>
                                <input type="email" class="form-control" id="mail_input" name="mail_input" value="${client.mail}">
                            </div>

                            <div class="form-group">
                                <label for="phone_input">Téléphone</label>
                                <input type="tel" class="form-control" id="phone_input" name="phone_input" pattern="([0-9]{10})" value="${client.phone}">
                                <small>Format attendu : XX-XX-XX-XX-XX</small>
                            </div>

                            <div class="form-group">
                                <label for="address_input">Adresse</label>

                                <textarea class="form-control" id="address_input" name="address_input" rows="6" cols="50">${client.address}</textarea>
                            </div>

                            <div class="form-group">
                                <label for="birthday_input">Jour de naissance</label>
                                <input type="date" class="form-control" id="birthday_input" name="birthday_input" value="${client.formattedBirthday}">
                            </div>

                            <div class="form-group text-right mt-5 mb-5">
                                <c:if test = "${null == client}">
                                    <button type="submit" class="btn btn-secondary">Ajouter</button>
                                </c:if>

                                <c:if test = "${null != client}">
                                    <button type="submit" class="btn btn-secondary">Modifier</button>
                                </c:if>
                            </div>
                        </div>
                            
                    </form>
                </section>
                
            </div>
        </div>
            
        <%@include file="../dependencies_js.jsp"%>
    </body>
</html>

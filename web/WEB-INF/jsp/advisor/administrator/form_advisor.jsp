<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../dependencies_css.jsp"%>
        <title>Formulaire consseiller</title>
    </head>
    <body>
        <div class="container-fluid row">
            
            <%@include file="../menuAdvisor.jsp"%>
            
            <div class="col-9">
                
                <!-- Section pour le formulaire d'édition d'un conseiller -->
                <section>
                    <div class="section-title">
                    <c:if test = "${null == advisor}">
                        <h2>Création d'un nouveau conseiller</h2>
                    </c:if>
                    <c:if test = "${null != advisor}">
                        <h2>Modification de profil ${advisor.civility} ${advisor.lastName}</h2>
                    </c:if>
                    </div>
                    
                <c:if test = "${null == advisor}">
                    <form method="POST" action="add_advisor.htm">
                </c:if>
                <c:if test = "${null != advisor}">
                    <form method="POST" action="edit_advisor.htm?id=${advisor.id}">
                </c:if>
                        
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
                        
                        <div class="container-fluid">
                        <c:if test = "${null == advisor}">
                            <div class="form-group">
                                <label for="user_type_input">Type d'utilisateur</label>
                                <select id="user_type_input" name="user_type_input" class="form-control">
                                    <option selected>Conseiller</option>
                                    <option>Administrateur</option>
                                </select>
                            </div>
                        </c:if>
                        </div>
                        
                        <div class="container-fluid row pr-0">
                            
                            <div class="col-3">
                                <div class="mb-1">
                                    <label>Civilité</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="civility_input" id="civility-mr" value="Mr" <c:if test = "${advisor.civility == 'Mr'}">checked</c:if>>
                                    <label class="form-check-label" for="civility-mr">Monsier</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="civility_input" id="civility-ms" value="Mme" <c:if test = "${advisor.civility == 'Mme'}">checked</c:if>>
                                    <label class="form-check-label" for="civility-ms">Madame</label>
                                </div>
                            </div>
                            
                            <div class="form-group col pr-0">
                                <label for="last_name_input">Nom</label>
                                <input type="text" class="form-control" id="last_name_input" name="last_name_input" value="${advisor.lastName}">
                            </div>
                            
                            <div class="form-group col pr-0">
                                <label for="first_name_input">Prénom</label>
                                <input type="text" class="form-control" id="first_name_input" name="first_name_input" value="${advisor.firstName}">
                            </div>
                        </div>
                        
                        <div class="container-fluid row pr-0">
                            <div class="form-group col pr-0">
                                <label for="login_input">Login</label>
                                <input type="text" class="form-control" id="login_input" name="login_input" value="${advisor.login}">
                            </div>

                            <div class="form-group col pr-0">
                                <label for="password_input">Mot de passe</label>
                                <input type="password" class="form-control" id="password_input" name="password_input" value="${advisor.password}">
                            </div>
                        </div>
                            
                        <div class="container-fluid">
                            <div class="form-group">
                                <label for="mail_input">Adresse mail</label>
                                <input type="email" class="form-control" id="mail_input" name="mail_input" value="${advisor.mail}">
                            </div>

                            <div class="form-group">
                                <label for="phone_input">Téléphone</label>
                                <input type="tel" class="form-control" id="phone_input" name="phone_input" pattern="([0-9]{10})" value="${advisor.phone}">
                                <small>Format attendu : XXXXXXXXXX</small>
                            </div>

                            <div class="form-group">
                                <label for="address_input">Adresse</label>
                                <textarea class="form-control" id="address_input" name="address_input" rows="6" cols="50">${advisor.address}</textarea>
                            </div>

                            <div class="form-group">
                                <label for="birthday_input">Jour de naissance</label>
                                <input type="date" class="form-control" id="birthday_input" name="birthday_input" value="${advisor.formattedBirthday}">
                            </div>

                            <div class="form-group text-right mt-5 mb-5">
                                <c:if test = "${null == advisor}">
                                    <button type="submit" class="btn btn-secondary">Ajouter</button>
                                </c:if>

                                <c:if test = "${null != advisor}">
                                    <button type="submit" class="btn btn-secondary">Modifier</button>
                                </c:if>
                            </div>
                        </div>
                            
                    </form>
                </section>
                
            </div>
        </div>
            
        <%@include file="../../dependencies_js.jsp"%>
    </body>
</html>

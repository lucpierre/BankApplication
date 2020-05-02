<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../dependencies_css.jsp"%>
        <title>Espace client</title>
    </head>
    
    <body>
        <div class="container-fluid row wrapper">
            <!-- Include du menu-->
            <%@include file="menuClient.jsp"%>
            
            <!-- Contenu de la page -->
            <div class="col-9">
                
                <!-- Section pour les cartes -->
                <section>
                    <div class="section-title">
                        <h2>Tableau de bord de ${user.civility} ${user.lastName}</h2>
                    </div>

                    <div class="card-deck">
                        <div class="card">
                            <img class="card-img-top card-img" src="${pageContext.request.contextPath}/img/hand_coin.png" alt="">
                            <div class="card-body">
                                <a href="#">
                                    <h5 class="card-title">Comptes</h5>
                                </a>
                                <p class="card-text">Gérer votre compte courant.</p>
                                <p class="card-text"><a href="#" class="btn btn-primary">Accéder aux comptes</a></p>
                            </div>
                        </div>
                            
                        <div class="card">
                            <img class="card-img-top card-img" src="${pageContext.request.contextPath}/img/hand_pig.png" alt="">
                            <div class="card-body">
                                <a href="#">
                                    <h5 class="card-title">Livrets</h5>
                                </a>
                                <p class="card-text">Gérer votre livret courant.</p>
                                <p class="card-text"><a href="#" class="btn btn-primary">Accéder aux livrets</a></p>
                            </div>
                        </div>
                            
                        <div class="card">
                            <img class="card-img-top card-img" src="${pageContext.request.contextPath}/img/hand_bank.png" alt="">
                            <div class="card-body">
                                <a href="#">
                                    <h5 class="card-title">Transactions</h5>
                                </a>
                                <p class="card-text">Gérer vos virements.</p>
                                <p class="card-text"><a href="#" class="btn btn-primary">Accéder aux transactions</a></p>
                            </div>
                        </div>
                            
                    </div>
                </section>
                            
                <!-- Section pour les cartes -->
                <section>
                    <div class="section-title">
                        <h2>Aperçu des contrats</h2>
                    </div>
                    
                    <div class="card-deck">
                        <c:forEach items="${user.accounts}" var="account">
                        <div class="card">
                            <div class="card-header">
                                <a href="#">
                                    <h5>
                                        <c:if test="${account.accountType == 'CurrentAccountEntity'}">
                                            Compte courant
                                        </c:if>
                                        <c:if test="${account.accountType == 'SavingAccountEntity'}">
                                            Livret A
                                        </c:if>
                                    </h5>
                                </a>
                                <small>N° ${account.accountNumber}</small>
                            </div>

                            <div class="card-body text-right">
                                <h3>${account.balance} €</h3>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                    
                </section>
                
            </div>
        </div>
                                
        <%@include file="../dependencies_js.jsp"%>
    
    </body>
</html>

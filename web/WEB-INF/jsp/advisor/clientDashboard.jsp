<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../dependencies_css.jsp"%>
        <title>Espace conseiller</title>
    </head>
    
    <body>
        <div class="container-fluid row">
            <!-- Include du menu-->
            <%@include file="menuAdvisor.jsp"%>
            
            <!-- Contenu de la page -->
            <div class="col-9">
                <!-- Section pour les cartes -->
                <section>
                    <div class="section-title">
                        <h2>${client.civility} ${client.lastName} ${client.firstName}</h2>
                    </div>
                    
                    <div class="mb-5">
                        <a class="btn btn-primary btn-sm" href="add_client_account.htm?id=${client.id}" role="button">
                            <i class="material-icons align-bottom mr-2">add</i><span class="align-top">Nouveau contrat</span>
                        </a>
                        
                        <a class="btn btn-secondary btn-sm" href="#" role="button">
                            <i class="material-icons align-bottom mr-2">edit</i><span class="align-top">Modifier les informations</span>
                        </a>
                        
                        <a class="btn btn-danger btn-sm" href="#" role="button">
                            <i class="material-icons align-bottom mr-2">delete</i><span class="align-top">Supprimer</span>
                        </a>
                    </div>
                    
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
                    
                    <c:forEach items="${client.accounts}" var="account">
                    <div class="card mb-3">
                        <div class="card-header">
                            <div class="row">
                                <div class="col-sm-6">
                                    <h5>${account.accountType}</h5>
                                    <small>N° ${account.accountNumber}</small>
                                </div>
                                <div class="col-sm-6 text-right">
                                    <h3>${account.balance} €</h3>
                                </div>
                            </div>
                        </div>
                        <div class="card-body">
                            <p>
                                <a href="#"><i class="material-icons align-bottom mr-2">chevron_right</i> Afficher la liste des dernières transactions.</a>
                            </p>

                            <p>
                                <a href="#"><i class="material-icons align-bottom mr-2">chevron_right</i> Effectuer un virement vers un autre compte ou livret.</a>
                            </p>

                            <p>
                                <a href="remove_client_account.htm?id=${client.id}&account_id=${account.id}" class="text-danger"><i class="material-icons align-bottom mr-2">chevron_right</i> Clôturer le compte.</a>
                            </p>
                        </div>
                    </div>
                    </c:forEach>

                </section>
                            
            </div>
  
        </div>
                                
        <%@include file="../dependencies_js.jsp"%>
    
    </body>
</html>

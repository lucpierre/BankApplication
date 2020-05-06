<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="dependencies_css.jsp"%>
        <title>Livret A</title>
    </head>
    
    <body>
        <div class="container-fluid row">
            <!-- Include du menu-->
            <%@include file="menuClient.jsp"%>
            
            <!-- Contenu de la page -->
            <div class="col-9">
                <!-- Section identité -->
                <section>
                    <div class="section-title">
                        <h2>Livret A</h2>
                    </div>
                    
                    <div class="jumbotron">
                        <div class="constainer-fluid row">
                            <div class="col-sm-6">
                                <!-- <h3>Mr ${user_last_name} ${user_first_name}</h3> -->
                                <h3>M nom prenom</h3>
                                <!-- <p class="text-muted">${num_account}</p> -->
                                <p class="text-muted">numero livret</p>
                            </div>
                            
                            <div class="col-sm-6 text-right pt-3">
                                <!-- <h3>${account_balance} €</h3> -->
                                <h3>500,0 €</h3>
                            </div>
                        </div>
                    </div>
                </section>
                            
                <!-- Section pour les cartes -->
                <section>
                    <div class="section-title">
                        <h2>Dernières opérations</h2>
                    </div>
                    
                    <!-- Trouver une solution pour le compléter à l'aide des infos récupérées depuis le controleur -->
                    <%@include file="lastsDeals.jsp"%>
                </section>

                
            </div>
  
        </div>
                                
        <%@include file="dependencies_js.jsp"%>
    
    </body>
</html>


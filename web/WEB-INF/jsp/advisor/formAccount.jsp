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
                <!-- Section -->
                <section>
                    <div class="section-title">
                        <h2>Création d'un nouveau compte pour ${client.civility} ${client.lastName} ${client.firstName}</h2>
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
                    
                    <form action="add_client_account.htm?id=${client.id}" method="post">
                        <div class="form-group">
                            <label for="account_type_input">Type de compte</label>
                            <select class="form-control" id="account_type_input" name="account_type_input">
                                <option value="CurrentAccountEntity">Compte courant</option>
                                <option value="SavingAccountEntity">Livret A</option>
                            </select>
                        </div>
                        
                        <div class="form-group">
                            <label for="balance_input">Solde à l'ouverture</label>

                            <input type="number" step="0.01" placeholder="0.00€" class="form-control" id="balance_input" name="balance_input">
                        </div>
                        
                        <div class="text-right mt-2">
                            <button type="submit" class="btn btn-primary">
                                <i class="material-icons mr-2 align-bottom">add</i>Ajouter
                            </button>
                        </div>
                    </form>
                    
                </section>
                            
            </div>
  
        </div>
                                
        <%@include file="../dependencies_js.jsp"%>
    
    </body>
</html>
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
                
                <!-- Section pour la liste des utilisateurs -->
                <section>
                    <div class="section-title">
                        <div class=" row container-fluid pr-0 mr-5">
                            <div class="col p-0">
                                <h2>Clients</h2>
                            </div>
                            <div class="col text-right p-0">
                                <p>
                                    <a class="btn btn-primary btn-sm" href="add_client.htm" role="button">
                                        <i class="material-icons mr-2 align-bottom">person_add</i> Nouveau client
                                    </a>
                                </p>
                            </div>
                        </div>
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
                    
                    <div class="mb-5 mt-5 container-fluid row">
                        <div class="col">
                            <h4>Catégories d'utilisateurs :</h4>
                        </div>
                        <div class="col">
                            <p><i class="material-icons align-bottom">person_outline</i> Particulier</p>
                        </div>
                        <div class="col">
                            <p><i class="material-icons align-bottom">work_outline</i> Professionnel</p>
                        </div>
                    </div>
                    
                    <div class="sub-section-title">
                        <h4>Clients supervisés</h4>
                    </div>
                    
                    <table class="table">
                        <thead class="header">
                            <tr class="contents">    
                                <th scope="col" style="width: 5em;">Catégorie</th>
                                <th scope="col">Identité</th>
                                <th scope="col">Téléphone</th>
                                <th scope="col" style="width: 15em;">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ supervised_clients }" var="client">
                                <tr class="contents">
                                    <td class="text-center">
                                        <c:if test="${client.userType.equals('ProfessionalEntity')}">
                                            <i class="material-icons align-bottom">work_outline</i>
                                        </c:if>
                                        <c:if test="${client.userType.equals('ClientEntity')}">
                                            <i class="material-icons align-bottom">person_outline</i>
                                        </c:if>
                                    </td>
                                    <td>
                                        <a href="client_dashboard.htm?id=${client.id}">
                                            ${ client.civility } ${ client.lastName } ${ client.firstName }
                                        </a>
                                    </td>
                                    <td>${ client.phone }</td>
                                    <td class="text-right">
                                        <a class="btn btn-secondary btn-sm" href="edit_client.htm?id=${client.id}" role="button">
                                            <i class="material-icons align-bottom">edit</i>
                                        </a>
                                        <a class="btn btn-danger btn-sm" href="delete_client.htm?id=${client.id}" role="button" onclick="return confirm('Êtes vous sûr de vouloir supprimer ce client ?')">
                                            <i class="material-icons align-bottom">delete</i>
                                        </a>
                                        <a class="btn btn-primary btn-sm" href="#" role="button">
                                            <i class="material-icons align-bottom">mail</i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    
                    <div class="sub-section-title">
                        <h4>Tous les clients</h4>
                    </div>
                    
                    <table class="table">
                        <thead class="header">
                            <tr class="contents">    
                                <th scope="col" style="width: 5em;">Catégorie</th>
                                <th scope="col">Identité</th>
                                <th scope="col">Téléphone</th>
                                <th scope="col" style="width: 15em;">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ clients }" var="client">
                                <tr class="contents">
                                    <td class="text-center">
                                        <c:if test="${client.userType.equals('ProfessionalEntity')}">
                                            <i class="material-icons align-bottom">work_outline</i>
                                        </c:if>
                                        <c:if test="${client.userType.equals('ClientEntity')}">
                                            <i class="material-icons align-bottom">person_outline</i>
                                        </c:if>
                                    </td>
                                    <td>
                                        <a href="client_dashboard.htm?id=${client.id}">
                                            ${ client.civility } ${ client.lastName } ${ client.firstName }
                                        </a>
                                    </td>
                                    <td>${ client.phone }</td>
                                    <td class="text-right">
                                        <a class="btn btn-secondary btn-sm" href="edit_client.htm?id=${client.id}" role="button">
                                            <i class="material-icons align-bottom">edit</i>
                                        </a>
                                        <a class="btn btn-danger btn-sm" href="delete_client.htm?id=${client.id}" role="button" onclick="return confirm('Êtes vous sûr de vouloir supprimer ce client ?')">
                                            <i class="material-icons align-bottom">delete</i>
                                        </a>
                                        <a class="btn btn-primary btn-sm" href="#" role="button">
                                            <i class="material-icons align-bottom">mail</i>
                                        </a>
                                        <a class="btn btn-primary btn-sm" href="add_supervised_client.htm?client_id=${client.id}" role="button">
                                            <i class="material-icons align-bottom">group_add</i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>                    
                </section>
                
            </div>
        </div>
            
        <%@include file="../dependencies_js.jsp"%>
    </body>
</html>

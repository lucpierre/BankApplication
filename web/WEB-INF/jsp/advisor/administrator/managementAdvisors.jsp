<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../../dependencies_css.jsp"%>
        <title>Management Conseillers</title>
    </head>
    <body>
        <div class="container-fluid row">
            
            <%@include file="../menuAdvisor.jsp"%>
            
            <div class="col-9">
                
                <!-- Section pour la liste des utilisateurs -->
                <section>
                    <div class="section-title">
                        <div class=" row container-fluid pr-0 mr-5">
                            <div class="col p-0">
                                <h2>Conseillers</h2>
                            </div>
                            <div class="col text-right p-0">
                                <p>
                                    <a class="btn btn-primary btn-sm" href="add_advisor.htm" role="button">
                                        <i class="material-icons mr-2 align-bottom">person_add</i> Nouveau conseiller
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
                    
                    <table class="table">
                        <thead class="header">
                            <tr class="contents">    
                                <th scope="col">Nom</th>
                                <th scope="col">Prénom</th>
                                <th scope="col">Téléphone</th>
                                <th scope="col" style="width: 10em;">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ advisors }" var="advisor">
                                <tr class="contents">
                                    <td><c:out value="${ advisor.lastName }" /></td>
                                    <td><c:out value="${ advisor.firstName }" /></td>
                                    <td><c:out value="${ advisor.phone }" /></td>
                                    <td class="text-right">
                                        <a class="btn btn-secondary btn-sm" href="edit_advisor.htm?id=${advisor.id}" role="button">
                                            <i class="material-icons align-bottom">edit</i>
                                        </a>
                                        <a class="btn btn-danger btn-sm" href="delete_advisor.htm?id=${advisor.id}" role="button" onclick="return confirm('Êtes vous sûr de vouloir supprimer ce conseiller ?')">
                                            <i class="material-icons align-bottom">delete</i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>                    
                </section>
                
            </div>
        </div>
            
        <%@include file="../../dependencies_js.jsp"%>
    </body>
</html>

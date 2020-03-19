<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="dependencies_css.jsp"%>
        <title>Management Clients</title>
    </head>
    <body>
        <div class="container-fluid row">
            
            <%@include file="menuAdvisor.jsp"%>
            
            <div class="col-9">
                
                <!-- Section pour la liste des utilisateurs -->
                <section>
                    <div class="section-title">
                        <h2>Clients</h2>
                    </div>
                    
                    <table class="table">
                        <thead class="header">
                            <tr class="contents">    
                                <th scope="col">N° Client</th>
                                <th scope="col">Nom</th>
                                <th scope="col">Prénom</th>
                                <th scope="col">Téléphone</th>
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${ clients }" var="client">
                                <tr class="contents">
                                    <td><c:out value="${ client.id }" /></td>
                                    <td><c:out value="${ client.lastName }" /></td>
                                    <td><c:out value="${ client.firstName }" /></td>
                                    <td><c:out value="${ client.phone }" /></td>
                                    <td>
                                        <a class="btn btn-secondary btn-sm" href="edit_client.htm?id=${client.id}" role="button">
                                            <i class="material-icons mr-2 align-bottom">edit</i>
                                        </a>
                                        <a class="btn btn-danger btn-sm" href="delete_client.htm?id=${client.id}" role="button">
                                            <i class="material-icons mr-2 align-bottom">delete</i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>                    
                </section>
                
            </div>
        </div>
            
        <%@include file="dependencies_js.jsp"%>
    </body>
</html>

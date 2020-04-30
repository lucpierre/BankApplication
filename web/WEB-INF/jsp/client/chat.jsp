<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../dependencies_css.jsp"%>
        <title>Espace client</title>
    </head>
    
    <body>
        <div class="container-fluid row">
            <!-- Include du menu-->
            <%@include file="menuClient.jsp"%>
            
            <!-- Contenu de la page -->
            <div class="col-9">
                <!-- Section -->
                <section>
                    <div class="section-title">
                        <h2>Conversation avec ${client.advisor.civility} ${client.advisor.lastName} ${client.advisor.firstName}</h2>
                    </div>
                    
                    <div class="chat mb-5">
                        <c:forEach items="${messages}" var="message">
                            <c:if test="${message.sender.userType == 'ProfessionalEntity' || message.sender.userType == 'ClientEntity'}">
                                <div class="media">
                                    <img src="${pageContext.request.contextPath}/img/avatar_client.png" class="mr-3 pt-2" alt="avatar">
                                    <div class="media-body">
                                        <h5 class="mt-0">${client.civility} ${client.lastName} ${client.firstName}</h5>
                                        <p>
                                            <small>${message.createdAtFormatted}</small>
                                        </p>
                                        <p>    
                                            ${message.content}
                                        </p>
                                    </div>
                                </div>
                            </c:if>
                            
                            <c:if test="${message.sender.userType == 'AdvisorEntity' || message.sender.userType == 'AdministratorEntity'}">
                                <div class="media chat-advisor-message">
                                    <div class="media-body text-right">
                                        <h5 class="mt-0">${client.civility} ${client.lastName} ${client.firstName}</h5>
                                        <p>
                                            <small>${message.createdAtFormatted}</small>
                                        </p>
                                        <p>    
                                            ${message.content}
                                        </p>
                                    </div>
                                    <img src="${pageContext.request.contextPath}/img/avatar_advisor.png" class="ml-3 pt-2" alt="avatar">
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                    
                    <div class="mb-3">
                        <form action="chat_client.htm" method="post" class="row">
                            <div class="col-sm-10">
                                <textarea class="form-control message-content-input" id="message_content" name="message_content" rows="1">Nouveau message</textarea>
                            </div>
                            
                            <div class="col-sm-2 pt-2 text-right">
                                <button type="submit" class="btn btn-primary btn-sm"><i class="material-icons mr-2 align-bottom">send</i> Evoyer</button>
                            </div>
                        </form>
                    </div>

                </section>
                            
            </div>
  
        </div>
                                
        <%@include file="../dependencies_js.jsp"%>
    
    </body>
</html>
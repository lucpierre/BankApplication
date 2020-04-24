<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="col-3 menu">
    <div class="text-center mb-5 mt-5">
        <img src="${pageContext.request.contextPath}/img/logo.png" class="w-50" alt="">
    </div>
    
    <div class="mt-5"> 
        <ul>
            <li>
                <a href="dashboard.htm">
                    <i class="material-icons mr-2 align-bottom">home</i>
                    Tableau de bord
                </a>
            </li>
            <li>
                <a href="list_clients.htm">
                    <i class="material-icons mr-2 align-bottom">group</i>
                    Clients
                </a>
            </li>
            
            <c:if test="${user_type == 'AdministratorEntity'}">
            <li>
                <a href="list_advisors.htm">
                    <i class="material-icons mr-2 align-bottom">work</i>
                    Conseillers
                </a>
            </li>
            </c:if>
            
            <li>
                <a href="#">
                    <i class="material-icons mr-2 align-bottom">menu_book</i>
                    Livrets
                </a>
            </li>
            <li>
                <a href="#">
                    <i class="material-icons mr-2 align-bottom">message</i>
                    Messages
                </a>
            </li>
            <li>
                <a href="#">
                    <i class="material-icons mr-2 align-bottom">settings</i>
                    Paramètres
                </a>
            </li>
            <li>
                <a href="logout.htm" >
                    <i class="material-icons mr-2 align-bottom">power_settings_new</i>
                    Se déconnecter
                </a>
            </li>
        </ul>
    </div>
</nav>


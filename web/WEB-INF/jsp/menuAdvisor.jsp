<%-- 
    Document   : menu
    Created on : 6 févr. 2020, 14:20:36
    Author     : clepaire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<!DOCTYPE html>


<div id="menu" class="col-3">  
    <div>
        <img src="${pageContext.request.contextPath}/img/logo.png" class="w-50" alt="">
    </div>
    <table>
        <tbody>
            <tr>
                <td><i class="material-icons">home</i></td>
                <td class="text">Tableau de bord</td>
            </tr>
            <tr>
                <td><i class="material-icons">group</i></td>
                <td class="text">Clients</td>
            </tr>
            <tr>
                <td><i class="material-icons">menu_book</i></td>
                <td class="text">Livrets</td>
            </tr>
            <tr>
                <td><i class="material-icons">message</i></td>
                <td class="text">Messages</td>
            </tr>
            <tr>
                <td><i class="material-icons">settings</i></td>
                <td class="text">Paramètres</td>
            </tr>
        </tbody>
    </table>
</div>

<%-- 
    Document   : menu
    Created on : 6 févr. 2020, 14:20:36
    Author     : clepaire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<!DOCTYPE html>


<div class="col-3">  
    <div class="card">
        <img src="${pageContext.request.contextPath}/img/logo.png" class="card-img-top" alt="">
    </div>
    <table>
        <tbody>
            <tr>
                <td><i class="material-icons">home</i></td>
                <td class="text">Tableau de bord</td>
            </tr>
            <tr>
                <td><i class="material-icons">euro</i></td>
                <td class="text">Comptes</td>
            </tr>
            <tr>
                <td><i class="material-icons">menu_book</i></td>
                <td class="text">Livrets</td>
            </tr>
            <tr>
                <td><i class="material-icons">sync_alt</i></td>
                <td class="text">Transactions</td>
            </tr>
            <tr>
                <td><i class="material-icons">message</i></td>
                <td class="text">Contact</td>
            </tr>
            <tr>
                <td><i class="material-icons">settings</i></td>
                <td class="text">Paramètres</td>
            </tr>
        </tbody>
    </table>
</div>

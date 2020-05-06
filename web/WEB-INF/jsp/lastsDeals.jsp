<table class="table">
    <thead class="header">
        <tr class="contents">    
            <th scope="col">Date</th>
            <th scope="col">Op�ration</th>
            <th scope="col">R�f�rence</th>
            <th scope="col">Montant</th>
        </tr>
    </thead>
    <tbody>
        <div class="section-title">
                <h2>Derni�res op�rations de ${client.civility} ${client.lastName} ${client.firstName}</h2>
        </div>    
        <tr class="contents">
            <td>Date</td>
            <td>Commentaire</td>
            <td>R�f�rence</td>
            <td>Montant</td>
        </tr>
        <tr>
            <c:forEach items="${banking}" var="banking">
                <td>${banking.createdAtFormatted}</td>
                <td>${banking.comment}</td>
                <td>${banking.reference}</td>
                <c:if test="${banking.debtor == true}">
                    <td>-${banking.cost}</td>
                </c:if>
                <c:if test="${banking.debtor == false}">
                    <td>${banking.cost}</td>
                </c:if>
            </c:forEach>
        </tr>
    </tbody>
</table>
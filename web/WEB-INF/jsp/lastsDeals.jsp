<table class="table">
    <thead class="header">
        <tr class="contents">    
            <th scope="col">Date</th>
            <th scope="col">Opération</th>
            <th scope="col">Référence</th>
            <th scope="col">Montant</th>
        </tr>
    </thead>
    <tbody>
        <div class="section-title">
                <h2>Dernières opérations de ${client.civility} ${client.lastName} ${client.firstName}</h2>
        </div>    
        <tr class="contents">
            <td>Date</td>
            <td>Commentaire</td>
            <td>Référence</td>
            <td>Montant</td>
        </tr>
        <tr>
            <c:forEach items="${banking}" var="banking">
                <td class="text-right"><c:out value="${banking.createdAtFormatted}"</td>
                <td class="text-center"><c:out value="${banking.comment}"</td>
                <td class="text-right"><c:out value="${banking.reference}"</td>
                <c:if test="${banking.debtor == true}">
                    <td class="text-right">-<c:out value="$${banking.cost}"</td>
                </c:if>
                <c:if test="${banking.debtor == false}">
                    <td class="text-right"><c:out value="$${banking.cost}"</td>
                </c:if>
            </c:forEach>
        </tr>
    </tbody>             
</table>
<!DOCTYPE html>
<html>
<head>
    <title>Залізнична каса</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Список доступних потягів</h1>
<#if Session.lastSearch??>
    <div style="background-color: #e7f3fe; border-left: 6px solid #2196F3; margin-bottom: 15px; padding: 10px;">
        <p>Ви нещодавно шукали квитки до міста: <strong>${Session.lastSearch}</strong></p>
    </div>
</#if>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Напрямок</th>
        <th>Час відправлення</th>
        <th>Ціна</th>
    </tr>
    <#list trains as train>
        <tr>
            <td>${train.id}</td>
            <td>${train.destination}</td>
            <td>${train.departureTime}</td>
            <td>${train.price}</td>
        </tr>
    </#list>

</table>
</body>
</html>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Мої квитки</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-4">
    <div class="container">
        <a class="navbar-brand" href="/">🚆 Railway System</a>
        <div class="navbar-nav">
            <a class="nav-link" href="/trains">Всі потяги</a>
            <a class="nav-link active" href="/my-tickets">Мої квитки</a>
        </div>
    </div>
</nav>

<div class="container">
    <div class="card shadow-sm">
        <div class="card-header bg-white py-3">
            <h3 class="card-title mb-0 text-primary">Придбані квитки: ${passenger.fullName}</h3>
        </div>
        <div class="card-body">
            <table class="table table-hover align-middle">
                <thead class="table-light">
                <tr>
                    <th>№ Квитка</th>
                    <th>Потяг</th>
                    <th>Дата покупки</th>
                    <th>Ціна</th>
                </tr>
                </thead>
                <tbody>
                <#list tickets as ticket>
                    <tr>
                        <td>#${ticket.id}</td>
                        <td><strong>${ticket.train.destination}</strong></td>
                        <td>${ticket.purchaseDate}</td>
                        <td>${ticket.train.price} грн</td>
                    </tr>
                </#list>
                </tbody>
            </table>
            <#if tickets?size == 0>
                <div class="text-center py-4">
                    <p class="text-muted">У вас поки немає куплених квитків.</p>
                    <a href="/trains" class="btn btn-primary">Купити квиток</a>
                </div>
            </#if>
        </div>
    </div>
</div>
</body>
</html>
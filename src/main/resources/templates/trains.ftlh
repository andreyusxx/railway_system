<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Залізнична каса</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-4">
    <div class="container">
        <a class="navbar-brand" href="/">🚆 Railway System</a>
        <div class="navbar-nav">
            <a class="nav-link active" href="/trains">Всі потяги</a>
            <a class="nav-link" href="#">Мій профіль</a>
        </div>
    </div>
</nav>

<div class="container">
    <#if lastSearch??>
        <div class="alert alert-info shadow-sm" role="alert">
            🔍 Ви нещодавно шукали квитки до міста: <strong>${lastSearch}</strong>
        </div>
    </#if>

    <div class="card shadow-sm">
        <div class="card-header bg-white py-3">
            <h3 class="card-title mb-0 text-primary">Доступні рейси</h3>
        </div>
        <div class="card-body">
            <table class="table table-hover align-middle">
                <thead class="table-light">
                <tr>
                    <th>ID</th>
                    <th>Напрямок</th>
                    <th>Час відправлення</th>
                    <th>Ціна</th>
                    <th class="text-end">Дія</th>
                </tr>
                </thead>
                <tbody>
                <#list trains as train>
                    <tr>
                        <td>${train.id}</td>
                        <td><span class="badge bg-secondary">${train.destination}</span></td>
                        <td>${train.departureTime}</td>
                        <td><strong>${train.price} грн</strong></td>
                        <td class="text-end">
                            <button class="btn btn-sm btn-outline-primary me-2">Деталі</button>
                            <button class="btn btn-sm btn-success">Купити квиток</button>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
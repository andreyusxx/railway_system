<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Панель Адміністратора</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
    <div class="container">
        <a class="navbar-brand" href="/admin/dashboard">Railway Admin</a>
        <div class="navbar-nav ms-auto">
            <span class="nav-link text-light">Вітаємо, <b>${username!"Адмін"}</b></span>
            <a class="nav-link btn btn-danger btn-sm text-white ms-2" href="/logout">Вихід</a>
        </div>
    </div>
</nav>

<div class="container">
    <h2 class="mb-4">Панель управління залізницею</h2>

    <div class="row mb-4">
        <div class="col-md-4">
            <a href="/admin/trains" class="text-decoration-none">
                <div class="card bg-primary text-white shadow-sm h-100">
                    <div class="card-body">
                        <h5 class="card-title"><i class="bi bi-train-front"></i> Всього рейсів</h5>
                        <p class="card-text display-6">${trainsCount}</p>
                    </div>
                </div>
            </a>
        </div>
        <div class="col-md-4">
            <div class="card bg-success text-white shadow-sm h-100">
                <div class="card-body">
                    <h5 class="card-title"><i class="bi bi-people"></i> Користувачів</h5>
                    <p class="card-text display-6">${usersCount}</p>
                </div>
            </div>
        </div>
    </div>

    <div class="card shadow-sm">
        <div class="card-header bg-white d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Список активних рейсів</h5>
            <a href="/admin/trains" class="btn btn-primary btn-sm">
                <i class="bi bi-plus-lg"></i> Управління рейсами
            </a>
        </div>
        <div class="card-body p-0">
            <table class="table table-hover mb-0">
                <thead class="table-light">
                <tr>
                    <th>ID</th>
                    <th>Напрямок</th>
                    <th>Час відправлення</th>
                    <th>Ціна</th>
                    <th>Статус</th>
                    <th>Дії</th>
                </tr>
                </thead>
                <tbody>
                <#list trains as train>
                    <tr>
                        <td>${train.id}</td>
                        <td><b>${train.destination}</b></td>
                        <td>${train.departureTime}</td>
                        <td>${train.price} грн</td>
                        <td>
                            <#if train.active>
                                <span class="badge bg-success">Активний</span>
                            <#else>
                                <span class="badge bg-secondary">Скасований</span>
                            </#if>
                        </td>
                        <td>
                            <div class="btn-group">
                                <a href="/admin/trains" class="btn btn-outline-primary btn-sm">
                                    <i class="bi bi-pencil"></i>
                                </a>
                            </div>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>

<footer class="mt-5 py-3 text-center text-muted border-top">
    &copy; 2026 Залізнична система. Admin Panel v1.4
</footer>

</body>
</html>
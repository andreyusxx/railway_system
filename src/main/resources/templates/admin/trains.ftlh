<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Адміністрування рейсів</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>
<body class="bg-light">

<div class="container mt-4">
    <a href="/admin/dashboard" class="btn btn-secondary mb-4"><i class="bi bi-arrow-left"></i> Назад до панелі</a>

    <h1 class="text-danger mb-4">Керування рейсами</h1>

    <div class="card mb-5 shadow-sm">
        <div class="card-header bg-success text-white">
            <h5 class="mb-0">Додати новий рейс</h5>
        </div>
        <div class="card-body">
            <form action="/admin/train/save" method="post" class="row g-3">
                <div class="col-md-4">
                    <label class="form-label">Напрямок</label>
                    <input type="text" name="destination" class="form-control" placeholder="Київ - Одеса" required>
                </div>
                <div class="col-md-3">
                    <label class="form-label">Ціна (грн)</label>
                    <input type="number" name="price" step="0.01" class="form-control" required>
                </div>
                <div class="col-md-3">
                    <label class="form-label">Час відправлення</label>
                    <input type="datetime-local" name="departureTime" class="form-control" required>
                </div>
                <div class="col-md-2 d-flex align-items-end">
                    <button type="submit" class="btn btn-primary w-100">Додати</button>
                </div>
            </form>
        </div>
    </div>

    <h3 class="mb-3">Редагування існуючих рейсів</h3>
    <div class="card shadow-sm">
        <div class="card-body p-0">
            <table class="table table-striped align-middle mb-0">
                <thead class="table-dark">
                <tr>
                    <th>Напрямок</th>
                    <th>Час відправлення</th>
                    <th>Ціна</th>
                    <th>Активний</th>
                    <th class="text-center">Оновити</th>
                    <th class="text-center">Видалити</th>
                </tr>
                </thead>
                <tbody>
                <#list allTrains as train>
                    <tr>
                        <form action="/admin/train/update" method="post">
                            <input type="hidden" name="id" value="${train.id}">
                            <td><input type="text" name="destination" class="form-control form-control-sm" value="${train.destination}"></td>
                            <td><input type="text" name="departureTime" class="form-control form-control-sm" value="${train.departureTime}"></td>
                            <td><input type="number" name="price" class="form-control form-control-sm" value="${train.price}"></td>
                            <td class="text-center">
                                <input type="checkbox" name="active" class="form-check-input" ${train.active?then('checked', '')}>
                            </td>
                            <td class="text-center">
                                <button type="submit" class="btn btn-warning btn-sm">Оновити</button>
                            </td>
                        </form>
                        <td class="text-center">
                            <form action="/admin/train/delete" method="post" onsubmit="return confirm('Видалити рейс?')">
                                <input type="hidden" name="id" value="${train.id}">
                                <button type="submit" class="btn btn-danger btn-sm">Видалити</button>
                            </form>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
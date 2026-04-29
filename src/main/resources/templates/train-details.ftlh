<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Деталі рейсу</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary mb-4">
    <div class="container">
        <a class="navbar-brand" href="/">🚆 Railway System</a>
    </div>
</nav>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow border-0">
                <div class="card-header bg-primary text-white py-3">
                    <h4 class="mb-0 text-center">Інформація про рейс #${train.id}</h4>
                </div>
                <div class="card-body p-4">
                    <div class="row mb-3">
                        <div class="col-sm-4 text-muted">Напрямок:</div>
                        <div class="col-sm-8 fw-bold fs-5">${train.destination}</div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-sm-4 text-muted">Час відправлення:</div>
                        <div class="col-sm-8">${train.departureTime}</div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-sm-4 text-muted">Вартість:</div>
                        <div class="col-sm-8 text-success fw-bold">${train.price} грн</div>
                    </div>
                    <hr>
                    <p class="text-muted small">Додаткова інформація: Даний рейс виконується фірмовим потягом. У вартість входить постільна білизна та частування чаєм.</p>
                </div>
                <div class="card-footer bg-white d-flex justify-content-between py-3">
                    <a href="/trains" class="btn btn-outline-secondary">Назад до списку</a>
                    <form action="/buy" method="post">
                        <input type="hidden" name="trainId" value="${train.id}">
                        <button type="submit" class="btn btn-success">Придбати квиток за ${train.price} грн</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
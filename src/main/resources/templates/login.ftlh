<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <title>Вхід у систему</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { display: flex; align-items: center; justify-content: center; height: 100vh; background-color: #f8f9fa; }
        .login-form { width: 100%; max-width: 400px; padding: 15px; background: white; border-radius: 10px; shadow: 0 4px 6px rgba(0,0,0,0.1); }
    </style>
</head>
<body>

<div class="login-form shadow-sm border p-4">
    <h2 class="text-center mb-4 text-primary">🚆 Вхід</h2>

    <#if RequestParameters.error??>
        <div class="alert alert-danger text-center">Невірний логін або пароль</div>
    </#if>

    <form action="/login" method="post">
        <div class="mb-3">
            <label class="form-label">Логін</label>
            <input type="text" name="username" class="form-control" placeholder="Введіть ваш логін" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Пароль</label>
            <input type="password" name="password" class="form-control" placeholder="********" required>
        </div>
        <button type="submit" class="btn btn-primary w-100 py-2">Увійти</button>
    </form>

    <div class="mt-3 text-center">
        <a href="/registration" class="text-decoration-none small">Немає аккаунту? Реєстрація</a>
    </div>
</div>

</body>
</html>
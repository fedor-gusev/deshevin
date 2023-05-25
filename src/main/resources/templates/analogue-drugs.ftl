<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Страница поиска препаратов">
    <meta name="author" content="Ф. Гусев">
    <title>Просмотр аналогов</title>
    <#include "/components/links.ftl">
</head>
<body class="text-center">
    <#include "/components/header.ftl">
    <div class="container">
        <h1>Просмотр аналогов препаратов для:</h1>
    </div>

    <table class="table">
        <thead class="thead-light bg-info">
        <tr>
            <th scope="col">Название</th>
            <th scope="col">Описание</th>
            <th scope="col">Категория</th>
            <th scope="col">Аналог класс</th>
            <th scope="col">Действие</th>
        </tr>
        </thead>
        <#list drugs as drug>

            <tr>
                <td><a href="/drug/${drug.id}">${drug.title}</a></td>
                <td>${drug.description}...</td>
                <td><#if drug.category??>${drug.category}<#else>нет</#if></td>
                <td><#if drug.analogueClass??>${drug.analogueClass}<#else>нет</#if></td>
                <td>
                    <form action="/favourites/add-to-favourites/${drug.id}" method="post">
                        <button type="submit" style = "position:relative; left:10px; top:15px" class="btn">Добавить в избранное</button>
                    </form>
                </td>
            </tr>
        </#list>

    </table>

    <#include "/components/footer.ftl" >
</body>
</html>
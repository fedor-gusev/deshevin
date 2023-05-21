<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Панель добавления лекарств">
    <meta name="author" content="Ю. Марсель">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Избранное</title>

    <style>
        .sign-up-form {
            margin-left: auto;
            margin-right: auto;
            width: 50%;
        }

        .brd {
            border: 4px double black; /* Параметры границы */
            padding: 10px; /* Поля вокруг текста */
        }

    </style>


    <#include "/components/links.ftl">

<body class="text-center">
<#include "/components/header.ftl">
<main class="container">
    <div class="container">
        <h1>Избранное</h1>
    </div>

    <div id="favourites">
        <#list favourites as drug>
            <div id="item" style="margin-left: 20px">
                <div class="mb-3">
                    <label for="title" class="drug-info">Название: ${drug.title}</label>
                </div>
                <div class="mb-3">
                    <label for="description" class="drug-info">Описание: ${drug.description}</label>
                </div>
                <div class="mb-3">
                    <label for="description" class="drug-info">Категория: ${drug.category}</label>
                </div>
                <div class="mb-3">
                    <label for="description" class="drug-info">Класс аналогов: ${drug.analogueClass}</label>
                </div>
                <a href="/favorites/delete-from-favourites/${drug.id}" class="del-from-fav">удалить из избранного</a>
            </div>
            <#if drug_index < favourites?size - 1>
                <div class="divider"></div>
            </#if>
        </#list>
        <div class="mb-3">Всего <span id="drugsCount">${favourites?size}</span> избранных лекарств</div>
    </div>

    <#include "/components/footer.ftl" >


</body>
</html>
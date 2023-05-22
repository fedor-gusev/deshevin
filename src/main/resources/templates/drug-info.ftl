<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Страница информации о лекарстве">
    <meta name="author" content="Ю. Марсель">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Информация о лекарстве</title>

    <#include "/components/links.ftl">


</head>

<body class="text-center">
<#include "/components/header.ftl">
<main class="container">

    <h2>${drug.title}</h2>
    <div class="row justify-content-md-center">
        <#if user.role == 'ADMIN'>
            <form method="post" action="" class="drug-form" enctype="multipart/form-data">
                <div class="col">

                    <div class="alert alert-info" role="alert">Информация</div>
                    <p><strong>Название:</strong>
                        <input class="form-control mb-2" name="title" value="${drug.title}" type="text">
                    </p>
                    <p><strong>Категория:</strong>
                        <select name="categoryId" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                            <option value="" selected>${drug.category}</option>
                            <#list categories as category>
                                <option value="${category.id}">${category.title}</option>
                            </#list>
                        </select>
                    </p>
                    <p><strong>Класс аналог:</strong>
                        <select name="analogueId" class="custom-select mr-sm-2" id="inlineFormCustomSelect">
                            <option name="analogueId" value="" selected>${drug.analogueClass}</option>
                            <#list analogues as analogue>
                                <option value="${analogue.id}">${analogue.title}</option>
                            </#list>
                        </select>
                    </p>

                </div>

                <div class="row">
                    <div class="col align-self-center">
                        <div class="alert alert-dark" role="alert">Описание</div>
                        <textarea class="form-control" id="drugDescription" rows="3"
                                  name="description">${drug.description}</textarea>
                    </div>
                </div>
                <div class="d-flex justify-content-around">
                    <button type="submit" class="btn btn-info mb-2">Изменить</button>
                </div>
            </form>
        <#elseif user.role == 'COMMON_USER'>
            <main class="container">
                <div class="alert alert-info" role="alert">Информация</div>
                <div class="mb-3">
                    <label for="title" class="drug-info">Название: ${drug.title}</label>
                </div>
                <div class="mb-3">
                    <label for="category" class="drug-info">Категория: ${drug.category}</label>
                </div>
                <div class="mb-3">
                    <label for="analogue-class" class="drug-info">Класс аналог: ${drug.analogueClass}</label>
                </div>
            </main>
        </#if>
    </div>

</main>

<#include "/components/footer.ftl" >

</body>
</html>
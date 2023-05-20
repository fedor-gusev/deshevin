<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Панель добавления лекарств">
    <meta name="author" content="Ю. Марсель">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Панель добавления лекарств</title>

    <style>
        .drug-form{
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
        <h1>Панель добавления лекарств</h1>
    </div>

    <#if success??>
    <div class="container">
        <div class="alert alert-success" role="alert">
            Лекарство успешно сохранено!
        </div>
    </div>
    </#if>
<#--    <c:choose>-->
<#--        <c:when test ="${message != null}">-->
<#--            <div class="container">-->
<#--                <div class="alert alert-success" role="alert">-->
<#--                    ${message}-->
<#--                </div>-->
<#--            </div>-->
<#--        </c:when>-->
<#--    </c:choose>-->
    <form method="post" action="/drug" class="drug-form" enctype="multipart/form-data">
    <div class="mb-3">
        <label for="drugTitle" class="form-label">Название лекарства</label>
        <input type="text" class="form-control" id="drugTitle" name="title">
    </div>
    <div class="mb-3">
        <label for="drugDescription" class="form-label">Описание</label>
        <textarea class="form-control" id="drugDescription" rows="3" name="description"></textarea>
    </div>
    <div>Категории лекарства</div>
    <div class ="brd">
        <#list categories as category>
            <div class="form-check form-check-inline">
                <input class="form-check-input" name="categoryId" type="radio" id="inlineRadio2" value="${category.id}">
                <label class="form-check-label" for="inlineRadio2">${category.title}</label>
            </div>
        </#list>
    </div>

    <div>Аналог класс</div>
    <div class ="brd">
        <#list analogues as analogue>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="analogueId" id="inlineRadio1" value="${analogue.id}">
                <label class="form-check-label" for="inlineRadio1">${analogue.title}</label>
            </div>
        </#list>
    </div>
    <br>
    <br>
    <input class="btn btn-info" type="submit" value="Сохранить">

    </form>

    <#include "/components/footer.ftl" >


</body>
</html>
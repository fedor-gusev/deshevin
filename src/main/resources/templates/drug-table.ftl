<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Панель лекарств">
    <meta name="author" content="Ю. Марсель">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Панель лекарств</title>




    <#include "/components/links.ftl">
    <script>
        function delet(id){
            jQuery.ajax({
                url:'/drug?id='+id,
                type:'delete'
            });

        }

    </script>

</head>
<body>
<#include "/components/header.ftl">
<main class="container">
    <h1 class="text-center">База лекарств</h1>

    <table class="table">
        <thead class="thead-light bg-info">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Название</th>
                <th scope="col">Описание</th>
                <th scope="col">Категория</th>
                <th scope="col">Аналог класс</th>
                <th scope="col">Удалить</th>
            </tr>
        </thead>
        <#list drugs as drug>

            <tr>
                <th scope="row">${drug?index + 1}</th>
                <td><a href="/drug/${drug.id}">${drug.title}</a></td>
                <td>${drug.description}...</td>
                <td>${drug.category}</td>
                <td>${drug.analogueClass}</td>
                <td>
                    <button type="submit" onclick="delet('${drug.id}')" style = "position:relative; left:10px; top:15px" class="btn btn-danger">X</button>
                </td>
            </tr>
        </#list>

    </table>
</main>


<#include "/components/footer.ftl" >

</body>
</html>
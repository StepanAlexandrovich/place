<!DOCTYPE html>
<html lang="en">
<head>

    <title>Baskets</title>
<!--    <link rel="stylesheet" href="/static/css/style.css">-->

    <link rel="stylesheet" href="../static/css/style.css" th:href="@{/css/style.css}">

</head>

<body>
<h2> Корзины которые к вам привязаны </h2>
<table>
    <thead>
        <tr>
            <th>Название корзины</th>
            <th>----------------</th>
        </tr>
    </thead>

    <tbody>
       <#list baskets as basket>
           <tr>
               <th>${basket.name}</th>
               <th><a href="/baskets/basket/${basket.id}"> Посмотреть содержимое корзины </a></th>
           </tr>
       </#list>
    </tbody>
</table>

<br>
<br>

<form action="/baskets/add_basket" method="post" >
    имя корзины <input type="text" name="basketName">
    <br>
    <input type="submit" value="add product">
    <br>
</form>

</body>
</html>
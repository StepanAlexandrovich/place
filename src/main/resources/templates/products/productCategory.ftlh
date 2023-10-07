<!DOCTYPE html>
<html lang="en">
<head>

    <title>Product category</title>
<!--    <link rel="stylesheet" href="/static/css/style.css">-->

    <link rel="stylesheet" href="../static/css/style.css" th:href="@{/css/style.css}">

</head>
<!--<style>-->
<!--    table {-->
<!--    font-family: sans-serif;-->
<!--    text-align: left;-->
<!--    border-collapse: separate;-->
<!--    border-spacing: 5px;-->
<!--    background: #ece9e0;-->
<!--    color: #656655;-->
<!--    border: 16px solid #ece9e0;-->
<!--    border-radius: 20px;-->
<!--}-->

<!--thead{-->
<!--    font-size: 18px;-->
<!--    padding: 10px;-->
<!--}-->

<!--tbody{-->
<!--    background: #f5d7bf;-->
<!--    padding: 10px;-->
<!--}-->
<!--</style>-->

<body>
<h2> Product category </h2>
<table>
    <thead>
        <tr>
            <th>Наименование категории</th>
            <th>Список подкатегорий</th>
        </tr>
    </thead>

    <tbody>
       <#list productCategories as category>
           <tr>
               <th>${category.name}</th>
               <th><a href="/product_subcategory/${category.id}"> Посмотреть список подкатегорий </a></th>
           </tr>
       </#list>
    </tbody>
</table>
<br>
<br>

<#if userRole=="ROLE_ADMIN">
<form action="/admin/add_product_category" method="post" >
    Category name <input type="text" name="name">
    <br>
    <input type="submit" value="add category">
    <br>
</form>
</#if>

</body>
</html>
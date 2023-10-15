<!DOCTYPE html>
<html lang="en">
<head>

    <title>Product category</title>
<!--    <link rel="stylesheet" href="/static/css/style.css">-->

    <link rel="stylesheet" href="../static/css/style.css" th:href="@{/css/style.css}">

</head>

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
               <th><a href="/distributor/menu/product_category/product_sub_category/${category.id}"> Посмотреть список подкатегорий </a></th>
           </tr>
       </#list>
    </tbody>
</table>

</body>
</html>
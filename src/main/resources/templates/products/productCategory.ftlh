<!DOCTYPE html>
<html lang="en">
<head>

    <title>Product category</title>
</head>
<style>

</style>

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
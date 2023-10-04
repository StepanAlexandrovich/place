<!DOCTYPE html>
<html lang="en">
<head>

    <title>Product subcategory</title>
</head>
<style>

</style>

<body>
<h2> Product subcategory </h2>
<table>
    <thead>
        <tr>
            <th>Наименование подкатегории</th>
            <th>Список товаров</th>
        </tr>
    </thead>

    <tbody>
       <#list productSubCategories as subcategory>
           <tr>
               <th>${subcategory.name}</th>
               <th><a href="/product/${subcategory.id}"> Посмотреть список товаров </a></th>
           </tr>
       </#list>
    </tbody>
</table>
<br>
<br>

<#if userRole=="ROLE_ADMIN">
<form action="/admin/add_product_subcategory" method="post" >
    SubCategory name <input type="text" name="name">
    <br>
    Reference to ProductCategoryId <input type="value" name="productCategoryId">
    <br>
    <input type="submit" value="add subcategory">
    <br>
</form>
</#if>

</body>
</html>
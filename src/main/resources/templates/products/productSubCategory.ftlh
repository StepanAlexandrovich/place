<!DOCTYPE html>
<html lang="en">
<head>

    <title>Product subcategory</title>
</head>
<style>

</style>

<body>
<h2> Product subcategory from ${productCategory.name} </h2>
<table>
    <thead>
        <tr>
            <th>Наименование подкатегории</th>
            <th>Список товаров</th>
        </tr>
    </thead>

    <tbody>
       <#list productSubCategories as subCategory>
           <tr>
               <th>${subCategory.name}</th>
               <th><a href="/products/${subCategory.id}"> Посмотреть список товаров </a></th>
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
    <input type="hidden" name="productCategoryId" value=${productCategory.id}>
    <br>
    <input type="submit" value="add subcategory">
    <br>
</form>
</#if>

</body>
</html>
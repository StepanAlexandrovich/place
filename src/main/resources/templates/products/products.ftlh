<!DOCTYPE html>
<html lang="en">
<head>

    <title>Products</title>
</head>
<style>

</style>

<body>
<h2> Products from ${productSubCategory.name} </h2>
<table>
    <thead>
        <tr>
            <th>Список товаров</th>
            <th>Что то</th>
        </tr>
    </thead>

    <tbody>
       <#list products as product>
           <tr>
               <th>${product.name}</th>
               <th><a href="/site"> Посмотреть что то </a></th>
           </tr>
       </#list>
    </tbody>
</table>
<br>
<br>

<#if userRole=="ROLE_ADMIN">
<form action="/admin/add_product" method="post" >
    product name <input type="text" name="name">
    <br>
    <input type="hidden" name="productSubCategoryId" value=${productSubCategory.id}>
    <br>
    <input type="submit" value="add product">
    <br>
</form>
</#if>

</body>
</html>
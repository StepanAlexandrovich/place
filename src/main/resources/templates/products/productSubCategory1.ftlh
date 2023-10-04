<!DOCTYPE html>
<html lang="en">
<head>

    <title>Product subcategory</title>
</head>
<style>

</style>

<body>

<h2> Product subcategory </h2>

<!--<#if userRole=="ROLE_ADMIN">-->
<!--<form action="/admin/add_product_subcategory" method="post" >-->
<!--    SubCategory name <input type="text" name="name">-->
<!--    <br>-->
<!--    Reference to ProductCategoryId <input type="value" name="productCategoryId">-->
<!--    <br>-->
<!--    <input type="submit" value="add subcategory">-->
<!--    <br>-->
<!--</form>-->
<!--</#if>-->

<br>
<br>


<table>
    <thead>
        <tr>
            <th>Наименование подкатегории</th>
            <th>Список продуктов</th>
        </tr>
    </thead>

    <tbody>
       <#list productSubCategories as subCategory>
           <tr>
               <th>${subCategory.name}</th>
<!--               <th><a href="/sub_categories/${category.id}"> Посмотреть список продуктов </a></th>-->
           </tr>
       </#list>
    </tbody>
</table>




<br>
<br>




</body>
</html>
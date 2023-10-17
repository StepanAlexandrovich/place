<!DOCTYPE html>
<html lang="en">
<head>
    <title>Product subcategory</title>
</head>
<style>

</style>

<body>
<h2> список подкатегорий из категории ${productCategory.name} </h2>
<table>
    <thead>
        <tr>
            <th>Наименование подкатегории</th>
            <th>Список товаров</th>
        </tr>
    </thead>

    <tbody>
       <#list productCategory.productSubCategories as subCategory>
           <tr>
               <th>${subCategory.name}</th>
               <th><a href="/admin/menu/product_category/product_sub_category/products/${subCategory.id}"> Посмотреть список товаров </a></th>
           </tr>
       </#list>
    </tbody>
</table>
<br>
<br>

<form action="/admin/menu/product_category/product_sub_category/add_product_sub_category" method="post" >
    SubCategory name <input type="text" name="name">
    <br>
    <input type="hidden" name="productCategoryId" value=${productCategory.id}>
    <br>
    <input type="submit" value="add subcategory">
    <br>
</form>

</body>
</html>
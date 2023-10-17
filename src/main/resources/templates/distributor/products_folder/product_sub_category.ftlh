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
               <th><a href="/distributor/menu/product_category/product_sub_category/products/${subCategory.id}"> Посмотреть список товаров </a></th>
           </tr>
       </#list>
    </tbody>
</table>

</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>

    <title>Products</title>

</head>

<body>
<h2> Products from ${productSubCategory.name}  </h2>
<br>

<table>
    <thead>
    <tr>
        <th>Изображение</th>
        <th>Наименование товара</th>
        <th>Подорбнее о товаре</th>
        <th>-------------------</th>
    </tr>
    </thead>

    <tbody>
    <#list productSubCategory.products as product>
    <tr>
        <th> <img src="/image/${product.images[0].id}" width = "100px" height = "100px"> </th>
        <th>${product.name}</th>
        <th><a href="/user/menu/product_category/product_sub_category/products/product/${product.id}">содержимое</a></th>
        <th><a href="/baskets/select_basket/${product.id}">добавить в корзину</a></th>
    </tr>
    </#list>
    </tbody>
</table>

</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Basket</title>
</head>
<style>

</style>

<body>
<h2> Продукт, который вы хотите добавить в корзину -> ${product.name}  </h2>
<h2> Корзины которые к вам привязаны </h2>
<table>
    <thead>
    <tr>
        <th>Название корзины</th>
        <th>----------------</th>
    </tr>
    </thead>

    <tbody>
    <#list baskets as basket>
    <tr>
        <th>${basket.name}</th>
        <th><a href="/baskets/add_product_in_basket/${product.id}/${basket.id}"> Добавить выбранный продукт в эту карзину </a></th>
    </tr>
    </#list>
    </tbody>
</table>

</body>
</html>
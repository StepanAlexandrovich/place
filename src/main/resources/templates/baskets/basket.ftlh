<!DOCTYPE html>
<html lang="en">
<head>
    <title>Basket</title>
</head>
<style>

</style>

<body>
<h2> Продукты из корзины под именем ${basket.name} </h2>
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

<form action="/baskets/add_product_in_basket" method="post" >
    product id <input type="value" name="productId">
    <br>
    <input type="hidden" name="basketId" value=${basket.id}>
    <br>
    <input type="submit" value="add product in basket">
    <br>
</form>

</body>
</html>
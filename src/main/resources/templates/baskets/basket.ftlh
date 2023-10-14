<!DOCTYPE html>
<html lang="en">
<head>
    <title>Basket</title>
</head>
<style>

</style>

<body>
<h2> Продукты, которрые вы положили в корзину под именем ${basket.name} </h2>
<table>
    <thead>
        <tr>
            <th>Список товаров</th>
            <th>Количество</th>
        </tr>
    </thead>

    <tbody>
       <#list basket.basketProducts as bp>
           <tr>
               <th>${bp.product.name}</th>
               <th>${bp.productsCount}</th>
           </tr>
       </#list>
    </tbody>
</table>

</body>
</html>
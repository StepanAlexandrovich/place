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

</body>
</html>
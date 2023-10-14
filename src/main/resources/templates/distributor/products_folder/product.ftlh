<!DOCTYPE html>
<html lang="en">
<head>

    <title>Product</title>

</head>

<body>
<h2>${product.name}</h2>
<br>

<table>
    <thead>
    <tr>
        <th>Изображения</th>
    </tr>
    </thead>

    <tbody>
    <#list product.images as image>
    <tr>
        <th> <img src="/image/${image.id}" width = "100px" height = "100px"> </th>
    </tr>
    </#list>
    </tbody>
</table>

</body>
</html>
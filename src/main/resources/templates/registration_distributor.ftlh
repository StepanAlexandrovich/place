<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>

    <title>Registration</title>
</head>
<body>
<#if distributorCreateDto?? && noErrors??>
Login : ${distributorCreateDto.login}
<br>
Password : ${distributorCreateDto.password}
<br>
Name : ${distributorCreateDto.name}
<br>
<#else>
<form action="/registration_distributor" method="post" >

    Login
    <@spring.formInput "distributorCreateDto.login" />
    <@spring.showErrors "<br>" />

    <br>
    Password
    <@spring.formInput "distributorCreateDto.password" />
    <@spring.showErrors "<br>" />

    <br>
    Name
    <@spring.formInput "distributorCreateDto.name" />
    <@spring.showErrors "<br>" />

    <br>
    <input type="submit" value="Registration">
    <br>
</form>
</#if>
</body>
</html>
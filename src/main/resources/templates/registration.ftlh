<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>

    <title>Registration</title>
</head>
<body>
<#if userDto?? && noErrors??>
Login : ${userDto.login}
<br>
Password : ${userDto.password}
<br>
<#else>
<form action="/registration" method="post" >

    Login
    <@spring.formInput "userDto.login" />
    <@spring.showErrors "<br>" />

    <br>
    Password
    <@spring.formInput "userDto.password" />
    <@spring.showErrors "<br>" />

    <br>
    <input type="submit" value="Registration">
    <br>
</form>
</#if>
</body>
</html>
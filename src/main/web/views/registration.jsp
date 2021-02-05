<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html alng="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Регистрация</title>
</head>
<body>
<jsp:include page="headers/index_header.jsp"/>
<div style="width: 100%; line-height: 800px; vertical-align: bottom">
    <div align="center" style="background-color: gray">
        <form id="clientRegistrationForm" action="successRegClient.jsp" method="post">
            <label>Логин</label>
            <input type="text" name="login"/>
            <label>Пароль</label>
            <input type="password" name="psswd"/>
            <label>Фамилия</label>
            <input type="text" name="surname"/>
            <label>Имя</label>
            <input type="text" name="firstname"/>
            <label>Отчество</label>
            <input type="text" name="lastname"/>
            <input type="submit" name="Зарегистрироваться"/>
        </form>
    </div>
</div>
</body>
</html>

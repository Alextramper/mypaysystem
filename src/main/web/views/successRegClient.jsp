<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Успешная регистрация</title>
</head>
<body>
<jsp:include page="headers/index_header.jsp"/>
<div style="width: 100%; line-height: 800px; vertical-align: bottom">
    <div align="center" style="background-color: lightgray">
        <form id="clientSuccessRegistrationForm" action="enterSystem.jsp" method="post">
            <label>Пользователь</label>
            <output>"${sessionScope.firstname}"</output>
            <label> успешно зарешистрирован</label>
            <br>
            <input type="submit" name="entersystem" value="Перейти в систему"/>
        </form>
    </div>
</div>
</body>
</html>

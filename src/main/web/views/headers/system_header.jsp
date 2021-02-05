<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<table width="100%">
    <tr>
        <td width="30%" align="left"><img src="${pageContext.servletContext.contextPath}/pics/logo.jpg"/></td>
        <td width="40%" align="center"><h1>Платежная система 1.0</h1></td>
        <td width="30%" align="right">
            <form id="profileHeaderSystemForm" action="profile.jsp" method="post">
                <input id="profileHeaderSystemButton" type="submit" name="profileButton" value="Профиль">
            </form>
        </td>
    </tr>
</table>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Conbtent-Type" content="text/html; cherset=UTF-8"/>
</head>
<body>
<table width="100%>">
    <tr>
        <td width="30%" align="left"><img src="${pageContext.servletContext.contextPath}/pics/logo.jpg" width="75%"/></td>
        <td width="40%" align="center"><h1>Профиль</h1></td>
        <td align="right">
            <form id="logoutForm" action=".../logout" method="post">
                <input id="logoutButton" type="submit" name="logoutButton" value="Выйти" style="..."/>
            </form>
        </td>
        <td align="right">
            <form id="profileForm" action="enterSystem.jsp" method="post">
                <input id="profileButton" type="submit" name="profileButton" value="В систему" style="..."/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>

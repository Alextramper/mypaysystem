<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Страница входа</title>
</head>
<body>
<jsp: include page="view/headers/index_header.jsp"/>
<div style="...">
    <div align="center" style="...">
        <form style="..." id="clientIdentForm" action="index" method="post">
             <table align="center" style="...">
                 <tr>
                     <td width="50%" align="right">
                         <input type="submit" name="center" value="Войти"/>
                     <td/>
                     <td width="50%">
                         <input type="submit" name="reg" value="Зарегистрироваться" style="..."/>
                     </td>
                 </tr>
             </table>
        </form>
    </div>
</div>
</body>
</html>

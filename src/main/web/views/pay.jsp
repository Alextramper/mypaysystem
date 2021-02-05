<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<jsp:include page="headers/system_header.jsp"/>
    <div align="center" style="width: 100%; background-color: #c0c0c0; height: 160px">
        <form style="width: 100%; height: 100%" id="payForm" action="../pay" method="post">
            <table>
                <tr>
                    <td><label>Сумма</label></td>
                    <td><input type="number" name="sum"></td>
                </tr>
                <tr>
                    <td><label>Целевой счет</label></td>
                    <td><input type="number" name="payTargetCount"></td>
                </tr>
                <tr>
                    <td colspan="2"><input style="width: 100%" type="submit" value="Оплатить"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>

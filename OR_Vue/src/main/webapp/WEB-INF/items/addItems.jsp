<%@ page import="static java.awt.SystemColor.window" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>增加商品</title>
</head>


<body>

<form action="${pageContext.request.contextPath}/items/addItems.action" method="post">
    <table>
        <tr>
            <td>商品名称<input type="text" name="name" /></td>
            <td>价格<input type="text" name="price" /></td>
            <td>描述<input type="text" name="detail" /></td>
            <td>生产日期<input type="text" name="createtime"></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交" />
            </td>
        </tr>
    </table>
</form>


</body>


</html>
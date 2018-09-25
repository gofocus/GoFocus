<%@ page import="static java.awt.SystemColor.window" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
	<title>查询商品列表</title>
	<script type="text/javascript">
		function deleteItems() {
			document.itemsForm.action="${pageContext.request.contextPath }/items/deleteItems.action";
			document.itemsForm.submit();
		}
		function queryItems() {
			document.itemsForm.action="${pageContext.request.contextPath }/items/queryItems.action";
			document.itemsForm.submit();
		}
	</script>
	<%--<script type="text/javascript" src="${pageContext.request.contextPath }/items/jquery.js"></script>--%>
	<%--<script type="text/javascript">--%>
        <%--function query(){--%>
            <%--$.ajax({--%>
                <%--type : 'post',--%>
				<%--dataType:'json',--%>
                <%--contentType:'application/json;charset=utf-8',--%>
                <%--url:"${pageContext.request.contextPath }/items/login",--%>
				<%--data:'{"username":"guojia"}',--%>
				<%--success:function (data) {--%>
					<%--alert(data.username)--%>
                <%--},--%>
				<%--error:function () {--%>
					<%--alert("fail")--%>
                <%--}--%>
            <%--})--%>
        <%--}--%>
	<%--</script>--%>
</head>

<body>

<form name="itemsForm" action="${pageContext.request.contextPath }/items/queryItems.action" method="post">
	查询条件：
	<table width="20%" border=1>
		<tr>
			<td>商品名称<label><input name="itemsCustom.name"/></label></td>
			<td><input type="button" value="查询" onclick="queryItems()"/></td>
			<td><input type="button" value="删除" onclick="deleteItems()"/></td>
		</tr>
	</table>

	商品列表：<a href="${pageContext.request.contextPath}/items/editItemsQuery.action">批量修改</a>
			<a href="${pageContext.request.contextPath}/items/addItems.action">增加商品</a>

	<table width="100%" border=1>
		<tr>
			<td> </td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>生产日期</td>
			<td>商品描述</td>
			<td>操作</td>
		</tr>
	<c:forEach items="${itemsList }" var="item">
		<tr>
			<td><label><input type="checkbox" name="items_id" value="${item.id}"/></label></td>
			<td>${item.name }</td>
			<td>${item.price }</td>
			<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>${item.detail }</td>
			<td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id}">修改</a></td>
		</tr>
	</c:forEach>


</table>

</form>


</body>

</html>
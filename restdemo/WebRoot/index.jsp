<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	</head>
  
  <body>
    Welcome to index Page <br>
  <p><%=basePath%></p>
  <br>
  <p><%=path%></p>
  <br>
  <p>http://puneetsh02.corp.amdocs.com:8080/restdemo/services/book/</p>
     
    <c:import var="xmlDoc" url="http://puneetsh02.corp.amdocs.com:8080/restdemo/services/book/"/>
     
    <x:parse var="parsedDocument" xml="${xmlDoc}"/>
    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
        </tr>
        <x:forEach select="$parsedDocument/bookVOes">
        <tr>
            <td> <x:out select="id" /> </td>
            <td> <x:out select="title" /> </td>
        </tr>
        </x:forEach>
    </table>

  </body>
</html>

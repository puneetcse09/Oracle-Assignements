<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<html>
<head>

<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var xmlhttp;
	function init() {
		xmlhttp = new XMLHttpRequest();
	}
	
	function getdetails() {
	
		var bookno = document.getElementById("bookno");

		var url = "http://puneetsh02.corp.amdocs.com:8080/restdemo/services/book/"
				+ bookno.value;

		var request = new XMLHttpRequest();
		request.open("GET", url, false);
		request.send();
		var xml = request.responseXML;
		var users = xml.getElementsByTagName("bookVO");
		for (var i = 0; i < users.length; i++) {
			var user = users[i];
			var names = user.getElementsByTagName("title");

			var id = user.getElementsByTagName("id");

			for (var j = 0; j < names.length; j++) {
				// 				alert(names[j].childNodes[0].nodeValue);
				bookTitle.value = names[j].childNodes[0].nodeValue;
			}

			for (var k = 0; k < id.length; k++) {
				// 				alert(id[k].childNodes[0].nodeValue);
				bookid.value = id[k].childNodes[0].nodeValue;
			}
		}
	};
	
	function updateBook() {
	
// 	alert(bookid.value);
	book.updateBook(bookid.value, bookTitle.value);
		
	}
	
	function deleteBook() {
	
// 	alert(bookid.value);
	book.deleteBook(bookid.value);
		
	}
</script>
</head>
<body onload="init()">

	<jsp:useBean id="book" class="books.BookResources" />
	<h3>Books Summary:</h3>
	<c:import var="xmlDoc"
		url="http://puneetsh02.corp.amdocs.com:8080/restdemo/services/book/" />
	<x:parse xml="${xmlDoc}" var="output" />
	<ul class="list">
		<x:forEach select="$output/bookVOes/bookVO" var="item">
			<tr>
				<li>Book Id : <x:out select="$item/id" /> Title : <x:out
						select="$item/title" /></li>
			</tr>
		</x:forEach>
	</ul>
	<h1>Call Book Service</h1>
	<table>
		<tr>
			<td>Enter Book ID :</td>
			<td><input type="text" id="bookno" size="10" /> <input
				type="button" value="Get Details" onclick="getdetails()" />
		</tr>

	</table>

	<table border="2">

		<tr>
			<td>
				<h3>Books Info:</h3>
			</td>
			<td>Book Id : <input type="text" id="bookid" size="10" /></td>
			<td>Book Title : <input type="text" id="bookTitle" size="10" /></td>
		</tr>
<!-- 		<tr> -->
<!-- 			<td><h3>Author Info:</h3></td> -->
<!-- 			<td>Author Id : <input type="text" id="autid" size="10" /></td> -->
<!-- 			<td>Author Name : <input type="text" id="autname" size="10" /></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td></td> -->
<!-- 			<td>Author Last Name : <input type="text" id="authlname" -->
<!-- 				size="10" /></td> -->
<!-- 			<td>Author DOB : <input type="text" id="authdob" size="10" /></td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td><h3>Category Info:</h3></td> -->
<!-- 			<td>Category Id : <input type="text" id="catid" size="10" /></td> -->
<!-- 			<td>Category Name : <input type="text" id="catname" size="10" /></td> -->
<!-- 		</tr> -->
		<tr>
			<td></td>
			<td><input type="button" value="Update Details" onclick="updateBook()"/></td>
			<td><input type="button" value="Delete Book" onclick="deleteBook()"/></td>
			<td></td>
		</tr>

	</table>


</body>
</html>
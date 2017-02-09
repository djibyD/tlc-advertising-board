<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%-- //[START imports]--%>
<%@ page import="servlet.Add" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- //[END imports]--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board</title>
</head>
<body>
	<h1>New add</h1>

	<form action="main.jsp" method="POST">
		Title: <input type="text" name="title"> <br />
		Price: <input type="text" name="price" /><br />
		Date: <input type="text" name="date" /> <br />
		<input type="submit"
			value="Submit" />
	</form>
	
	<%-- //[START datastore]--%>
	<%
    // Run an ancestor query to ensure we see the most up-to-date
    // view of the Greetings belonging to the selected Guestbook.
      List<Add> adds = ObjectifyService.ofy()
          .load()
          .type(Add.class) // We want only Greetings
          .list();

    if (adds.isEmpty()) {
%>
<p>No add present</p>
<%
    } else {
%>
<p>Adds list</p>
<%
      // Look at all of our greetings
        for (Add add : adds) {
            pageContext.setAttribute("att_title", add.title);
            pageContext.setAttribute("att_price", add.price);
            pageContext.setAttribute("att_date", add.date);
%>
<p><b>Title : ${fn:escapeXml(att_title)}</b>
<b>Price : ${fn:escapeXml(att_price)}</b>
<b>Date : ${fn:escapeXml(att_date)}</b>
</p>
<%
        }
    }
%>
	
</body>
</html>
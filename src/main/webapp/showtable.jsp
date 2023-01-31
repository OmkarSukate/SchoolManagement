<%@page import="schoolmanagement.Student070"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% EntityManagerFactory emf=Persistence.createEntityManagerFactory("Omkar");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Query q=em.createQuery("select a from Student070 a ");
		List<Student070> l=q.getResultList();
		
	 %>
	 <table cellpadding="10px" border="1" align="center">
	 <th>id</th>
	 	 <th>name</th>
	 	 <th>Stream</th>
	 	 <th>fees</th>
	 <tr align="center">
		 
	 <%for(Student070 s:l){
		 %>
		<td><%= s.getId() %></td> 
		<td><%=s.getName() %></td>
		<td><%=s.getStream() %></td>
		<td><%=s.getFees() %></td>
		 </tr>
	 <%} %>
	 </table><br><br>
	 <center>
	 <a href="http://localhost:8080/schoolmanagement/addstudent.html">Add Student</a><br><br>
	 <a href="http://localhost:8080/schoolmanagement/removestdudent.html">Remove Student</a><br><br>
     <a href="http://localhost:8080/schoolmanagement/updatestudent.html">update Student</a><br><br>
	 <a href="http://localhost:1006/schoolmanagement/login.html">Main Menu</a>
	 
	 </center>
</body>
</html>
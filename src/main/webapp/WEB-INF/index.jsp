<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Expensess</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
    <!-- change to match your file/naming structure -->
  </head>
  <body>
    <h1>Travel Expenses</h1>
    <form:form  action="/expenses" method="post" modelAttribute="theexpense">
        <p>
            <form:label path="expense">Expenses Name</form:label>
            <form:errors path="expense"/>
            <form:input path="expense"/>
        </p>
        <p>
            <form:label path="vendor">Vendor</form:label>
            <form:errors path="vendor"/>
            <form:textarea path="vendor"/>
        </p>
        <p>
          <form:label path="amount">Amount</form:label>
          <form:errors path="amount"/>     
          <form:input type="number" path="amount"/>
        </p>    
        <p>
          <form:label path="description">Description</form:label>
          <form:errors path="description"/>
          <form:input type="textarea" path="description"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form> 
    <table>
      <thead>
        <tr>
          <th>Expenses Name</th>
          <th>Vendor</th>
          <th>Amount</th>
          <th>~Edit</th>
          <th>Delete</th>
        </tr>
      </thead>
      <tbody>
        <!--varibale name inside of items is grabing it from controller in model.AddAtrribute("the first var i passed it")-->
        <c:forEach var="e" items="${expenses}">
        <tr>
          <td><a href="/expenses/${e.id}"><c:out value="${e.expense}"></c:out></a></td>
          <td><c:out value="${e.vendor}"></c:out></td>
          <td><c:out value="${e.amount}"></c:out></td>
          <td><a href="/expenses/edit/${e.id}">Edit</a></td>
          <td><form action="/expenses/delete/${e.id}" method="post">
            <input type="hidden" name="_method" value="delete">
            <input type="submit" value="Delete">    
          </form>  
        </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

  </body>
</html>
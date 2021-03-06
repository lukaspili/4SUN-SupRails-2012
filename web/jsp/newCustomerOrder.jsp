<%-- 
    Document   : newCustomerOrder
    Created on : 1 févr. 2012, 23:31:44
    Author     : lukas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New order</title>
    </head>
    <body>
        <h1>Order for <c:out value="${trip.departureStation.name}"/> - <c:out value="${trip.arrivalStation.name}"/></h1>
        
        <form method="POST">
            
            <input type="hidden" name="trip_id" value="${trip.id}" />
            
            <p>
                <label for="firstname">Firstname :</label>
                <input type="text" name="firstname" id="firstname" />
            </p>
            
            <p>
                <label for="lastname">Lastname :</label>
                <input type="text" name="lastname" id="lastname" />
            </p>
            
            <p>
                <label for="email">Email :</label>
                <input type="text" name="email" id="email" />
            </p>
            
            <p>
                <input type="submit" value="Order" />
            </p>
        </form>
    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Q3</title>
</head>
<body>

<h2>Q3 - Multiplication</h2>

<!-- Show error message -->
<% if(request.getAttribute("message") != null) { %>
    <p style="color:red;"><%= request.getAttribute("message") %></p>
<% } %>

<form action="/q3" method="post">

    <label>First number:</label><br>
    <input type="text" name="number1"><br><br>

    <label>Second number:</label><br>
    <input type="text" name="number2"><br><br>

    <label>Multiply:</label><br>
    <input type="text" name="result"><br><br>

    <input type="submit" value="Submit">

</form>

</body>
</html>
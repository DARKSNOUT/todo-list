<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <title>List Todos Page</title>
</head>
<body>
    <div class="container">
        <h1>ADD Todos</h1>
      	<form:form method="post" modelAttribute="todo">
				Description: <form:input type="text" path="description" required="required"/>
				<form:errors path="description" cssClass="text-warning"/>
				<form:input type="hidden" path="done"/>
				<form:input type="hidden" path="id"/>
				<input type="submit" class="btn btn-success"/>
		</form:form>
    </div>
    
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
</body>
</html>
	
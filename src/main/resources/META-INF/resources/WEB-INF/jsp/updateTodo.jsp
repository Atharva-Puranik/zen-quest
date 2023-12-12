<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
    <title>Update Todo</title>
    <link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet" >

  </head>
  <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <div class="container-fluid">
            <a class="navbar-brand" href="list-todos">ZenQuest</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="add-todo">Add Todo</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/logout">Logout</a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
        <div class="container">
        <h1>Update Todo</h1>
        <hr>
    <form:form method = "POST" modelAttribute="todo">
      <div>
        <label for="description"><b>Description</b></label>
        <fieldset class="mb-3">
        	<form:label path="description">Description</form:label>
        	<form:input type="text" path="description" required="required"/>
        	<form:errors path="description" cssClass="text-warning"/>
        </fieldset>
        <fieldset class="mb-3">
        	<form:label path="targetDate">Target Date</form:label>
        	<form:input type="text" path="targetDate" required="required"/>
        	<form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>
        <form:input type="hidden" path="id" required="required"/><br>
        <form:input type="hidden" path="done" required="required"/><br>
        <form:button type="submit" class="btn btn-success">Add</form:button>
      </div>
    </form:form>
    </div>
    <script src="webjars/jquery/3.7.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript">
    	$('#targetDate').datepicker({
    	    format: 'yyyy-mm-dd'
    	});
    </script>
  </body>
</html>
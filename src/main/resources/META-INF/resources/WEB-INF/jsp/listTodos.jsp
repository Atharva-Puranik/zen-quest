<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Your Todos</title>
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
        <h3>Your Todos Are:</h3>
        <hr>
        <table class="table">
        <thead>
        <tr>
            <th>description</th>
            <th>date(yyyy-mm-dd)</th>
            <th>done</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.done}</td>
                    <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
                    <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
                </tr>
            </c:forEach>
        </tbody>
        </table>
        <a href="add-todo" class="btn btn-success">Add New Todo</a>
        </div>
    <script src="webjars/jquery/3.7.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/5.3.2/js/bootstrap.min.js"></script>
  </body>
</html>
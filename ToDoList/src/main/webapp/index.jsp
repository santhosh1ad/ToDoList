<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
    <h1>Todo List</h1>
    
    <form method="post" action="/api/todos">
        <input type="text" name="title" placeholder="Todo Title" required />
        <button type="submit">Add Todo</button>
    </form>
    
    <table>
        <tr>
            <th>Title</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.title}</td>
                <td>
                    <a href="/api/todos/${todo.id}" onclick="return confirm('Are you sure you want to delete this todo?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

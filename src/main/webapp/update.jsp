<%@ page language="java" import="com.model.*"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee - Employee Management</title>

<style>

    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: Arial, sans-serif;
    }

    body {
        background: linear-gradient(135deg, #e3f2fd, #f5f7fa);
        min-height: 100vh;
    }

    /* Header */
    header {
        background: linear-gradient(90deg, #1565c0, #42a5f5);
        color: white;
        padding: 25px;
        text-align: center;
        box-shadow: 0 3px 10px rgba(0,0,0,0.15);
    }

    header h1 {
        font-size: 30px;
        letter-spacing: 1px;
    }

    /* Update Card */
    .form-container {
        width: 420px;
        margin: 50px auto;
        background: white;
        padding: 35px;
        border-radius: 15px;
        box-shadow: 0 8px 25px rgba(0,0,0,0.15);
    }

    .form-container h2 {
        text-align: center;
        color: #1565c0;
        margin-bottom: 30px;
    }

    /* Form Groups */
    .form-group {
        margin-bottom: 18px;
    }

    .form-group label {
        display: block;
        margin-bottom: 7px;
        color: #333;
        font-weight: bold;
    }

    .form-group input[type="text"],
    .form-group input[type="email"],
    .form-group input[type="number"] {
        width: 100%;
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 7px;
        outline: none;
        font-size: 15px;
        transition: 0.3s;
    }

    .form-group input:focus {
        border-color: #1565c0;
        box-shadow: 0 0 5px rgba(21,101,192,0.3);
    }

    /* Status */
    .status-group {
        margin-top: 5px;
        margin-bottom: 20px;
    }

    .status-title {
        display: block;
        margin-bottom: 10px;
        color: #333;
        font-weight: bold;
    }

    .status-option {
        display: inline-flex;
        align-items: center;
        margin-right: 20px;
        cursor: pointer;
        font-weight: normal;
    }

    .status-option input {
        margin-right: 7px;
        accent-color: #1565c0;
    }

    /* Update Button */
    .update-btn {
        width: 100%;
        padding: 12px;
        background: #1565c0;
        color: white;
        border: none;
        border-radius: 7px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: 0.3s;
    }

    .update-btn:hover {
        background: #0d47a1;
        transform: translateY(-1px);
    }

    /* Back Link */
    .back-link {
        display: block;
        text-align: center;
        margin-top: 20px;
        color: #1565c0;
        text-decoration: none;
        font-weight: bold;
    }

    .back-link:hover {
        text-decoration: underline;
    }

    /* Responsive */
    @media (max-width: 500px) {
        .form-container {
            width: 90%;
            margin-top: 35px;
        }
    }

</style>

</head>

<body>

<header>
    <h1>Employee Management System</h1>
</header>

<%
    Employees emps = (Employees) request.getAttribute("emp");
%>

<div class="form-container">

    <h2>Update Employee</h2>

    <form action="update" method="post">

        <input type="hidden"
               name="employee_id"
               value="<%= emps.getEmployee_id() %>">

        <div class="form-group">
            <label for="employee_name">Employee Name</label>
            <input
                id="employee_name"
                type="text"
                name="employee_name"
                placeholder="Enter Employee Name"
                value="<%= emps.getEmployee_name() %>"
                required>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input
                id="email"
                type="email"
                name="email"
                placeholder="Enter Email"
                value="<%= emps.getEmail() %>"
                required>
        </div>

        <div class="form-group">
            <label for="phone_number">Phone Number</label>
            <input
                id="phone_number"
                type="text"
                name="phone_number"
                placeholder="Enter Phone Number"
                value="<%= emps.getPhone_number() %>"
                required>
        </div>

        <div class="form-group">
            <label for="salary">Salary</label>
            <input
                id="salary"
                type="number"
                name="salary"
                placeholder="Enter Salary"
                value="<%= emps.getSalary() %>"
                required>
        </div>

        <div class="status-group">

            <span class="status-title">Employee Status</span>

            <label class="status-option" for="active">
                <input
                    type="radio"
                    id="active"
                    name="isActive"
                    value="true"
                    <%= emps.isActive() ? "checked" : "" %>>
                Active
            </label>

            <label class="status-option" for="inactive">
                <input
                    type="radio"
                    id="inactive"
                    name="isActive"
                    value="false"
                    <%= !emps.isActive() ? "checked" : "" %>>
                Inactive
            </label>

        </div>

        <button type="submit" class="update-btn">
            Update Employee
        </button>

    </form>

    <a href="employees" class="back-link">
        ← Back to Employees
    </a>

</div>

</body>
</html>
<%@ page language="java" import="java.util.*,com.model.*"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management</title>

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

    /* Main container */
    .container {
        width: 95%;
        max-width: 1200px;
        margin: 40px auto;
        background: white;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 8px 25px rgba(0,0,0,0.12);
    }

    /* Top section */
    .top-section {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 25px;
    }

    .top-section h2 {
        color: #1565c0;
    }

    .add-btn {
        background: #1565c0;
        color: white;
        text-decoration: none;
        padding: 11px 18px;
        border-radius: 7px;
        font-weight: bold;
        transition: 0.3s;
    }

    .add-btn:hover {
        background: #0d47a1;
    }

    /* Table */
    .table-wrapper {
        overflow-x: auto;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
    }

    th {
        background: #1565c0;
        color: white;
        padding: 14px;
        text-align: center;
    }

    td {
        padding: 13px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    tr:hover td {
        background: #f1f7ff;
    }

    /* Status */
    .active {
        color: #198754;
        font-weight: bold;
    }

    .inactive {
        color: #dc3545;
        font-weight: bold;
    }

    /* Actions */
    .update-btn {
        display: inline-block;
        background: #198754;
        color: white;
        padding: 7px 12px;
        border-radius: 5px;
        text-decoration: none;
        margin-bottom: 7px;
        font-size: 14px;
    }

    .delete-btn {
        display: inline-block;
        background: #dc3545;
        color: white;
        padding: 7px 12px;
        border-radius: 5px;
        text-decoration: none;
        font-size: 14px;
    }

    .update-btn:hover {
        background: #146c43;
    }

    .delete-btn:hover {
        background: #b02a37;
    }

    /* Logout */
    .logout-section {
        text-align: right;
        margin-top: 25px;
    }

    .logout-btn {
        display: inline-block;
        background: #333;
        color: white;
        padding: 10px 18px;
        border-radius: 7px;
        text-decoration: none;
        font-weight: bold;
    }

    .logout-btn:hover {
        background: #111;
    }

    /* Mobile */
    @media (max-width: 700px) {

        .container {
            width: 95%;
            padding: 20px;
        }

        .top-section {
            flex-direction: column;
            gap: 15px;
            align-items: flex-start;
        }

        th, td {
            font-size: 13px;
            padding: 9px;
        }
    }

</style>

</head>

<body>

<header>
    <h1>Employee Management System</h1>
</header>

<div class="container">

    <div class="top-section">
        <h2>Employees</h2>

        <a href="addEmployees.html" class="add-btn">
            + Add Employee
        </a>
    </div>

    <div class="table-wrapper">

        <table>

            <tr>
                <th>Employee ID</th>
                <th>Employee Name</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Salary</th>
                <th>Status</th>
                <th>Action</th>
            </tr>

            <%
                List<Employees> employeesList =
                    (List<Employees>) request.getAttribute("empList");
            %>

            <% for (Employees emp : employeesList) { %>

            <tr>

                <td><%= emp.getEmployee_id() %></td>

                <td><%= emp.getEmployee_name() %></td>

                <td><%= emp.getEmail() %></td>

                <td><%= emp.getPhone_number() %></td>

                <td>₹<%= emp.getSalary() %></td>

                <td>
                    <% if (emp.isActive()) { %>
                        <span class="active">Active</span>
                    <% } else { %>
                        <span class="inactive">Inactive</span>
                    <% } %>
                </td>

                <td>

                    <a
                        href="update?employee_id=<%= emp.getEmployee_id() %>"
                        class="update-btn">
                        Update
                    </a>

                    <a
                        href="delete?employee_id=<%= emp.getEmployee_id() %>"
                        class="delete-btn"
                        onclick="return confirm('Are you sure you want to delete this employee?');">
                        Delete
                    </a>

                </td>

            </tr>

            <% } %>

        </table>

    </div>

    <div class="logout-section">

        <a href="logout" class="logout-btn">
            Logout
        </a>

    </div>

</div>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .login-container {
            width: 400px;
            padding: 20px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        .form-control:focus {
            box-shadow: none;
            border-color: #007bff;
        }
		

        body{
            background-image: url("/images/background.jpg");
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }
    </style>

</head>
<body >
<div class="login-container">
    <h3 class="text-center mb-4">Đăng nhập</h3>
    <form action="/checklogin" method="post">
        <div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </div>
        <div class="mb-3">
            <label for="username" class="form-label">Tên đăng nhập</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
        </div>
        <div class="mb-3" style = "margin-bottom:60px">
            <label for="password" class="form-label">Mật khẩu</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required 
style="    margin-bottom: 30px;">
        </div>
		<c:if test="${not empty message}">
						       <div id="success-alert" style="color:red; position:absolute; top: 400px;" >
						           ${message}
						       </div>
						       <script>
						           window.setTimeout(function() {
						               var alert = document.getElementById("success-alert");
						               alert.style.transition = "opacity 1s ease-out";
						               alert.style.opacity = "0";
						               window.setTimeout(function() {
						                   alert.style.display = 'none';
						               }, 500);
						           }, 1000);
						       </script>
		</c:if>
		<c:if test="${not empty message1}">
						       <div id="success-alert1" style="color:green;position:absolute; top: 400px;">
						           ${message1}
						       </div>
						       <script>
						           window.setTimeout(function() {
						               var alert = document.getElementById("success-alert1");
						               alert.style.transition = "opacity 1s ease-out";
						               alert.style.opacity = "0";
						               window.setTimeout(function() {
						                   alert.style.display = 'none';
						               }, 500);
						           }, 1000);
						       </script>
		</c:if>
        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="remember" name="remember">
            <label class="form-check-label" for="remember">Remember me</label>
        </div>
        <div class="d-grid">
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
        </div>
        <div class="mt-3 text-center">
            <a href="/forgot-password" class="text-decoration-none">Quên mật khẩu?</a>
        </div>
    </form>
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

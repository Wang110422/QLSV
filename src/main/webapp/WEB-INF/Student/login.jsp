	<%@ page contentType="text/html;charset=UTF-8" language="java" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	
	<!DOCTYPE html>
	<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Document</title>
	    <style>
	        body{
	            background-color: #3d7cd5;
	        }
	        .input1{
	            width: 250px;
	            height: 35px;
	            border-radius: 20px;
	            margin-bottom: 10px;
	            background-color: #e6e6e6;
	            border: none;
	            padding: 5px;
	            font-size: 15px;
	        }
	        .button1{
	            width: 260px;
	            height: 40px;
	            border-radius: 20px;
	            text-decoration: none;
	            background-color: #2961b1;
	            border: none;
	            margin-top: 20px;
	        }
	        .a1{
	            text-decoration: none;
	            font-size: 13px;
	            font-weight: 1000;
	            color: white;
	        }
	        .formdn{
	            position: relative;
	            width: 230px;
	            text-align: center  ;
	            left: 600px;
	            top :180px;
	        }
	        .id1{
	            font-size: 20px;
	            font-weight: 600;
	            margin-left: 20px;
	        }
	        .cover{
	            width: 1000px;
	            background-color: rgb(255, 255, 255);
	            height: 600px;
	            position: relative;
	            left: 210px;
	            top: 30px;
	            border-radius: 15px;
	            box-shadow: 0 20px 35px rgba(0,0,0,0.1);
	        }
	        .img1{
	            width: 270px;
	            position: absolute;
	            top: 25%;
	            left: 10%;
	        }
	        .text2{
	            position: absolute;
	            top: 90%;
	            left: 80%;
	            font-weight: 600;
	            text-decoration: none;
	        }
	        a{
	            text-decoration: none;
	        }
	    </style>
	</head>
	<body>
		<div class="cover">
		        <img src="/images/my-account.png" alt="" class="img1">
		        <div class="formdn">
		            <p class="id1">Member login</p>
		            <form action="/checklogin" method="post">
						<div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					  	 </div>
		                <input class="input1" type="text" placeholder="Username" name="username" required>
		                <input class="input1" type="password" placeholder="Password" name="password" required>
		                <button class="button1" type="submit">LOGIN</button>
		            </form>
		            <p style="margin-left: 30px;">Forgot <a href="#">Username/Password</a></p>
		            <c:if test="${not empty error}">
		                <p style="color: red;">${error}</p>
		            </c:if>
		        </div>
		        <p class="text2"><a href="">Create new account</a></p>
		    </div>
	</body>
	</html>
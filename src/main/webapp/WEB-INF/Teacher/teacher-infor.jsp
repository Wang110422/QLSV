<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="/css/viewst.css ">
    <title>Document</title>
</head>
<body>
    <header class="header">
        <p class="header-heading">Hệ thống quản lý sinh viên - Sinh Viên</p>
        <div class="header-user">
            <!-- <img th:src="@{/img/avatar.png}" alt="Avatar" class="header-avatar"> -->
            <img src="/images/avatar.png" alt="Avatar" class="header-avatar">
            <p class="header-username">${teacher.name}</p>
        </div>
    </header>
	<div id="menu">
	        <ul>
	            <li>
	                <span id="textmenu">MENU</span>
	                <button id="toggleButton">☰</button>
	            </li>
	            <li>
	                <a href="/teacher/home" class="a-root" >
	                    <i class="fas fa-home"></i>
	                    <span class="menu-item">Trang chủ</span>
	                </a>
	            </li>
	            <li>
	                <a href="/teacher/infor " class="a-root">
	                    <i class="fas fa-user"></i>
	                    <span class="menu-item">Thông tin cá nhân</span>
	                </a>
	            </li>
	            <li>
	                <a href="/teacher/course" class="a-root">
	                    <i class="fas fa-wallet"></i>
	                    <span class="menu-item">Học phần</span>
	                </a>
	            </li>
	            <li>
	                <a href="/teacher/timetable" class="a-root">
	                    <i class="fas fa-tasks"></i>
	                    <span class="menu-item">Thời khóa biểu</span>
	                </a>
	            </li>
	            <li>
	                <a href="/teacher/feedback" class="a-root"> 
	                    <i class="fas fa-cog"></i>
	                    <span class="menu-item">Gửi đánh giá</span>
	                </a>
	            </li>
	            <li>
	                <a href="/teacher/login" style="margin-top: 250px;" class="a-root">
	                    <i class="fas fa-sign-out-alt"></i>
	                    <span class="menu-item">Đăng xuất</span>
	                </a>
	            </li>
	        </ul>
	    </div>
    <div class="content">
        <div class="box">
            <div class="the"><i class="fa-solid fa-user" style="font-size: 200px; position: relative; left: 20px; top: 35px; color: white;"></i></div>
            <table class="the-text">
				<c:if test="${not empty teacher}">
                <tr class="tr-text">
                    <td>Mã giảng viên</td>
                    <td>${teacher.teacherId}</td>
                </tr>
                <tr class="tr-text">
                    <td>Họ và tên</td>
                    <td>${teacher.name}</td>
                </tr>
                <tr class="tr-text">
                    <td>Giới tính</td>
                    <td>${teacher.gender}</td>
                </tr>
                <tr class="tr-text">
                    <td>Ngày sinh: </td>
                    <td>${teacher.birthday}</td>
                </tr>
                <tr class="tr-text">
                    <td>Quê quán</td>
                    <td>${teacher.hometown}</td>
                </tr>
                <tr class="tr-text">
                    <td>Số điện thoại</td>
                    <td>${teacher.phoneNumber}</td>
                </tr>
                <tr class="tr-text">
                    <td>Email</td>
                    <td>${teacher.email}</td>
                </tr>
                <tr class="tr-text">
                    <td>Khoa</td>
                    <td>${teacher.department.departmentId}</td>
                </tr>
				</c:if>
				<c:if test="${not empty error}">
					<tr>
						 <td colspan="2">${error}</td> 
					 </tr> 
				 </c:if>
            </table>
        </div>
		<a href="/teacher/infor/change" class="change" style = "display: block;background-color: red;color: white;font-size: 18px; padding: 12px 16px; border-radius: 4px; margin-top: 32px; width: 164px; position: relative; left: 624px; bottom: -119px;">
		            <i class="change-infor-icon fa-regular fa-pen-to-square"></i>
		            Sửa thông tin
		</a>
    </div>
    <script>
        document.getElementById("toggleButton").addEventListener("click", function() {
        var menu = document.getElementById("menu");
        if (menu.classList.contains("expanded")) {
            menu.classList.remove("expanded");
        } else {
            menu.classList.add("expanded");
        }
    });
    document.getElementById("toggleButton").addEventListener("click", function() {
        var button = document.getElementById('toggleButton');
        var menu = document.getElementById('textmenu');
        
        if (button.style.transform === 'translateX(130px)') {
             button.style.transform = 'translateX(0)'; 
             menu.style.display === 'none';
            } else {
            button.style.transform = 'translateX(130px)';
            menu.style.display === 'block';
        }
    });
    
    </script>
</body>
</html>
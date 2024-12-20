<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="/css/viewst.css  ">
    <title>Document</title>
</head>
<body>
    <header class="header">
        <p class="header-heading">Hệ thống quản lý sinh viên - Sinh Viên</p>
        <div class="header-user">
            <!-- <img th:src="@{/img/avatar.png}" alt="Avatar" class="header-avatar"> -->
            <img src="/images/avatar.png" alt="Avatar" class="header-avatar">
            <p class="header-username">${student.name}</p>
        </div>
    </header>
	<div id="menu">
	        <ul>
	            <li>
	                <span id="textmenu">MENU</span>
	                <button id="toggleButton">☰</button>
	            </li>
	            <li>
	                <a href="/student/home" class="a-root" >
	                    <i class="fas fa-home"></i>
	                    <span class="menu-item">Trang chủ</span>
	                </a>
	            </li>
	            <li>
	                <a href="/student/infor" class="a-root">
	                    <i class="fas fa-user"></i>
	                    <span class="menu-item">Thông tin cá nhân</span>
	                </a>
	            </li>
	            <li>
	                <a href="/student/course" class="a-root">
	                    <i class="fas fa-wallet"></i>
	                    <span class="menu-item">Học phần</span>
	                </a>
	            </li>
	            <li>
	                <a href="/student/timetable" class="a-root">
	                    <i class="fas fa-tasks"></i>
	                    <span class="menu-item">Thời khóa biểu</span>
	                </a>
	            </li>
	            <li>
	                <a href="/student/feedback" class="a-root"> 
	                    <i class="fas fa-cog"></i>
	                    <span class="menu-item">Gửi đánh giá</span>
	                </a>
	            </li>
	            <li>
	                <a href="/login" style="margin-top: 250px;" class="a-root">
	                    <i class="fas fa-sign-out-alt"></i>
	                    <span class="menu-item">Đăng xuất</span>
	                </a>
	            </li>
	        </ul>
	    </div>
    <div class="content" >	
		<c:forEach var="course" items="${courses}">
        <ul class="courses-list">
				 <li class="courses-item">
					 <a href="${pageContext.request.contextPath}/student/course-scores?courseId=${course.courseId}" class="courses-item-link">
						 <div class="course-name">${course.courseName}</div>
						 <div class="course-id-wrap">Mã học phần:<p class="course-id">${course.courseId}</p></div> 
						 <div class="course-credit-wrap">Số tín chỉ:<p class="course-credit">${course.credit}</p></div> 
						 <div class="course-students-wrap">Mã giảng viên:<p class="course-students">${course.teacher.teacherId}</p></div> 
					 </a> 
				 </li> 
        </ul>
		</c:forEach>
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
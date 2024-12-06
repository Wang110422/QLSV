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
	                <a href="/teacher/infor" class="a-root">
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
        <div class="content-heading" style="margin-left: 500px; margin-bottom:10px ;margin-top: 30px; font-size: 20px;">
            <p class="content-heading-name" >${courses.courseName}</p>
            <p> - </p>
            <p class="content-heading-id">${courses.courseId}</p>
        </div>
        <form class="score-management" action = "${pageContext.request.contextPath}/teacher/course-score" method = "post">
				<input type="hidden" name="courseId" value="${courses.courseId}">            
				<table class="score-list">
                <tr>
                    <th>STT</th>
                    <th>Mã sinh viên</th>
                    <th>Tên sinh viên</th>
                    <th>Thường xuyên 1</th>
                    <th>Thường xuyên 2</th>
                    <th>Kết quả thi</th>
                </tr>
				 <c:forEach var="sc1" items="${scores}" varStatus="iterStat"> 
					<tr>
						<td>${iterStat.index + 1}</td> 
						<td>${sc1.student.id}</td>
						<td>${sc1.student.name}</td>
						<td><input type="text" name="score1" value="${sc1.score1}"></td>
						<td><input type="text" name="score2" value="${sc1.score2}"></td>
						<td><input type="text" name="lastscore" value="${sc1.lastscore}"></td> 
					</tr>
				 </c:forEach>
            </table>
			<input class="score-submit" type="submit" value="Cập nhật điểm">
        </form>
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
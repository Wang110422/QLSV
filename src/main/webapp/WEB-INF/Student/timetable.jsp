<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	                <a href="/student/login" style="margin-top: 250px;" class="a-root">
	                    <i class="fas fa-sign-out-alt"></i>
	                    <span class="menu-item">Đăng xuất</span>
	                </a>
	            </li>
	        </ul>
	    </div>
<div class="content">
    <p class="content-heading" style="position: relative; left: 40%;" ><b>Thời khóa biểu</b></p>
            <table class="schedule-list">
                <thead>
                    <tr>
                        <th>Thứ 2</th>
                        <th>Thứ 3</th>
                        <th>Thứ 4</th>
                        <th>Thứ 5</th>
                        <th>Thứ 6</th>
                        <th>Thứ 7</th>
                        <th>Chủ nhật</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
							<div>
								<c:forEach var="s" items="${courses}">
								<c:if test="${s.date == 'Thứ 2'}">
									 <p class="course-name">${s.courseName}</p> 
									 <p class="course-id">${s.courseId}</p> 
									 <p class="course-time">${s.time}</p> 
									 <p class="course-place">${s.room}</p>
									 <p style = "color:blue">------------------------------------------</p>
								 </c:if>
								 </c:forEach>
							 </div>
							 <div></div>
							 <div></div>
                        </td>
						<td>
						<div>
							<c:forEach var="s" items="${courses}">
							<c:if test="${s.date == 'Thứ 3'}">
								<p class="course-name">${s.courseName}</p> 
							    <p class="course-id">${s.courseId}</p> 
								<p class="course-time">${s.time}</p> 
								<p class="course-place">${s.room}</p> 
								<p style = "color:blue">------------------------------------------</p>
							</c:if>
							</c:forEach>
						</div>
						<div></div>
						<div></div>
						 </td>
						 <td>
							<div>
								<c:forEach var="s" items="${courses}">
							 	<c:if test="${s.date == 'Thứ 4'}">
							 		<p class="course-name">${s.courseName}</p> 
							 	    <p class="course-id">${s.courseId}</p> 
							 		<p class="course-time">${s.time}</p> 
							 		<p class="course-place">${s.room}</p> 
									<div styles = "color: blue ">------------------------------------------</div>
							 	</c:if>
								</c:forEach>
							</div>
							<div></div>
							<div></div>
						  </td>
						  <td>
							 <div>
								 <c:forEach var="s" items="${courses}">
							  	 <c:if test="${s.date == 'Thứ 5'}">
								  		<p class="course-name">${s.courseName}</p> 
								  	    <p class="course-id">${s.courseId}</p> 
								  		<p class="course-time">${s.time}</p> 
								  		<p class="course-place">${s.room}</p> 
										<div styles = "color: blue ">------------------------------------------</div>
							  	</c:if>
								</c:forEach>
							</div>
							<div></div>
							<div></div>
						   </td>	
						   <td>
								<div>
									<c:forEach var="s" items="${courses}">
							   		<c:if test="${s.date == 'Thứ 6'}">
								   		<p class="course-name">${s.courseName}</p> 
								   	    <p class="course-id">${s.courseId}</p> 
								   		<p class="course-time">${s.time}</p> 
								   		<p class="course-place">${s.room}</p> 
										<div styles = "color: blue ">------------------------------------------</div>
							   		</c:if>
									</c:forEach>
								</div>
								<div></div>
								<div></div>
						    </td>	
							<td>
								<div>
									<c:forEach var="s" items="${courses}">
									<c:if test="${s.date == 'Thứ 7'}">
										<p class="course-name">${s.courseName}</p> 
									    <p class="course-id">${s.courseId}</p> 
										<p class="course-time">${s.time}</p> 
										<p class="course-place">${s.room}</p> 
										<p styles = "color:blue">------------------------------------------</p>
									</c:if>
									</c:forEach>
								</div>
								<div></div>
								<div></div>
							 </td>
							 <td>
								<div>
									<c:forEach var="s" items="${courses}">
								 	<c:if test="${s.date	 == 'Chủ nhật'}">
								 		<p class="course-name">${s.courseName}</p> 
								 	    <p class="course-id">${s.courseId}</p> 
								 		<p class="course-time">${s.time}</p> 
								 		<p class="course-place">${s.room}</p> 
										<div styles = "color: blue ">------------------------------------------</div>
								 	</c:if>
									</c:forEach>
								<div>
									<div></div>
									<div></div>
							  </td>							
                    </tr>
                </tbody>
            </table>
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
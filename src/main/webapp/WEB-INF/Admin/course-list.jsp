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
            <p class="header-username">${admin.name}</p>
        </div>
    </header>

	<div id="menu">
	        <ul>
	            <li>
	                <span id="textmenu">MENU</span>
	                <button id="toggleButton">☰</button>
	            </li>
	            <li>
	                <a href="/admin/home" class="a-root" >
	                    <i class="fas fa-home"></i>
	                    <span class="menu-item">Trang chủ</span>
	                </a>
	            </li>
	            <li>
	                <a href="/admin/student-manager" class="a-root">
	                    <i class="fas fa-user"></i>
	                    <span class="menu-item">Quản lý sinh viên</span>
	                </a>
	            </li>
	            <li>
	                <a href="/admin/course-manager" class="a-root">
	                    <i class="fas fa-wallet"></i>
	                    <span class="menu-item">Quản lý giảng viên</span>
	                </a>
	            </li>
	            <li>
	                <a href="/admin/course-manager" class="a-root">
	                    <i class="fas fa-tasks"></i>
	                    <span class="menu-item">Quản lý học phần</span>
	                </a>
	            </li>
	            <li>
	                <a href="/admin/feedback-manager" class="a-root"> 
	                    <i class="fas fa-cog"></i>
	                    <span class="menu-item">Xem đánh giá</span>
	                </a>
	            </li>
	            <li>
	                <a href="/admin/login" style="margin-top: 250px;" class="a-root">
	                    <i class="fas fa-sign-out-alt"></i>	
	                    <span class="menu-item">Đăng xuất</span>
	                </a>
	            </li>
	        </ul>
	    </div>
    <div class="content">
		<div class="content-wrap">
		           <p class="content-heading">Quản lý sinh viên</p>
				   <table class="student-list">
				                   <tr>
				                       <th>STT</th>
				                       <th>Mã học phần</th>
				                       <th>Tên học phần</th>
				                       <th>Số tín chỉ</th>
				                       <th>Ngày học</th>
				                       <th>Phòng học</th>
				                       <th>Ca học</th>
									   <th>Thao tác</th>
				                   </tr>
				                   <c:forEach var="course" items="${courses}" varStatus="iterStat"> 
				                    <tr>
				                        <td>${iterStat.index+1}</td>
				                        <td>${course.courseId}</td>
				                        <td>${course.courseName}</td>
				                        <td>${course.credit}</td>
				                        <td>${course.date}</td>
				                        <td>${course.room}</td>
				                        <td>${course.time}</td>
										<td>
											<form action="${pageContext.request.contextPath}/admin/course-manager" method="post" style="display:inline;">
												<input type="hidden" name="courseId" value="${course.courseId}">
												<button type="submit">Xóa</button>
											</form>
											<form action="${pageContext.request.contextPath}/admin/course-manager/edit-course" style="display:inline;">
												<input type="hidden" name="courseId1" value="${course.courseId}">
												<button type="submit">Sửa</button>
											</form>

										</td>
				                    </tr>
				                   </c:forEach>
				               </table>
							   <form action="/admin/course-manager/add-course" style="display:inline;">
								   	<button type="submit">Thêm</button>
							   </form>
		       </div>
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
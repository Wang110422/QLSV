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
	                <a href="/admin/feedback" class="a-root"> 
	                    <i class="fas fa-cog"></i>
	                    <span class="menu-item">Xem đánh giá</span>
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
    <div class="content">
		<div class="content-wrap">
			<p class="content-heading">Thêm mới học phần</p>
			            <form class="infor-update" name = "course" method="post">
			                <table class="infor-update-table">
			                	<tr>
			                        <td>Mã học phần:</td>
			                        <td><input name="courseId" type="text" value = "${course.courseId}"></td>
									
			                    </tr>
			                    <tr>
			                        <td>Tên học phần:</td>
			                        <td><input name="courseName" type="text" value="${course.courseName}"></td>
			                    </tr>
			                    <tr>
			                        <td>Số tín chỉ:</td>
			                        <td><input type="text" name="credit" value="${course.credit}"></td>
			                    </tr>
			                    <tr>
			                        <td>Ngày học:</td>
			                        <!-- <td><input type="text" name="date" th:value="${course.date}"></td> -->
			                        <td>
			                            <select name="date">
			                                <option value="Thứ 2">Thứ 2</option>
			                                <option value="Thứ 3">Thứ 3</option>
			                                <option value="Thứ 4">Thứ 4</option>
			                                <option value="Thứ 5">Thứ 5</option>
			                                <option value="Thứ 6">Thứ 6</option>
			                                <option value="Thứ 7">Thứ 7</option>
			                                <option value="Chủ nhật">Chủ nhật</option>
			                            </select>
			                        </td>
			                    </tr>
			                    <tr>
			                        <td>Ca học:</td>
			                        <td><input type="text" name="time" value="${course.time}"></td>
			                    </tr>
			                    <tr>
			                        <td>Phòng học:</td>
			                        <td><input type="text" name="room" value="${course.room}"></td>
			                    </tr>
			                    <tr>
			                        <td>Mã giảng viên:</td>
			                        <td><input type="text" name="teacher" value="${course.teacher.teacherId}"></td>
			                    </tr>
			                </table>
			                <div class="infor-update-btn">
			                    <input class="btn-reset" type="button" value="Làm mới" onclick="reset()">
			                    <input class="btn-submit" type="submit" value="Thêm học phần">
			                </div>
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
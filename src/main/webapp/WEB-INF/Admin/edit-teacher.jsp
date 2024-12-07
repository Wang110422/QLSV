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
	                <a href="/admin/teacher-manager" class="a-root">
	                    <i class="fas fa-user"></i>
	                    <span class="menu-item">Quản lý sinh viên</span>
	                </a>
	            </li>
	            <li>
	                <a href="/admin/teacher-manager" class="a-root">
	                    <i class="fas fa-wallet"></i>
	                    <span class="menu-item">Quản lý giảng viên</span>
	                </a>
	            </li>
	            <li>
	                <a href="/admin/teacher-manager" class="a-root">
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
	                <a href="/admin/login" style="margin-top: 250px;" class="a-root">
	                    <i class="fas fa-sign-out-alt"></i>	
	                    <span class="menu-item">Đăng xuất</span>
	                </a>
	            </li>
	        </ul>
	    </div>
    <div class="content">
		<div class="content-wrap">
			<p class="content-heading">Thêm mới học phần</p>
			            <form class="infor-update" name = "teacher" method="post">
			                <table class="infor-update-table">
			                	<tr>
			                        <td>Mã giảng viên:</td>
			                        <td>${teacherId1}</td>
			                    </tr>
			                    <tr>
			                        <td>Họ và tên:</td>
			                        <td><input name="name" type="text" value="${teacher.name}"></td>
			                    </tr>
								<tr>
								    <td>Giới tính:</td>
								    <td>
										<select name="gender">
											<option value="Nam">Nam</option>
											<option value="Nữ">Nữ</option>
										</select>
									</td>
								</tr>
								<tr>
								    <td>Ngày sinh:</td>
								    <td><input type="text" name="birthday" value="${teacher.birthday}"></td>
								</tr>
								<tr>
								    <td>Quê quán:</td>
								    <td><input type="text" name="hometown" value="${teacher.hometown}"></td>
								</tr>
								<tr>
								    <td>Số điện thoại:</td>
								    <td><input type="text" name="phoneNumber" value="${teacher.phoneNumber}"></td>
								</tr>
								<tr>
								    <td>Email:</td>
								    <td><input type="text" name="email" value="${teacher.email}"></td>
								</tr>
								<tr>
								    <td>Mật khẩu:</td>
								    <td><input type="text" name="password" value="${teacher.password}"></td>
								</tr>
								<tr>
								    <td>Phân quyền:</td>
								    <td><input type="text" name="role" value="${teacher.role}"></td>
								</tr>
								<tr>
								    <td>Mã khoa:</td>
								    <td><input type="text" name="departmentId" value = "${teacher.department.departmentId}"></td>
								</tr>
			                    
			                </table>
			                <div class="infor-update-btn">
			                    <input class="btn-reset" type="button" value="Làm mới" onclick="reset()">
			                    <input class="btn-submit" type="submit" value="Sửa sinh viên">
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
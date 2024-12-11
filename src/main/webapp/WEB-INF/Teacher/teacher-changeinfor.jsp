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
	<style>
		
		.infor-update {
			    margin-bottom: 20px;
			}

			.infor-update-table {
			    font-size: 20px;
			    background-color: rgba(0, 0, 0, 0.05);
			    box-shadow: 1px 2px 4px 1px rgba(0, 0, 0, 0.2);
			    border-radius: 5px;
			    padding: 10px;
			    position: relative;
			    left: 370px;
			}

			.infor-update th,
			.infor-update td {
			    padding: 10px;
			}

			.infor-update input,
			.infor-update select {
			    font-size: 20px;
			    padding: 8px;
			    border-radius: 4px;
			    border: 1px solid var(--border-color);
			}

			.infor-update-btn {
			    display: flex;
			    align-items: center;
			    justify-content: center;
			    position: relative;
			    bottom: -20px;
				
			    margin-left: 60px;
			}

			.btn-reset {
			    color: white;
			    background-color: rgb(232, 163, 26);
			    border: none !important;
			    padding: 8px 12px !important;
			    margin-right: 40px;
			}

			.btn-reset:hover {
			    background-color: rgb(247, 227, 73);
			    border-radius: 8px;
			}

			.btn-submit {
			    color: white;
			    background-color: rgb(44, 238, 44);
			    border: none !important;
			    padding: 8px 12px !important;
			}

			.btn-submit:hover {
			    background-color: rgb(72, 244, 72);
			    border-radius: 8px;
			}
	</style>
		
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
                    <span class="menu-item">Hỗ trợ</span>
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
        <p class="content-heading" style="font-weight: 600; position: relative; left: 570px; margin-bottom: 10px; font-size: 25px;">Cập nhật thông tin</p>
        <form class="infor-update" method="post" action = "/teacher/infor/change">
                <table class="infor-update-table">
                    <tr>
                        <td>Họ và tên:</td>
                        <td>${teacher.name}</td>
                        <td><input name = "name" type="text" value="${teacher.name}"></td>
                    </tr>
                    <tr>
						 <td>Giới tính:</td>
						 <td>${teacher.gender}</td> 
						 <td> 
							<select name="gender"> 
								<option value="Nam" <c:if test="${teacher.gender == 'Nam'}">selected</c:if>>Nam</option> 
								<option value="Nữ" <c:if test="${teacher.gender == 'Nữ'}">selected</c:if>>Nữ</option> 
							</select> 
						</td> 
					</tr>
                    <tr> 
						<td>Ngày sinh:</td> 
						<td>${teacher.birthday}</td>
						<td><input type="date" name="birthday" value="${teacher.birthday}"></td> 
					</tr>
                    <tr> 
						<td>Quê quán:</td> 
						<td>${teacher.hometown}</td> 
						<td><input type="text" name="hometown" value="${teacher.hometown}"></td> 
					</tr>
                    <tr> 
						<td>Số điện thoại:</td> 
						<td>${teacher.phoneNumber}</td> 
						<td><input type="text" name="phoneNumber" value="${teacher.phoneNumber}"></td> 
					</tr>
					<tr> 
						<td>Email:</td> 
						<td>${teacher.email}</td> 
						<td><input type="text" name="email" value="${teacher.email}"></td> 
					</tr>
                    <tr> 
						<td>Mật khẩu:</td> 
						<td>${teacher.password}</td> 
						<td><input type="text" name="password" value="${teacher.password}"></td> 
					</tr>
                    <input hidden type="text" name="role" value="${teacher.role}">
                    <input hidden type="text" name="departmentId" value="${teacher.department.departmentId}">
					<input hidden type="text" name="teacherId" value="${teacher.teacherId}">


                </table>
                <div class="infor-update-btn">
                    <input class="btn-reset" type="button" value="Làm mới" onclick="reset()">
                    <input class="btn-submit" type="submit" value="Cập nhật">
                </div>
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
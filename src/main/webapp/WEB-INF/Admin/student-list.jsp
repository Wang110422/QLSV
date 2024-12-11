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
	                <a href="/admin/teacher-manager" class="a-root">
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
	                <a href="/login" style="margin-top: 250px;" class="a-root">
	                    <i class="fas fa-sign-out-alt"></i>	
	                    <span class="menu-item">Đăng xuất</span>
	                </a>
	            </li>
	        </ul>
	    </div>
    <div class="content">
		<div class="content-wrap">
		           <p class="content-heading">Quản lý sinh viên</p>
				   <form action="/admin/student-manager" method="get" style="margin-bottom: 5px;">
					<select id="class" name="classes">
						<option value="">--Chọn Lớp--</option>
						<option value="all">All</option>
						<c:forEach var="lopId" items="${lop}">
							<option value="${lopId}">${lopId}</option>
						</c:forEach>
					</select>
						<button type="submit">Lọc</button>
					</form>
		           <table class="student-list">
		               <tr>
		                   <th>STT</th>
		                   <th>Mã sinh viên</th>
		                   <th>Họ và tên</th>
		                   <th>Giới tính</th>
		                   <th>Ngày sinh</th>
		                   <th>Quê quán</th>
		                   <th>Số điện thoại</th>
		                   <th>Email</th>
		                   <th>Mật khẩu</th>
		                   <th>Phân quyền</th>
		                   <th>Mã lớp</th>
		                   <th>Mã khoa</th>
						   <th>Thao tác</th>
		               </tr>
					   <c:forEach var="student" items="${students}" varStatus="iterStat"> 
						<tr>
						    <td>${iterStat.index+1}</td>
						    <td>${student.id}</td>
						    <td>${student.name}</td>
						    <td>${student.gender}</td>
						    <td>${student.birthday}</td>
						    <td>${student.hometown}</td>
						    <td>${student.phonenumber}</td>
						    <td>${student.email}</td>
						    <td>${student.password}</td>
						    <td>${student.roles}</td>
						    <td>${student.lop.classId}</td>
						    <td>${student.department.departmentId}</td>
							<td>
								<form action="${pageContext.request.contextPath}/admin/student-manager" method="post" style="display:inline;">
									<input type="hidden" name="studentId" value="${student.id}">
									<button type="submit">Xóa</button>
								</form>
								<form action="${pageContext.request.contextPath}/admin/student-manager/edit-student" style="display:inline;">
									<input type="hidden" name="studentId1" value="${student.id}">
									<button type="submit">Sửa</button>
								</form>
							</td>
						</tr>
					   </c:forEach>
		           </table>
				   <form action="/admin/student-manager/add-student" style="display:inline;">
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
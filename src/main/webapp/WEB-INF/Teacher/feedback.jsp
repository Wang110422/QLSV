<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

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
                <a href="/teacher/login" style="margin-top: 250px;" class="a-root">
                    <i class="fas fa-sign-out-alt"></i>
                    <span class="menu-item">Đăng xuất</span>
                </a>
            </li>
        </ul>
    </div>
    <div class="content">
        <div class="content-wrap">
            <form action="${pageContext.request.contextPath}/teacher/feedback" method="post">
                <p class="content-heading">Hãy để lại cảm nhận của bạn khi sử dụng hệ thống nhé! Đó là những đóng góp quan trọng giúp chúng tôi cải thiện hệ thống!</p>
                <textarea name="content" placeholder="Nhập nội dung ở đây..." value="${feedBack.content}"></textarea>
                <input class="feedback-submit" type="submit" value="Gửi đánh giá" >
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
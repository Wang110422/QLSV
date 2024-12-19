
Chèn dữ liệu vào csdl qlsv1

USE qlsv1;




INSERT INTO giangvien(maGV, hoVaTen, gioiTinh, ngaySinh, queQuan, soDienThoai, email, matKhau, phanQuyen, maKhoa)
VALUES
('GV001', N'Nguyễn Văn Mạnh', N'Nam', '1969/6/7', N'Hà Nội', '0123456789', 'nvm0706@gmail.com', 'GV@123', 'GV', 'K001'),
('GV002', N'Nguyễn Thi Nga', N'Nữ', '1978/4/29', N'Hải Phòng', '0954378945', 'ntn2904@gmail.com', 'GV@123', 'GV', 'K001'),
('GV003', N'Nguyễn Anh Tuấn', N'Nam', '1988/6/7', N'Hà Tĩnh', '0647824615', 'nat0706@gmail.com', 'GV@123', 'GV', 'K001'),
('GV004', N'Phan Thị Lan', N'Nữ', '1980-12-15', N'Quảng Ninh', '0987654321', 'ptl1512@gmail.com', 'GV@123', 'GV', 'K008'),
('GV005', N'Nguyễn Quang Huy', N'Nam', '1975-03-21', N'Vĩnh Phúc', '0912345678', 'nqh2103@gmail.com', 'GV@123', 'GV', 'K008'),
('GV006', N'Vũ Thị Mai', N'Nữ', '1985-08-10', N'Hà Nội', '0908765432', 'vtm1008@gmail.com', 'GV@123', 'GV', 'K008'),
('GV007', N'Trần Quốc Cường', N'Nam', '1992-11-11', N'Bắc Giang', '0976543210', 'tqc1111@gmail.com', 'GV@123', 'GV', 'K009'),
('GV008', N'Lê Minh Tuấn', N'Nam', '1987-02-20', N'Hải Dương', '0936123456', 'lmt0202@gmail.com', 'GV@123', 'GV', 'K009'),
('GV009', N'Phan Thị Bích', N'Nữ', '1990-05-12', N'Thái Nguyên', '0912345555', 'ptb1205@gmail.com', 'GV@123', 'GV', 'K009'),
('GV010', N'Nguyễn Văn Hoàng', N'Nam', '1984-07-30', N'Thái Bình', '0965478291', 'nvh3007@gmail.com', 'GV@123', 'GV', 'K010'),
('GV011', N'Nguyễn Minh Tuấn', N'Nam', '1980-05-20', N'Hà Nội', '0912346300', 'nguyenminhtuan@gmail.com', 'matkhau001', 'GV', 'K010'),
('GV012', N'Phan Thị Lan', N'Nữ', '1985-09-25', N'Bắc Ninh', '0912346301', 'phanthilan@gmail.com', 'matkhau002', 'GV', 'K010'),
('GV013', N'Vũ Quang Hieu', N'Nam', '1990-03-15', N'Thái Nguyên', '0912346302', 'vuquanghieu@gmail.com', 'matkhau003', 'GV', 'K010'),
('GV014', N'Nguyễn Thị Lan', N'Nữ', '1982-06-10', N'Hà Nội', '0912346303', 'nguyenthilan@gmail.com', 'matkhau004', 'GV', 'K018'),
('GV015', N'Le Quang Huy', N'Nam', '1987-12-20', N'Bắc Giang', '0912346304', 'lequanghuy@gmail.com', 'matkhau005', 'GV', 'K018'),
('GV016', N'Vũ Minh Hải', N'Nam', '1992-08-05', N'Thái Nguyên', '0912346305', 'vuminhai@gmail.com', 'matkhau006', 'GV', 'K018'),
('GV017', N'Nguyễn Thị Mai', N'Nữ', '1983-07-12', N'Hà Nội', '0912346306', 'nguyenthimai@gmail.com', 'matkhau007', 'GV', 'K019'),
('GV018', N'Phan Quang Hieu', N'Nam', '1985-04-25', N'Bắc Giang', '0912346307', 'phanquanghieu@gmail.com', 'matkhau008', 'GV', 'K019'),
('GV019', N'Vũ Minh Tâm', N'Nam', '1990-11-17', N'Thái Nguyên', '0912346308', 'vuminhtam@gmail.com', 'matkhau009', 'GV', 'K019');


INSERT INTO hocphan(mahp, tenhp, sotc, ngayhoc, cahoc, phonghoc, magv)
VALUES
('HP001', N'Mạng máy tính', 3, 'Thứ 2', '1, 2, 3', '505-A9', 'GV001'),
('HP002', N'An ninh mạng', 3, 'Thứ 2', '4, 5, 6', '502-A9', 'GV002'),
('HP003', N'Thiết kế Web', 3, 'Thứ 3', '7, 8, 9', '402-A9', 'GV003'),
('HP004', N'Thực tập cơ sở nghành', 3, 'Thứ 4', '1, 2, 3', '306-A9', 'GV001'),
('HP005', N'Hệ thống cơ sở dữ liệu', 4, 'Thứ 5', '1, 2, 3', '304-A9', 'GV002'),
('HP006', N'Phân tích thiết kế phần mềm', 3, 'Thứ 6', '7, 8, 9', '208-A9', 'GV003'),
('HP007', N'Kinh tế vĩ mô', 3, 'Thứ 2', '1, 2, 3', '508-A9', 'GV004'),
('HP008', N'Kinh tế chính trị Mác Lênin', 3, 'Thứ 4', '2, 3, 4', '509-A9', 'GV005'),
('HP009', N'Tài chính doanh nghiệp', 3, 'Thứ 3', '3, 4, 5', '510-A9', 'GV006'),
('HP010', N'Lý thuyết tiền tệ', 3, 'Thứ 6', '1, 2, 3', '511-A9', 'GV004'),
('HP011', N'Quản trị chiến lược', 3, 'Thứ 2', '1, 2, 3', '512-A9', 'GV007'),
('HP012', N'Quản trị nguồn nhân lực', 3, 'Thứ 3', '3, 4, 5', '513-A9', 'GV008'),
('HP013', N'Quản trị tài chính', 3, 'Thứ 4', '1, 2, 3', '514-A9', 'GV009'),
('HP014', N'Marketing căn bản', 3, 'Thứ 5', '2, 3, 4', '515-A9', 'GV007'),
('HP015', N'Hành vi tổ chức', 3, 'Thứ 6', '1, 2, 3', '516-A9', 'GV008'),
('HP016', N'Quản trị dự án', 3, 'Thứ 7', '3, 4, 5', '517-A7', 'GV009'),
('HP017', N'Quản lý dịch vụ du lịch', 3, 'Thứ 2', '2, 3, 4', '518-A1', 'GV010'),
('HP018', N'Lữ hành và hướng dẫn du lịch', 3, 'Thứ 3', '1, 2, 3', '519-A9', 'GV011'),
('HP019', N'Văn hóa du lịch', 3, 'Thứ 4', '3, 4, 5', '520-A7', 'GV012'),
('HP020', N'Marketing du lịch', 3, 'Thứ 5', '2, 3, 4', '521-A9', 'GV013'),
('HP021', N'Ngữ âm học', 3, 'Thứ 2', '1, 2, 3', '502-A9', 'GV014'),
('HP022', N'Văn học Anh - Mỹ', 3, 'Thứ 3', '2, 3, 4', '402-A7', 'GV015'),
('HP023', N'Biên phiên dịch cơ bản', 3, 'Thứ 4', '3, 4, 5', '502-A8', 'GV016'),
('HP024', N'Giao tiếp liên văn hóa', 3, 'Thứ 5', '1, 2, 3', '302-A7', 'GV014'),
('HP025', N'Khoa học dinh dưỡng', 3, 'Thứ 2', '1, 2, 3', '510-A8', 'GV017'),
('HP026', N'Công nghệ chế biến sữa', 3, 'Thứ 3', '2, 3, 4', '503-A7', 'GV018'),
('HP027', N'Công nghệ bảo quản thực phẩm', 3, 'Thứ 4', '3, 4, 5', '503-A7', 'GV019'),
('HP028', N'Vi sinh thực phẩm', 3, 'Thứ 7', '1, 2, 3', '509-A9', 'GV017'),
('HP029', N'Hóa học thực phẩm', 3, 'Thứ 6', '2, 3, 4', '309-A7', 'GV019');

INSERT INTO diemhocphan(maHP, maSV, diem1, diem2, diemThi)
VALUES
('HP001', 'SV389', 8, 9, 6.5),
('HP001', 'SV390', 7, 9, 9.5),
('HP001', 'SV391', 8, 9, 6.5),
('HP002', 'SV389', 7.5, 7.5, 7.0),
('HP002', 'SV390', 6, 7, 6.5),
('HP002', 'SV391', 9, 9.5, 9.0),
('HP003', 'SV389', 7, 6.5, 7.0),
('HP003', 'SV390', 8.5, 9, 8.0),
('HP003', 'SV391', 7.5, 8, 7.5),
('HP021', 'SV677',7.5, 8, 7.5),
('HP022', 'SV677',7.5, 9, 7.5),
('HP023', 'SV677',7.5, 8, 8.5);


INSERT INTO thoikhoabieu(maSV, maHP)
VALUES
('SV389', 'HP001'),
('SV389', 'HP002'),
('SV389', 'HP003'),
('SV390', 'HP001'),
('SV390', 'HP003'),
('SV677', 'HP021'),
('SV677', 'HP022'),
('SV677', 'HP023');


INSERT INTO DanhGia(noiDung)
VALUES(N'Hệ thống bị lag');

insert into quantri
values('QT001','admin','Admin@123','QT');

INSERT INTO khoa(makhoa, tenkhoa)
VALUES
('K001', N'Công Nghệ Thông Tin'),
('K008', N'Kinh Tế'),
('K009', N'Quản Trị Kinh Doanh'),
('K010', N'Du Lịch'),
('K018', N'Ngôn Ngữ Anh'),
('K019', N'Công Nghệ Thực Phẩm');

INSERT INTO lop(malop, tenlop, makhoa)
VALUES
('CNTT01', N'Lớp Công Nghệ Thông Tin 1', 'K001'),
('CNTT03', N'Lớp Công Nghệ Thông Tin 3', 'K001'),
('CNTT04', N'Lớp Công Nghệ Thông Tin 4', 'K001'),

-- Classes for K008 - Kinh Tế
('KTE01', N'Lớp Kinh Tế 1', 'K008'),
('KTE02', N'Lớp Kinh Tế 2', 'K008'),
('KTE03', N'Lớp Kinh Tế 3', 'K008'),

-- Classes for K009 - Quản Trị Kinh Doanh
('QTKD01', N'Lớp Quản Trị Kinh Doanh 1', 'K009'),
('QTKD02', N'Lớp Quản Trị Kinh Doanh 2', 'K009'),
('QTKD03', N'Lớp Quản Trị Kinh Doanh 3', 'K009'),

-- Du lịch
('DL01', N'Lớp Du Lịch 1', 'K010'),
('DL02', N'Lớp Du Lịch 2', 'K010'),

-- Classes for K018 - Ngôn Ngữ Anh
('NN01', N'Lớp Ngôn Ngữ Anh 1', 'K018'),
('NN02', N'Lớp Ngôn Ngữ Anh 2', 'K018'),
('NN03', N'Lớp Ngôn Ngữ Anh 3', 'K018'),

-- Classes for K019 - Công Nghệ Thực Phẩm
('CNTP01', N'Lớp Công Nghệ Thực Phẩm 1', 'K019'),
('CNTP02', N'Lớp Công Nghệ Thực Phẩm 2', 'K019'),
('CNTP03', N'Lớp Công Nghệ Thực Phẩm 3', 'K019');



INSERT INTO sinhvien(masv, hovaten, gioitinh, ngaysinh, quequan, sodienthoai, email, matkhau, phanquyen, malop, makhoa)
VALUES
('SV001', N'Nguyễn Văn A', N'Nam', '2002-01-01', N'Hà Nội', '0912345670', 'nguyenvana@gmail.com', 'matkhau1', 'SV', 'DL01', 'K010'),
('SV002', N'Lê Thị B', N'Nữ', '2002-02-02', N'Hồ Chí Minh', '0912345671', 'lethib@gmail.com', 'matkhau2', 'SV', 'DL01', 'K010'),
('SV003', N'Phạm Văn C', N'Nam', '2002-03-03', N'Đà Nẵng', '0912345672', 'phamvanc@gmail.com', 'matkhau3', 'SV', 'DL01', 'K010'),
('SV004', N'Võ Thị D', N'Nữ', '2002-04-04', N'Hải Phòng', '0912345673', 'vothid@gmail.com', 'matkhau4', 'SV', 'DL01', 'K010'),
('SV005', N'Trần Văn E', N'Nam', '2002-05-05', N'Quảng Ninh', '0912345674', 'tranvane@gmail.com', 'matkhau5', 'SV', 'DL01', 'K010'),

('SV051', N'Nguyễn Văn A', N'Nam', '2002-01-01', N'Hà Nội', '0912345720', 'nguyenvana@gmail.com', 'matkhau51', 'SV', 'DL02', 'K010'),
('SV052', N'Lê Thị B', N'Nữ', '2002-02-02', N'Hồ Chí Minh', '0912345721', 'lethib@gmail.com', 'matkhau52', 'SV', 'DL02', 'K010'),
('SV053', N'Phạm Văn C', N'Nam', '2002-03-03', N'Đà Nẵng', '0912345722', 'phamvanc@gmail.com', 'matkhau53', 'SV', 'DL02', 'K010'),
('SV054', N'Võ Thị D', N'Nữ', '2002-04-04', N'Hải Phòng', '0912345723', 'vothid@gmail.com', 'matkhau54', 'SV', 'DL02', 'K010'),
('SV055', N'Nguyễn Văn Z', N'Nam', '2002-05-05', N'Bình Định', '0912345770', 'nguyenvanz@gmail.com', 'matkhau55', 'SV', 'DL02', 'K010'),

('SV387', N'Nguyễn Thị DA', N'Nữ', '2003-01-01', N'Hà Nội', '0912345987', 'nguyenthida@gmail.com', 'matkhau387', 'SV', 'CNTT03', 'K001'),
('SV388', N'Vũ Thị DB', N'Nữ', '2003-02-02', N'Thái Nguyên', '0912345988', 'vuthidb@gmail.com', 'matkhau388', 'SV', 'CNTT03', 'K001'),
('SV389', N'Phan Thị DC', N'Nữ', '2003-03-03', N'Hải Phòng', '0912345989', 'phanthidc@gmail.com', 'matkhau389', 'SV', 'CNTT03', 'K001'),
('SV390', N'Nguyễn Văn DD', N'Nam', '2003-04-04', N'Vĩnh Phúc', '0912345990', 'nguyenvandd@gmail.com', 'matkhau390', 'SV', 'CNTT03', 'K001'),
('SV391', N'Lê Thị DE', N'Nữ', '2003-05-05', N'Bắc Giang', '0912345991', 'lethide@gmail.com', 'matkhau391', 'SV', 'CNTT03', 'K001'),

('SV435', N'Nguyễn Thị FA', N'Nữ', '2003-01-01', N'Hà Nội', '0912346035', 'nguyenthifa@gmail.com', 'matkhau435', 'SV', 'CNTT04', 'K001'),
('SV436', N'Vũ Thị FB', N'Nữ', '2003-02-02', N'Thái Nguyên', '0912346036', 'vuthifb@gmail.com', 'matkhau436', 'SV', 'CNTT04', 'K001'),
('SV437', N'Phan Thị FC', N'Nữ', '2003-03-03', N'Hải Phòng', '0912346037', 'phanthifc@gmail.com', 'matkhau437', 'SV', 'CNTT04', 'K001'),
('SV438', N'Nguyễn Văn FD', N'Nam', '2003-04-04', N'Vĩnh Phúc', '0912346038', 'nguyenvandf@gmail.com', 'matkhau438', 'SV', 'CNTT04', 'K001'),
('SV439', N'Lê Thị FE', N'Nữ', '2003-05-05', N'Bắc Giang', '0912346039', 'lethife@gmail.com', 'matkhau439', 'SV', 'CNTT04', 'K001'),

('SV483', N'Nguyễn Thị GW', N'Nữ', '2003-01-01', N'Hà Nội', '0912346083', 'nguyenthigw@gmail.com', 'matkhau483', 'SV', 'CNTT01', 'K001'),
('SV484', N'Vũ Thị GX', N'Nữ', '2003-02-02', N'Thái Nguyên', '0912346084', 'vuthigx@gmail.com', 'matkhau484', 'SV', 'CNTT01', 'K001'),
('SV485', N'Phan Thị GY', N'Nữ', '2003-03-03', N'Hải Phòng', '0912346085', 'phanthigy@gmail.com', 'matkhau485', 'SV', 'CNTT01', 'K001'),
('SV486', N'Nguyễn Thị GZ', N'Nữ', '2003-04-04', N'Vĩnh Phúc', '0912346086', 'nguyenthigz@gmail.com', 'matkhau486', 'SV', 'CNTT01', 'K001'),
('SV487', N'Lê Thị HA', N'Nữ', '2003-05-05', N'Bắc Giang', '0912346087', 'lethisha@gmail.com', 'matkhau487', 'SV', 'CNTT01', 'K001'),

('SV531', N'Nguyễn Thị JA', N'Nữ', '2003-01-01', N'Hà Nội', '0912346131', 'nguyenthija@gmail.com', 'matkhau531', 'SV', 'QTKD01', 'K009'),
('SV532', N'Vũ Thị JB', N'Nữ', '2003-02-02', N'Thái Nguyên', '0912346132', 'vuthijb@gmail.com', 'matkhau532', 'SV', 'QTKD01', 'K009'),
('SV533', N'Phan Thị JC', N'Nữ', '2003-03-03', N'Hải Phòng', '0912346133', 'phanthijc@gmail.com', 'matkhau533', 'SV', 'QTKD01', 'K009'),
('SV534', N'Nguyễn Thị JD', N'Nữ', '2003-04-04', N'Vĩnh Phúc', '0912346134', 'nguyenthijd@gmail.com', 'matkhau534', 'SV', 'QTKD01', 'K009'),
('SV535', N'Lê Thị JE', N'Nữ', '2003-05-05', N'Bắc Giang', '0912346135', 'lethije@gmail.com', 'matkhau535', 'SV', 'QTKD01', 'K009'),

('SV583', N'Nguyễn Thị LA', N'Nữ', '2003-01-01', N'Bắc Giang', '0912346183', 'nguyenthila@gmail.com', 'matkhau583', 'SV', 'QTKD02', 'K009'),
('SV584', N'Vũ Thị LB', N'Nữ', '2003-02-02', N'Thái Nguyên', '0912346184', 'vuthilb@gmail.com', 'matkhau584', 'SV', 'QTKD02', 'K009'),
('SV585', N'Phan Thị LC', N'Nữ', '2003-03-03', N'Hà Nội', '0912346185', 'phanthilc@gmail.com', 'matkhau585', 'SV', 'QTKD02', 'K009'),
('SV586', N'Nguyễn Thị LD', N'Nữ', '2003-04-04', N'Hải Dương', '0912346186', 'nguyenthild@gmail.com', 'matkhau586', 'SV', 'QTKD02', 'K009'),
('SV587', N'Lê Thị LE', N'Nữ', '2003-05-05', N'Quảng Ninh', '0912346187', 'lethile@gmail.com', 'matkhau587', 'SV', 'QTKD02', 'K009'),

('SV631', N'Nguyễn Thị NA', N'Nữ', '2003-01-01', N'Bắc Giang', '0912346231', 'nguyenthina@gmail.com', 'matkhau631', 'SV', 'QTKD03', 'K009'),
('SV632', N'Lê Thị NB', N'Nữ', '2003-02-02', N'Thái Nguyên', '0912346232', 'lethina@gmail.com', 'matkhau632', 'SV', 'QTKD03', 'K009'),
('SV633', N'Vũ Thị NC', N'Nữ', '2003-03-03', N'Hà Nội', '0912346233', 'vuthinc@gmail.com', 'matkhau633', 'SV', 'QTKD03', 'K009'),
('SV634', N'Phan Thị ND', N'Nữ', '2003-04-04', N'Hải Dương', '0912346234', 'phanthind@gmail.com', 'matkhau634', 'SV', 'QTKD03', 'K009'),
('SV635', N'Nguyễn Thị NE', N'Nữ', '2003-05-05', N'Quảng Ninh', '0912346235', 'nguyenthine@gmail.com', 'matkhau635', 'SV', 'QTKD03', 'K009'),

('SV676', N'Nguyễn Thị Lan', N'Nữ', '2003-01-01', N'Bắc Giang', '0912346276', 'nguyenthilan@gmail.com', 'matkhau676', 'SV', 'NN01', 'K018'),
('SV677', N'Lê Thị Thu', N'Nữ', '2003-02-02', N'Hà Nội', '0912346277', 'lethithu@gmail.com', 'matkhau677', 'SV', 'NN01', 'K018'),
('SV678', N'Vũ Thị Mai', N'Nữ', '2003-03-03', N'Thái Nguyên', '0912346278', 'vuthimai@gmail.com', 'matkhau678', 'SV', 'NN01', 'K018'),
('SV679', N'Phan Thị Lan', N'Nữ', '2003-04-04', N'Vĩnh Phúc', '0912346279', 'phanthilan@gmail.com', 'matkhau679', 'SV', 'NN01', 'K018'),
('SV680', N'Nguyễn Thị Hồng', N'Nữ', '2003-05-05', N'Quảng Ninh', '0912346280', 'nguyenthihong@gmail.com', 'matkhau680', 'SV', 'NN01', 'K018'),

('SV681', N'Nguyễn Thị Mai', N'Nữ', '2003-06-06', N'Hà Nội', '0912346281', 'nguyenthimai@gmail.com', 'matkhau681', 'SV', 'NN02', 'K018'),
('SV682', N'Lê Thị Lan', N'Nữ', '2003-07-07', N'Bắc Ninh', '0912346282', 'lethilan@gmail.com', 'matkhau682', 'SV', 'NN02', 'K018'),
('SV683', N'Vũ Thị Thu', N'Nữ', '2003-08-08', N'Thái Bình', '0912346283', 'vuthithu@gmail.com', 'matkhau683', 'SV', 'NN02', 'K018'),
('SV684', N'Phan Thị Hương', N'Nữ', '2003-09-09', N'Hải Phòng', '0912346284', 'phanthihuong@gmail.com', 'matkhau684', 'SV', 'NN02', 'K018'),
('SV685', N'Nguyễn Thị Bích', N'Nữ', '2003-10-10', N'Quảng Ninh', '0912346285', 'nguyenthibich@gmail.com', 'matkhau685', 'SV', 'NN02', 'K018'),

('SV686', N'Nguyễn Thị Lan', N'Nữ', '2003-11-11', N'Hà Nội', '0912346286', 'nguyenthilan@gmail.com', 'matkhau686', 'SV', 'CNTP01', 'K019'),
('SV687', N'Lê Thị Bích', N'Nữ', '2003-12-12', N'Bắc Giang', '0912346287', 'lethibich@gmail.com', 'matkhau687', 'SV', 'CNTP01', 'K019'),
('SV688', N'Nguyễn Văn Hải', N'Nam', '2004-01-13', N'Thái Nguyên', '0912346288', 'nguyenvanhai@gmail.com', 'matkhau688', 'SV', 'CNTP01', 'K019'),
('SV689', N'Vũ Minh Tuấn', N'Nam', '2004-02-14', N'Vĩnh Phúc', '0912346289', 'vuminhtuan@gmail.com', 'matkhau689', 'SV', 'CNTP01', 'K019'),
('SV690', N'Phan Quang Hieu', N'Nam', '2004-03-15', N'Quảng Ninh', '0912346290', 'phanquanghieu@gmail.com', 'matkhau690', 'SV', 'CNTP01', 'K019'),

('SV691', N'Nguyễn Thị Lan', N'Nữ', '2003-04-10', N'Hà Nội', '0912346291', 'nguyenthilan@gmail.com', 'matkhau691', 'SV', 'CNTP02', 'K019'),
('SV692', N'Lê Thị Mai', N'Nữ', '2003-05-11', N'Bắc Giang', '0912346292', 'lethimai@gmail.com', 'matkhau692', 'SV', 'CNTP02', 'K019'),
('SV693', N'Nguyễn Thanh Bình', N'Nam', '2003-06-12', N'Thái Nguyên', '0912346293', 'nguyenbinh@gmail.com', 'matkhau693', 'SV', 'CNTP02', 'K019'),
('SV694', N'Vũ Mạnh Dũng', N'Nam', '2003-07-13', N'Vĩnh Phúc', '0912346294', 'vudung@gmail.com', 'matkhau694', 'SV', 'CNTP02', 'K019'),
('SV695', N'Phan Quốc Đạt', N'Nam', '2003-08-14', N'Quảng Ninh', '0912346295', 'phanquodath@gmail.com', 'matkhau695', 'SV', 'CNTP02', 'K019'),

('SV696', N'Nguyễn Minh Tuấn', N'Nam', '2003-09-15', N'Hà Nội', '0912346296', 'nguyenminhtuan@gmail.com', 'matkhau696', 'SV', 'KTE01', 'K008'),
('SV697', N'Lê Quang Huy', N'Nam', '2003-10-16', N'Bắc Ninh', '0912346297', 'lequanghuy@gmail.com', 'matkhau697', 'SV', 'KTE01', 'K008'),

('SV698', N'Nguyễn Thị Mai', N'Nữ', '2003-11-17', N'Hà Nội', '0912346298', 'nguyenthimai@gmail.com', 'matkhau698', 'SV', 'KTE02', 'K008'),
('SV699', N'Lê Văn Sơn', N'Nam', '2003-12-18', N'Bắc Giang', '0912346299', 'levanson@gmail.com', 'matkhau699', 'SV', 'KTE02', 'K008');


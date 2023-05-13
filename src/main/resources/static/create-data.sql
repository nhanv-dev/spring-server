# ========================================== CATEGORY ==========================================
insert into ecommerce.category (id, title, icon)
values (1, 'Thời Trang Nữ', null),
       (2, 'Thời Trang Nam', null),
       (3, 'Nhà Cửa', null),
       (4, 'Sức Khỏe & Làm Đẹp', null),
       (5, 'Giày Dép', null),
       (6, 'Túi Xách', null),
       (7, 'Đồng Hồ', null),
       (8, 'Phụ Kiện Thời Trang', null),
       (9, 'Tân Trang Nhà Cửa', null),
       (10, 'Đời sống', null),
       (11, 'Dịch Vụ Tiện Ích', null),
       (12, 'Phụ kiện công nghệ', null),
       (13, 'Ô tô - Xe máy', null),
       (14, 'Thiết bị y tế', null),
       (15, 'Mẹ và bé', null),
       (16, 'Thời Trang Trẻ Em', null),
       (17, 'Bách Hóa Tổng Hợp', null),
       (18, 'Thực Phẩm Tươi Sống', null),
       (19, 'Đồ điện gia dụng', null),
       (20, 'Điện thoại - Máy tính bảng', null),
       (21, 'Tivi - Thiết bị giải trí', null),
       (22, 'Máy ảnh - Máy quay phim', null),
       (23, 'Thiết bị âm thanh', null),
       (24, 'Thể thao - Dã ngoại - Giải trí', null),
       (25, 'Sách & Văn phòng phẩm', null),
       (26, 'Vật phẩm phong thủy', null),
       (27, 'Chăm sóc thú cưng', null),
       (28, 'Trang sức', null),
       (29, 'Điện máy', null),
       (30, 'Đồ chơi', null),
       (31, 'Laptop, Máy tính & Thiết bị văn phòng', null),
       (32, 'Vé máy bay - Du lịch', null),
       (33, 'Voucher dịch vụ', null);

insert into ecommerce.sub_category(category_id, title, icon)
values (1, 'Đầm, váy', null),
       (1, 'Áo nữ', null),
       (1, 'Set bộ, jumpsuit', null),
       (1, 'Áo khoác nữ', null),
       (1, 'Đồ lót nữ', null),
       (1, 'Quần nữ', null),
       (1, 'Đồ mặc nhà, đồ ngủ', null),
       (1, 'Chân váy', null),
       (1, 'Đồ bơi, đồ đi biển', null),
       (1, 'Đồ đôi nam nữ', null),
       (1, 'Quần áo thể thao nữ', null),
       (1, 'Thời trang trung niên', null),
       (1, 'Vải, nguyên phụ liệu may mặc', null),
       (1, 'Thời trang big size', null),
       (1, 'Thời trang thiết kế', null),
       (1, 'Trang phục cưới', null),
       (2, 'Áo thun, áo polo nam', null),
       (2, 'Áo sơ mi nam', null),
       (2, 'Áo Khoác Nam', null),
       (2, 'Quần jeans nam', null),
       (2, 'Quần Dài Nam', null),
       (2, 'Quần shorts nam', null),
       (2, 'Quần áo thể thao nam', null),
       (2, 'Đồ lót và đồ ngủ nam', null),
       (2, 'Áo vest, blazer', null),
       (2, 'Thời trang nam big size', null),
       (2, 'Áo dài nam', null),
       (3, 'Đồ dùng nhà bếp', null),
       (3, 'Đồ dùng phòng ngủ', null),
       (3, 'Đồ dùng sinh hoạt', null),
       (3, 'Đồ dùng phòng ăn, uống', null),
       (3, 'Thiết bị & đồ dùng phòng tắm', null),
       (3, 'Vệ sinh, chăm sóc nhà cửa', null),
       (3, 'Nội thất phòng khách', null),
       (3, 'Nội thất phòng làm việc', null),
       (3, 'Đồ Ngoại Thất', null),
       (3, 'Dụng cụ làm bánh, kem', null),
       (3, 'Nội thất phòng ngủ', null),
       (3, 'Nội thất bếp, phòng ăn', null),
       (3, 'Nội thất phòng trẻ em', null),
       (3, 'Bộ đồ ăn dùng một lần', null),
       (3, 'Đồ dùng trong nhà khác', null),
       (4, 'Dưỡng da mặt', null),
       (4, 'Trang điểm môi', null),
       (4, 'Trang điểm mặt', null),
       (4, 'Làm sạch da mặt', null),
       (4, 'Mặt nạ dưỡng da', null),
       (4, 'Trang điểm đôi mắt', null),
       (4, 'Trị liệu chuyên sâu da mặt', null),
       (4, 'Tắm & chăm sóc cơ thể', null),
       (4, 'Chăm sóc tóc', null),
       (4, 'Mỹ phẩm nam', null),
       (4, 'Nước hoa', null),
       (4, 'Mỹ phẩm Handmade & Organic', null),
       (4, 'Thực phẩm chức năng', null),
       (4, 'Thiết bị & dụng cụ chăm sóc cá nhân', null),
       (4, 'Dụng cụ trang điểm', null),
       (4, 'Chăm sóc răng miệng', null),
       (4, 'Chăm sóc móng', null),
       (4, 'Chăm sóc phụ nữ', null),
       (4, 'Sản phẩm hỗ trợ tình dục', null),
       (4, 'Dinh dưỡng thể thao, protein', null),
       (5, 'Dép nữ', null),
       (5, 'Giày cao gót nữ', null),
       (5, 'Giày sandal nữ', null),
       (5, 'Giày sneaker/thể thao nam', null),
       (5, 'Giày lười, giày mọi nam', null),
       (5, 'Giày sneaker/thể thao nữ', null),
       (5, 'Dép nam', null),
       (5, 'Giày thể thao chuyên dụng', null),
       (5, 'Giày tây nam', null),
       (5, 'Giày lười, giày mọi, slip-on nữ', null),
       (5, 'Giày boot nữ', null),
       (5, 'Giày tăng chiều cao nam', null),
       (5, 'Giày, dép unisex', null),
       (5, 'Giày, dép nhựa đi mưa', null),
       (5, 'Giày, dép nữ big size', null),
       (5, 'Giày, dép nam big size', null),
       (5, 'Giày nam khác', null),
       (5, 'Giày nữ khác', null),
       (5, 'Phụ kiện giày dép', null),
       (6, 'Balo', null),
       (6, 'Túi xách nữ', null),
       (6, 'Ví, bóp nam', null),
       (6, 'Túi xách nam', null),
       (6, 'Ví, bóp nữ', null),
       (6, 'Vali - Túi xách du lịch', null),
       (6, 'Túi laptop, ipad, điện thoại', null),
       (7, 'Đồng hồ nam', null),
       (7, 'Đồng hồ nữ', null),
       (7, 'Đồng hồ đôi', null),
       (7, 'Đồng hồ trẻ em', null),
       (7, 'Đồng hồ khác', null),
       (7, 'Phụ kiện đồng hồ', null),
       (8, 'Phụ kiện thời trang nữ', null),
       (8, 'Mắt kính nam nữ', null),
       (8, 'Phụ kiện tóc nữ', null),
       (8, 'Nón', null),
       (8, 'Thắt Lưng', null),
       (8, 'Phụ kiện thời trang nam', null),
       (9, 'Dụng cụ cầm tay', null),
       (9, 'Máy cơ khí và chế tạo', null),
       (9, 'Dụng cụ làm vườn', null),
       (9, 'Các loại đèn', null),
       (9, 'Thiết bị điện và phụ kiện', null),
       (9, 'Linh kiện điện tử', null),
       (9, 'Phụ kiện máy cơ khí và chế tạo', null),
       (9, 'Bóng đèn và phụ kiện đèn', null),
       (9, 'Thiết bị đo lường', null),
       (9, 'Thiết bị an ninh', null),
       (9, 'Thiết bị nước', null),
       (9, 'Dụng cụ xây dựng cho gia đình', null),
       (9, 'Bảo hộ lao động', null),
       (9, 'Đồ kim khí', null),
       (9, 'Thiết bị nâng đỡ', null),
       (9, 'Thiết bị và dụng cụ PCCC', null),
       (9, 'Tân trang nhà cửa khác', null),
       (10, 'Trang trí nhà cửa', null),
       (10, 'Quà tặng, hàng thủ công', null),
       (10, 'Hoa, Cây cảnh', null),
       (10, 'Nến và sản phẩm làm thơm phòng', null),
       (10, 'Trang trí bàn', null),
       (10, 'Trang trí tiệc và sự kiện', null),
       (10, 'Nguyên vật liệu làm đồ handmade', null),
       (10, 'Dụng cụ làm đồ handmade', null),
       (10, 'Trang trí cửa sổ, lối đi', null),
       (11, 'Tiện Ích Nổi Bật', null),
       (11, 'Tiện Ích Điện Thoại', null),
       (11, 'Thanh Toán Hóa đơn', null),
       (11, 'Du Lịch - Giải Trí', null),
       (11, 'Tài chính', null),
       (11, 'Quyên góp', null),
       (12, 'Ốp lưng, bao da điện thoại, máy tính bảng', null),
       (12, 'Sạc điện thoại, máy tính bảng', null),
       (12, 'Phụ kiện điện thoại, máy tính bảng', null),
       (12, 'Thiết bị đeo công nghệ', null),
       (12, 'Thiết bị lưu trữ', null),
       (12, 'Thiết bị mạng', null),
       (12, 'Phụ kiện công nghệ khác', null),
       (12, 'SIM card, dụng cụ chuyển đổi SIM', null),
       (12, 'Linh kiện điện thoại, máy tính bảng', null),
       (12, 'Cáp sạc, cáp kết nối', null),
       (13, 'Motor, xe máy, xe đạp điện', null),
       (13, 'Xe ô tô', null),
       (13, 'Phụ tùng xe máy', null),
       (13, 'Thiết bị số cho ô tô', null),
       (13, 'Phụ kiện bên trong ô tô', null),
       (13, 'Phụ kiện bên ngoài ô tô, phụ tùng', null),
       (13, 'Thiết bị định vị, cảm biến', null),
       (13, 'Đồ bảo hộ mô tô, xe máy', null),
       (13, 'Chăm sóc và bảo dưỡng ô tô, xe máy', null),
       (13, 'Đèn xe máy', null),
       (13, 'Bánh xe, lốp xe máy', null),
       (13, 'Phụ kiện, đồ chơi xe máy', null),
       (13, 'Hệ thống cơ điện, nhiên liệu, bộ lọc', null),
       (14, 'Chăm sóc sức khỏe', null),
       (14, 'Thiết bị massage', null),
       (14, 'Vật tư y tế', null),
       (14, 'Dụng cụ chuyên khoa', null),
       (14, 'Máy móc y tế', null),
       (14, 'Dụng cụ vật lý trị liệu', null),
       (14, 'Thiết bị y tế khác', null),
       (15, 'Bỉm, Tã, Vệ sinh', null),
       (15, 'Chăm sóc sức khỏe và an toàn', null),
       (15, 'Sữa và thức ăn dặm', null),
       (15, 'Dụng cụ ăn uống', null),
       (15, 'Đồ cho bé ra ngoài', null),
       (15, 'Thời trang mẹ bầu', null),
       (15, 'Đồ dùng phòng ngủ cho bé', null),
       (15, 'Đồ dùng phòng tắm cho bé', null),
       (15, 'Đồ dùng cho mẹ bầu', null),
       (15, 'Thời trang gia đình', null),
       (16, 'Quần áo sơ sinh', null),
       (16, 'Bé gái 1-4 tuổi', null),
       (16, 'Bé gái 5-14 tuổi', null),
       (16, 'Bé trai 1-4 tuổi', null),
       (16, 'Bé trai 5-14 tuổi', null),
       (16, 'Giày dép bé gái', null),
       (16, 'Giày dép bé trai', null),
       (16, 'Phụ kiện thời trang trẻ em', null),
       (17, 'Giặt giũ & chăm sóc nhà cửa', null),
       (17, 'Các loại thực phẩm khô', null),
       (17, 'Đồ uống', null),
       (17, 'Bánh, mứt', null),
       (17, 'Gia vị', null),
       (17, 'Thực phẩm bổ dưỡng', null),
       (17, 'Kẹo', null),
       (17, 'Sữa và thực phẩm từ sữa', null),
       (17, 'Nguyên liệu', null),
       (17, 'Thực phẩm đóng hộp', null),
       (17, 'Vệ sinh cá nhân', null),
       (17, 'Thực phẩm chay', null),
       (17, 'Quà tặng bách hóa theo mùa', null),
       (17, 'Bách hóa tổng hợp khác', null),
       (18, 'Rau - củ - quả', null),
       (18, 'Các Loại Mắm', null),
       (18, 'Thực phẩm đông lạnh', null),
       (18, 'Thủy hải sản', null),
       (18, 'Thịt - Trứng', null),
       (19, 'Quạt', null),
       (19, 'Máy xay, máy ép', null),
       (19, 'Nồi điện, nồi cơm điện', null),
       (19, 'Thiết bị điện nhà bếp', null),
       (19, 'Thiết bị chăm sóc quần áo', null),
       (19, 'Bếp điện, ấm đun', null),
       (19, 'Máy lọc, điều hòa không khí', null),
       (19, 'Máy hút bụi', null),
       (19, 'Lò nướng, bếp nướng', null),
       (19, 'Thiết bị điện cho nhà hàng, quán cafe', null),
       (19, 'Máy nước nóng', null),
       (20, 'Điện thoại mới', null),
       (20, 'Máy tính bảng mới', null),
       (20, 'Điện thoại cũ', null),
       (20, 'Máy tính bảng cũ', null),
       (21, 'Tivi', null),
       (21, 'Phụ kiện tivi', null),
       (21, 'Thiết bị chơi game', null),
       (22, 'Máy quay, thiết bị ghi hình', null),
       (22, 'Máy ảnh', null),
       (22, 'Ống kính', null),
       (22, 'Phụ kiện máy ảnh, máy quay', null),
       (22, 'Máy ảnh - Máy quay phim khác', null),
       (23, 'Loa', null),
       (23, 'Tai nghe', null),
       (23, 'Hệ thống giải trí, karaoke', null),
       (23, 'Linh kiện và phụ kiện âm thanh', null),
       (23, 'Thiết bị âm thanh khác', null),
       (24, 'Dụng cụ, thiết bị tập thể dục', null),
       (24, 'Hỗ trợ an toàn', null),
       (24, 'Xe đạp', null),
       (24, 'Phụ kiện xe đạp', null),
       (24, 'Phụ tùng xe đạp', null),
       (24, 'Bơi lội, lặn', null),
       (24, 'Tennis', null),
       (24, 'Cầu lông', null),
       (24, 'Bóng bàn', null),
       (24, 'Bóng đá', null),
       (24, 'Bóng chuyền', null),
       (24, 'Bóng rổ', null),
       (24, 'Dã ngoại, cắm trại', null),
       (24, 'Leo núi', null),
       (24, 'Câu cá', null),
       (24, 'Yoga, võ thuật, đấm bốc', null),
       (24, 'Chạy bộ', null),
       (24, 'Golf', null),
       (24, 'Các môn thể thao khác', null),
       (24, 'Nhạc cụ', null),
       (25, 'Văn Phòng Phẩm', null),
       (25, 'Dụng cụ mỹ thuật', null),
       (25, 'Sách Ngoại ngữ - Từ điển', null),
       (25, 'Sách thường thức - đời sống', null),
       (25, 'Sách Văn học - Tiểu thuyết', null),
       (25, 'Sách thiếu nhi', null),
       (25, 'Sách Kinh tế', null),
       (25, 'Sách Giáo khoa - Tham khảo', null),
       (25, 'Sách chuyên ngành', null),
       (25, 'Sách Văn hóa - Du lịch', null),
       (25, 'Sách cũ', null),
       (26, 'Tượng Phật', null),
       (26, 'Linh vật phong thủy', null),
       (26, 'Đá phong thủy', null),
       (26, 'Tranh phong thủy', null),
       (26, 'Phong thủy trang trí', null),
       (26, 'Đồ thờ cúng', null),
       (26, 'Trang sức phong thủy', null),
       (27, 'Chăm sóc chó, mèo', null),
       (27, 'Chăm sóc cá & bể thủy sinh', null),
       (27, 'Chăm sóc chim', null),
       (27, 'Chăm sóc thú cưng khác', null),
       (28, 'Vòng, lắc tay', null),
       (28, 'Dây chuyền, vòng cổ', null),
       (28, 'Bông tai, khuyên tai', null),
       (28, 'Nhẫn', null),
       (28, 'Set bộ trang sức', null),
       (28, 'Trang sức cơ thể', null),
       (28, 'Trang sức cặp đôi', null),
       (28, 'Trang sức cho bé', null),
       (28, 'Charm', null),
       (28, 'Kệ treo, hộp đựng trang sức', null),
       (28, 'Nguyên liệu & dụng cụ làm trang sức', null),
       (28, 'Trang sức vàng nữ', null),
       (28, 'Trang sức vàng nam', null),
       (28, 'Trang sức vàng khác', null),
       (29, 'Tủ lạnh, tủ đông, tủ mát', null),
       (29, 'Máy lạnh, máy điều hòa', null),
       (29, 'Máy giặt, máy sấy', null),
       (29, 'Điện gia dụng lớn', null),
       (30, 'Đồ chơi điều khiển từ xa', null),
       (30, 'Hóa trang, cosplay', null),
       (30, 'Trò chơi', null),
       (30, 'Đồ chơi vận động cho bé', null),
       (30, 'Đồ chơi phát triển trí tuệ', null),
       (30, 'Búp bê, thú bông', null),
       (30, 'Mô hình đồ chơi', null),
       (30, 'Đồ chơi cho bé dưới 18 tháng', null),
       (30, 'Đồ chơi đồ hàng', null),
       (30, 'Đồ chơi khác', null),
       (31, 'Laptop mới', null),
       (31, 'Phụ kiện máy tính, laptop', null),
       (31, 'Chuột, bàn phím', null),
       (31, 'Linh kiện máy tính, laptop', null),
       (31, 'Máy tính để bàn', null),
       (31, 'Laptop cũ', null),
       (31, 'Máy chiếu và phụ kiện', null),
       (31, 'Máy in & Phụ kiện máy in', null),
       (31, 'Phần mềm máy tính', null),
       (31, 'Thiết bị văn phòng khác', null),
       (32, 'Vé máy bay Depot', null),
       (32, 'Vé xe Depot', null),
       (32, 'Vé tàu Depot', null),
       (32, 'Phương tiện di chuyển - Thuê xe', null),
       (32, 'Tour du lịch trong nước', null),
       (32, 'Combo du lịch trong nước', null),
       (32, 'Dịch vụ du lịch trong nước', null),
       (32, 'Khách sạn', null),
       (32, 'Tour trọn gói', null),
       (33, 'E-Voucher - Quà Tặng', null),
       (33, 'Nhà hàng - Ẩm thực', null),
       (33, 'Khóa học', null),
       (33, 'Giải trí', null),
       (33, 'Mã code phần mềm', null),
       (33, 'Làm đẹp - Spa - Gym', null),
       (33, 'Dịch vụ bảo hiểm', null),
       (33, 'Dịch vụ giúp việc - Sửa chữa', null),
       (33, 'Dịch vụ quà tặng', null);

# ========================================== RETURN_POLICY ==========================================
insert into ecommerce.return_policy(id, title, tooltip_title, tooltip_content)
values (1, 'Miễn phí hoàn trả', 'Miễn phí hoàn trả',
        'Depot bảo vệ quyền lợi khách hàng hoàn trả sản phẩm miễn phí nếu lỗi của Shop (sản phẩm kém chất lượng, bị lỗi kỹ thuật, hư hỏng không sử dụng được, bể vỡ, không đúng mô tả, hoặc không đúng như đơn đặt hàng).'),
       (2, '48 giờ hoàn trả', 'Chính sách hoàn trả của Depot',
        'Trả hàng hoàn tiền trong vòng 48 giờ cho các sản phẩm bị lỗi kỹ thuật, bể vỡ, không đúng mô tả hoặc không đúng như đơn đặt hàng.'),
       (3, 'Bảo hành theo chính sách từ Nhà bán hàng', 'Bảo hành theo chính sách từ Nhà bán hàng',
        'Depot sẽ xử lý các khiếu nại phát sinh liên quan đến sản phẩm hư hỏng hoặc có lỗi từ nhà bán hàng. Về điều kiện bảo hành sản phẩm sẽ tuân thủ theo chính sách từ Nhà bán hàng.');

# ========================================== ROLE ==========================================
insert into ecommerce.role (id, type)
values (1, 'ROLE_USER'),
       (2, 'ROLE_SHOP'),
       (3, 'ROLE_ADMIN');
insert into ecommerce.user(id, email, name, password, phone_number)
values (1, 'tthanhnhan1512@gmail.com', 'Trần Thanh Nhân',
        '$2a$10$nC85ASrpuW/qaU06hsney.GW/2pvlw41dnIrJdBXdKILGnDK2FY7.', '0946286951');

insert ecommerce.user_role(user_id, role_id)
values (1, 3);
# ========================================== ROLE ==========================================
insert into ecommerce.orders_status (id, status, title, description, label_confirm, label_created_at)
values (1, 'PENDING', 'Đang đợi xác nhận',
        'Đơn hàng từ người mua đang đợi được xác nhân. Kiểm tra lại đơn hàng và nhấn nút "Xác nhận đơn hàng" để xác nhận.',
        'Xác nhận đơn hàng', 'Tạo đơn hàng'),
       (2, 'CONFIRMED', 'Đã xác nhận', 'Đơn hàng đã được xác nhận. Đóng gói đơn hàng và chuyển sang vận chuyển.',
        'Vận chuyển đơn hàng', 'Đã xác nhận'),
       (3, 'SHIPPING', 'Đang giao hàng',
        'Đơn hàng đang được vận chuyển. Hoàn tất giai đoạn giao hàng khi xác nhận người mua đã nhận được hàng.',
        'Giao hàng thành công', 'Bắt đầu giao hàng'),
       (4, 'COMPLETED', 'Đã hoàn thành', 'Người dùng đã nhận được hàng. Chọn để hoàn tất và kết thúc đơn hàng.',
        'Hoàn tất đơn hàng', 'Hoàn tất đơn hàng'),
       (5, 'CANCELLED', 'Đã hủy', 'Đơn hàng đã bị hủy', 'Hủy đơn hàng', 'Hủy đơn hàng');
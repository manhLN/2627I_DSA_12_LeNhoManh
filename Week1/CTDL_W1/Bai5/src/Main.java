/*
1. Phân tích cấu trúc cây từ mảng:

Nút gốc của toàn bộ cấu trúc là 5 (vì parent[5] = 5)

Các nút con trực tiếp của 5 là: 0, 7

Các nút con trực tiếp của 0 là: 2, 4, 6

Nút con trực tiếp của 4 là: 3

Các nút con trực tiếp của 6 là: 1, 8

Nút con trực tiếp của 7 là: 9

2. Phân tích kích thước các cây con:

Cây con gốc 0: Bao gồm các nút 0, 2, 4, 6, 3, 1, 8. Tổng kích thước = 7 nút

Toàn bộ cây gốc 5: Bao gồm tất cả 10 nút từ 0 đến 9. Tổng kích thước = 10 nút

3. Kiểm tra tính hợp lệ theo quy tắc Weighted Quick Union:
Dựa vào mảng, parent[0] = 5, nghĩa là gốc 0 đã được hợp nhất và trỏ vào gốc 5
Theo thuật toán, để gốc 0 trỏ vào gốc 5 thì tại thời điểm hợp nhất, kích thước của cây gốc 5 (trước khi nhận cây 0) phải lớn hơn hoặc bằng kích thước của cây gốc 0

Kích thước của cây gốc 0 tại thời điểm đó là 7

Kích thước của cây gốc 5 tại thời điểm đó (chỉ gồm 5, 7, 9) là 3

Ta thấy 7 lớn hơn 3. Nếu thực thi đúng thuật toán Weighted Quick Union, khi hợp nhất hai cây này, gốc 5 (kích thước nhỏ hơn) phải trỏ vào gốc 0 (kích thước lớn hơn), chứ không phải 0 trỏ vào 5 như mảng đã cho

Ngoài ra, ta có thể dùng tính chất: Kích thước cây sau hợp nhất phải lớn hơn hoặc bằng 2 lần kích thước của cây con bị ghép vào. Ở đây, Tổng kích thước(5) ≥ 2 * Kích thước(0), tương đương 10 ≥ 2 * 7 (tức là 10 ≥ 14), điều này hoàn toàn vô lý

=> Mảng trên không thể là biểu diễn parent-link của một cấu trúc dữ liệu Weighted Quick Union
 */
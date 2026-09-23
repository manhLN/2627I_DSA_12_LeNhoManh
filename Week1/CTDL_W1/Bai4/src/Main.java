/*
1. Phân tích cấu trúc các cây (forest) hiện tại từ mảng parent[]:

Cây gốc 0: Các nút 1, 2 và 3 đều có giá trị parent là 0
-> Kích thước của cây gốc 0 là 4 nút (bao gồm 0, 1, 2, 3)

Cây gốc 4: Các nút 5 và 6 có parent là 4. Nút 7 có parent là 5
Điều này xảy ra khi nút 5 và 7 hợp nhất (kích thước 2), nút 4 và 6 hợp nhất (kích thước 2). Sau đó gốc 5 hợp nhất với gốc 4 (kích thước bằng nhau nên 5 trỏ vào 4)
-> Kích thước của cây gốc 4 là 4 nút (bao gồm 4, 5, 6, 7)

Cây chứa nút 8 và 9: Mảng cho thấy parent[9] = 8
Điều này chứng tỏ 8 từng là một nút gốc khi nó hợp nhất với 9
-> Kích thước của cây con gốc 8 hiện tại ít nhất là 2 nút (bao gồm 8 và 9)

2. Áp dụng quy tắc Weighted Quick Union (link-by-size):
Khi hợp nhất hai cây, gốc của cây có kích thước nhỏ hơn sẽ phải trỏ vào gốc của cây có kích thước lớn hơn hoặc bằng. Do đó, nếu nút A trỏ vào nút B, thì tại thời điểm hợp nhất, B phải là nút gốc và kích thước của B phải lớn hơn hoặc bằng kích thước của A

3. Đánh giá các trường hợp có thể của parent[8]:

Trường hợp parent[8] = 8: Nút 8 vẫn đang là một nút gốc độc lập và chưa hợp nhất với cây nào khác (Hợp lệ)

Trường hợp parent[8] = 0: Cây gốc 8 (kích thước ≥ 2) hợp nhất với cây gốc 0 (kích thước 4). Vì 4 ≥ 2, gốc 8 hoàn toàn có thể trỏ vào gốc 0 (Hợp lệ)

Trường hợp parent[8] = 4: Cây gốc 8 (kích thước ≥ 2) hợp nhất với cây gốc 4 (kích thước 4). Vì 4 ≥ 2, gốc 8 hoàn toàn có thể trỏ vào gốc 4 (Hợp lệ)

Trường hợp parent[8] = 5: Giả sử 8 trỏ vào 5. Tại thời điểm đó, 5 phải là gốc và có kích thước ≥ 2. Cây gốc 5 sau khi nhận thêm 8 (và 9) sẽ có kích thước ít nhất là 4. Sau đó, theo mảng, 5 lại trỏ vào 4. Tuy nhiên, cây gốc 4 ban đầu chỉ có kích thước 2. Một cây gốc 5 (kích thước ≥ 4) không thể trỏ vào cây gốc 4 (kích thước 2) theo quy tắc của thuật toán (Không hợp lệ)

Trường hợp parent[8] là 1, 2, 3, 6, 7 hoặc 9: Các nút này chưa bao giờ đóng vai trò là nút gốc của một cây có kích thước ≥ 2, do đó gốc 8 (kích thước 2) không thể trỏ vào chúng (Không hợp lệ)

=> Giá trị của parent[8] có thể nhận là các giá trị: 0, 4, 8.
 */
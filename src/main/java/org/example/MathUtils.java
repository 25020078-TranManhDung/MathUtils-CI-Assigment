package org.example;

import java.nio.file.Path;

/**
 * Lớp tiện ích chứa các phương thức toán học và xử lý cơ bản.
 */
public class MathUtils {

  /**
   * Trả về giá trị lớn nhất giữa hai số nguyên.
   *
   * @param a số thứ nhất
   * @param b số thứ hai
   * @return số lớn hơn trong hai số
   */
  public static int max(int a, int b) {
    if (a >= b) {
      return a;
    }
    return b;
  }

  /**
   * Thực hiện phép chia số nguyên và ném ngoại lệ nếu số chia là 0.
   *
   * @param a số bị chia
   * @param b số chia
   * @return kết quả của phép chia nguyên
   * @throws IllegalArgumentException nếu b bằng 0
   */
  public static int divide(int a, int b) {
    if (b == 0) {
      throw new IllegalArgumentException("Divider must not be zero");
    }
    return a / b;
  }

  /**
   * Tạo đường dẫn tệp an toàn đa nền tảng.
   *
   * @param folder   thư mục chứa tệp
   * @param fileName tên tệp
   * @return đường dẫn dạng chuỗi phù hợp với hệ điều hành
   */
  public static String getFilePath(String folder, String fileName) {
    // Sử dụng Path.of để tự động chọn dấu gạch chéo đúng theo OS
    return Path.of(folder, fileName).toString();
  }
}
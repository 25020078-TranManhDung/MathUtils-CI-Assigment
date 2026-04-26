package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilsTest {

  // ==========================================
  // Vòng đời của Test (Test Lifecycle)
  // ==========================================

  @BeforeAll
  public static void setUpAll() {
    System.out.println("=== Bat dau chay org.example.MathUtilsTest ===");
  }

  @AfterAll
  public static void tearDownAll() {
    System.out.println("=== Ket thuc ===");
  }

  // ==========================================
  // Test cases cho hàm max(int a, int b)
  // ==========================================

  @Test
  @DisplayName("EP: a lớn hơn b")
  public void testMax_AGreaterThanB() {
    // Kiểm tra phân vùng a > b
    assertEquals(5, MathUtils.max(5, 3));
    assertEquals(100, MathUtils.max(100, -50));
  }

  @Test
  @DisplayName("EP: a bằng b")
  public void testMax_AEqualsB() {
    // Kiểm tra phân vùng a = b
    assertEquals(4, MathUtils.max(4, 4));
    assertEquals(-10, MathUtils.max(-10, -10));
  }

  @Test
  @DisplayName("EP: a nhỏ hơn b")
  public void testMax_ALessThanB() {
    // Kiểm tra phân vùng a < b
    assertEquals(7, MathUtils.max(2, 7));
    assertEquals(0, MathUtils.max(-5, 0));
  }

  @Test
  @DisplayName("BVA: Kiểm tra các giá trị biên của kiểu int")
  public void testMax_BoundaryValues() {
    // Kiểm tra với Integer.MAX_VALUE và Integer.MIN_VALUE
    assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, 0));
    assertEquals(Integer.MAX_VALUE, MathUtils.max(0, Integer.MAX_VALUE));
    assertEquals(10, MathUtils.max(Integer.MIN_VALUE, 10));
    assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, Integer.MIN_VALUE));
  }

  // ==========================================
  // Test cases cho hàm divide(int a, int b)
  // ==========================================

  @Test
  @DisplayName("EP: b > 0 (Số chia là số dương)")
  public void testDivide_PositiveDivider() {
    // Kiểm tra phân vùng b > 0
    assertEquals(5, MathUtils.divide(10, 2));
    assertEquals(0, MathUtils.divide(0, 5));
  }

  @Test
  @DisplayName("EP: b < 0 (Số chia là số âm)")
  public void testDivide_NegativeDivider() {
    // Kiểm tra phân vùng b < 0
    assertEquals(-5, MathUtils.divide(10, -2));
    assertEquals(3, MathUtils.divide(-9, -3));
  }

  @Test
  @DisplayName("EP: b = 0 (Bắt ngoại lệ chia cho 0)")
  public void testDivide_ZeroDivider() {
    // Sử dụng assertThrows để xác nhận ngoại lệ IllegalArgumentException được ném ra
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      MathUtils.divide(10, 0);
    });

    // Xác nhận thông báo lỗi (message) trả về có chính xác như thiết kế hay không
    assertEquals("Divider must not be zero", exception.getMessage());
  }

  @Test
  @DisplayName("BVA: Kiểm tra các giá trị biên của phép chia (divide)")
  public void testDivide_BoundaryValues() {
    // 1. Biên của số chia (b) lân cận giá trị 0
    assertEquals(10, MathUtils.divide(10, 1));
    assertEquals(-10, MathUtils.divide(10, -1));

    // 2. Biên của số bị chia (a) là MAX_VALUE và MIN_VALUE
    assertEquals(Integer.MAX_VALUE, MathUtils.divide(Integer.MAX_VALUE, 1));
    assertEquals(Integer.MIN_VALUE, MathUtils.divide(Integer.MIN_VALUE, 1));

    // MAX_VALUE chia -1 đổi dấu thành -2147483647
    assertEquals(-2147483647, MathUtils.divide(Integer.MAX_VALUE, -1));

    // 3. Cả a và b đều là cực đại/cực tiểu
    assertEquals(1, MathUtils.divide(Integer.MAX_VALUE, Integer.MAX_VALUE));
    assertEquals(1, MathUtils.divide(Integer.MIN_VALUE, Integer.MIN_VALUE));

    // 4. EDGE CASE (TRÀN SỐ): Cực tiểu chia cho -1
    // -2147483648 / -1 = 2147483648 -> Tràn số giới hạn int -> Quay về -2147483648
    assertEquals(Integer.MIN_VALUE, MathUtils.divide(Integer.MIN_VALUE, -1));
  }

  @Test
  void testFilePath() {
    String folder = "data";
    String fileName = "report.txt";

    // Path.of sẽ tự hiểu:
    // - Trên Windows là "data\report.txt"
    // - Trên Linux là "data/report.txt"
    String expected = Path.of(folder, fileName).toString();

    assertEquals(expected, MathUtils.getFilePath(folder, fileName));
  }
}

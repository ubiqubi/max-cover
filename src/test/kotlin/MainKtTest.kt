import org.junit.Test
import org.junit.Assert.assertEquals

class MainKtTest {
    // Инициализируем объект класса MainKt

    @Test
    fun testCalculateCommission1() {
        // Проверяем функцию calculateCommission для разных типов карт
        val result = calculateCommission("visa", 3000, 100)
        assertEquals(35, result)
    }
    @Test
    fun testCalculateCommission2() {
        val result = calculateCommission("visa", 550000, 160000)
        assertEquals(-1, result)
    }
    @Test
    fun testCalculateCommission3() {
        val result = calculateCommission("visa", 3000, 180000)
        assertEquals(1350, result)
    }
    @Test
    fun testCalculateCommission4() {
        val result = calculateCommission("mastercard", 74000, 5000)
        assertEquals(44, result)
    }
    @Test
    fun testCalculateCommission5() {
        val result = calculateCommission("mastercard", 500, 1000)
        assertEquals(0, result)
    }
    @Test
    fun testCalculateCommission6() {
        val result = calculateCommission("mastercard", 80000, 1000)
        assertEquals(26, result)
    }
    @Test
    fun testCalculateCommission7() {
        val result = calculateCommission("mastercard", 8000, 100)
        assertEquals(20, result)
    }
    @Test
    fun testCalculateCommission8() {
        val result = calculateCommission("mastercard", 550000, 150000)
        assertEquals(-1, result)
    }
    @Test
    fun testCalculateCommission9() {
        val result = calculateCommission("mastercard", 66800, 221000)
        assertEquals(1296, result)
    }
    @Test
    fun testCalculateCommission10() {
        val result = calculateCommission("vkpay", 3000, 100)
        assertEquals(0, result)
    }
    @Test
    fun testCalculateCommission11() {
        val result = calculateCommission("vkpay", 50000, 1000)
        assertEquals(-1, result)
    }
    @Test
    fun testCalculateCommission12() {
        val result = calculateCommission("vkpay", 30000, 18000)
        assertEquals(-1, result)
    }
    @Test
    fun testCalculateCommission13() {
        val result = calculateCommission("wrong", 30000, 18000)
        assertEquals(-2, result)

    }
}


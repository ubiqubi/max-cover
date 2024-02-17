import org.junit.Test
import org.junit.Assert.assertEquals

class MainKtTest {
    // Инициализируем объект класса MainKt


    @Test
    fun testResult() {
        // Проверяем функцию result для разных типов карт
        result("visa")
        result("mastercard")
        result("vkpay")
        result("test")
    }

    @Test
    fun testCalculateCommission() {
        // Проверяем функцию calculateCommission для разных типов карт
        calculateCommission("visa", 3000, 100)
        calculateCommission("visa", 550000, 160000)
        calculateCommission("visa", 3000, 180000)
        calculateCommission("mastercard", 74000, 5000)
        calculateCommission("mastercard", 500, 1000)
        calculateCommission("mastercard", 80000, 1000)
        calculateCommission("mastercard", 8000, 100)
        calculateCommission("mastercard", 550000, 150000)
        calculateCommission("mastercard", 66800, 221000)
        calculateCommission("vkpay", 3000, 100)
        calculateCommission("vkpay", 50000, 1000)
        calculateCommission("vkpay", 30000, 18000)
        calculateCommission("wrong", 30000, 18000)

    }
}


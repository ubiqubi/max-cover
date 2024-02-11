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
        calculateCommission("vkpay", 39000, 100)
        calculateCommission("visa", 39000, 100)
        calculateCommission("visa", 3900, 10000)
        calculateCommission("mastercard", 74000, 5000) // бранч видит только решение но не условие :(
        calculateCommission("mastercard", 500, 100)
        calculateCommission("mastercard", 80000, 1000)
        calculateCommission("mastercard", 8000, 1000)
        calculateCommission("mastercard", 668000, 1000) // бранч не видит :(
        calculateCommission("mastercard", 668000, 221000) // бранч не видит :(
        calculateCommission("vkpay", 55000, 100) // бранч не видит :(
        calculateCommission("vkpay", 3900, 22100) // бранч не видит :(
    }
}


import org.junit.Test
import org.junit.Assert.assertEquals

class MainKtTest {
    val cardType1 = "visa"
    val cardType2 = "mastercard"
    val cardType3 = "vkpay"
    val totalPreviousTransfer = 6000
    val amount = 70000

    @Test
    fun calculateCommissioncardType1() {
        val result = calculateCommission(cardType1, totalPreviousTransfer, amount)
        assertEquals(525, result)
    }

    @Test
    fun calculateCommissioncardType2() {
        val result = calculateCommission(cardType2, totalPreviousTransfer, amount)
        assertEquals(26, result)
    }

    @Test
    fun calculateCommissioncardType3() {
        val result = calculateCommission(cardType3, totalPreviousTransfer, amount)
        assertEquals(0, result)}

    @Test
    fun calculateCommissioncardType4() {
        val result = calculateCommission(cardType1, 70, 100)
        assertEquals(35, result)
    }

    @Test
    fun calculateCommissioncardType5() {
        val result = calculateCommission(cardType2, 700, 1000)
        assertEquals(0, result)
    }

    @Test
    fun calculateCommissioncardType6() {
        val result = calculateCommission(cardType2, 77000, 100)
        assertEquals(20, result)
    }

    @Test
    fun calculateCommissioncardType7() {
        val result = calculateCommission("test", 77000, 100)
        assertEquals(0, result)
    }
    @Test
    fun result1() {
       result("cardType3")



}
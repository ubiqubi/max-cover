import kotlin.math.max

val cardType1 = "visa"
val cardType2 = "mastercard"
val cardType3 = "vkpay"
val mastercardMaestroMinTransfer = 300
val mastercardMaestroMaxTransfer = 75000
val mastercardMaestroCommissionRate = 0.006
val mastercardMaestroCommissionStatic = 20
val visaMIRMinTransfer = 35
val visaMIRCommissionRate = 0.0075
val dailyLimit = 150000
val monthlyLimit = 600000
val vkRauMaxTransfer = 15000
val vkRauMaxTransferMonth = 40000
val totalPreviousTransfer = 7000 // сумма переводов за месяц
val transferAmount = 20000 // сумма перевода
val ERROR_LIMIT = -1
val ERROR_TYPE = -2

// Проверка функции calculateCommission
fun main() {
    result(cardType1)
    result(cardType2)
    result(cardType3)
}

// Функция вывода результата расчетов
fun result(cardType: String) {
    var commission = calculateCommission(cardType, totalPreviousTransfer, transferAmount)
    var resultAmount = transferAmount + commission
    if (commission == ERROR_LIMIT) {
        println("Превышен лимит")
    } else if (commission == ERROR_TYPE) {
        println("Неверная карта")
    } else {
        println("Сумма перевода: $transferAmount")
        println("Комиссия: $commission")
        println("Общая сумма: $resultAmount \n")
    }
}

// Функция расчета комиссии
fun calculateCommission(cardType: String, totalPreviousTransfer: Int, transferAmount: Int): Int {
    // Проверяем тип карты и осуществляем расчет комиссии
    return when (cardType) {
        // Комиссия для карт mastercard и maestro
        "mastercard", "maestro" ->
            if (transferAmount < dailyLimit || (transferAmount + totalPreviousTransfer) < monthlyLimit) {
                // Сумма перевода менее 300
                if (transferAmount < mastercardMaestroMinTransfer) {
                    (transferAmount * mastercardMaestroCommissionRate + mastercardMaestroCommissionStatic).toInt()
                }
                // Сумма Перевода более 300 и менее 75000 за месяц
                else if (transferAmount < (mastercardMaestroMaxTransfer - totalPreviousTransfer)) {
                    0
                }
                // Сумма Перевода более 300 или менее 75000 за месяц минус прошлые переводы
                else if (mastercardMaestroMaxTransfer > totalPreviousTransfer) {
                    (((transferAmount - (mastercardMaestroMaxTransfer - totalPreviousTransfer)) * mastercardMaestroCommissionRate) + mastercardMaestroCommissionStatic).toInt()
                }
                // Сумма перевода более 75000 за месяц
                else {
                    (transferAmount * mastercardMaestroCommissionRate + mastercardMaestroCommissionStatic).toInt()
                }
            } else {
                ERROR_LIMIT
            }


        "visa", "мир" -> {
            // Комиссия для карт visa и мир
            if (transferAmount < dailyLimit || (transferAmount + totalPreviousTransfer) < monthlyLimit) {
                max(visaMIRMinTransfer, (transferAmount * visaMIRCommissionRate).toInt())

            } else {
                ERROR_LIMIT
            }
        }

        "vkpay" -> {
            // Комиссия для переводов на счет ВК РАУ = 0
            if (transferAmount < vkRauMaxTransfer && (transferAmount + totalPreviousTransfer) < vkRauMaxTransferMonth) {
                return 0
            } else {
                ERROR_LIMIT
            }
        }

        else -> ERROR_TYPE
    }
}






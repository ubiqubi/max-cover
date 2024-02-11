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
val totalPreviousTransfer = 39000 // сумма переводов за месяц
val transferAmount = 100 // сумма перевода
var commission = 0

fun main() {
    // Проверка функции calculateCommission

    result(cardType1)
    result(cardType2)
    result(cardType3)


}

// Функция вывода результата расчетов
fun result(cardType: String) {
    var commission = calculateCommission(cardType, totalPreviousTransfer, transferAmount)
    var resultAmount = transferAmount + commission
    // Проверяем лимит по карте
    if ((transferAmount > dailyLimit || (transferAmount + totalPreviousTransfer) > monthlyLimit)
        || (cardType == "vkpay" && transferAmount > vkRauMaxTransfer)
        || (cardType == "vkpay" && (totalPreviousTransfer+transferAmount) > vkRauMaxTransferMonth)
    ) {
        println("Операция не выполнена, превышен лимит.")
        return
    } else {
        println("Сумма перевода: $transferAmount")
        println("Комиссия: $commission")
        println("Общая сумма: $resultAmount \n")
    }
}

// Функция расчета комиссии
fun calculateCommission(cardType: String, totalPreviousTransfer: Int, transferAmount: Int): Int {
    // Проверяем тип карты и осуществляем расчет комиссии
    when (cardType) {
        "mastercard", "maestro" -> {
            // Комиссия для карт mastercard и maestro
            // Сумма перевода более 75000 за месяц или менее 300
            if (totalPreviousTransfer > mastercardMaestroMaxTransfer || mastercardMaestroMinTransfer > transferAmount) {
                commission =
                    (transferAmount * mastercardMaestroCommissionRate + mastercardMaestroCommissionStatic).toInt()
            }
            // Сумма Перевода более 300 или менее 75000 за месяц
            else if (transferAmount > (mastercardMaestroMaxTransfer - totalPreviousTransfer) && mastercardMaestroMinTransfer < transferAmount) {
                commission =
                    ((transferAmount - (mastercardMaestroMaxTransfer - totalPreviousTransfer)) * mastercardMaestroCommissionRate + mastercardMaestroCommissionStatic).toInt()
            } else {
                commission = 0
            }
            return commission
        }

        "visa", "мир" -> {
            // Комиссия для карт visa и мир
            if ((transferAmount * visaMIRCommissionRate) < visaMIRMinTransfer) {
                // Минимум 35 рублей
                commission = visaMIRMinTransfer
            } else {
                commission = (transferAmount * visaMIRCommissionRate).toInt()
            }
            return commission
        }

        "vkpay" -> {
            // Комиссия для переводов на счет ВК РАУ = 0
            return 0
        }

        else -> {
            return 0
            //error("ERROR this CARD os not VALID")
        }
    }
}






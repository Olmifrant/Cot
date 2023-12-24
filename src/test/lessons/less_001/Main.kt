package test.lessons.less_001

import java.util.*

fun main(args: Array<String>) {

    println("Массив")

    val myArrayList: MyArrayList = MyArrayList()

    for (i in 1..15) {
        val arr = i.toString()
        myArrayList.addValue(arr)
    }

    while (true) {
        println()
        println("Выберете вариант из списка: ")
        println("01. Вывести на экран весь массив")
        println("02. Добавить значение в массив")
        println("03. Добавить значение в заданную ячейку")
        println("04. Удалить значение по номеру ячейки")
        println("05. Удалить значение")
        println("06. Вывести значение заданной ячейки на экран")
        println("07. Завершить работу")

        val scan = Scanner(System.`in`)
        var choice = 0
        while (true) {
            if (scan.hasNextInt()) {
                choice = scan.nextInt()
                scan.nextLine()
                if (choice >= 1 && choice <= 7) {
                    break
                } else {
                    println("Выберите вариант из списка пожалуйста!")
                }
            } else {
                println("Только цифры пожалуйста!")
                scan.nextLine()
            }
        }

        when (choice) {
            1 -> myArrayList.print()
            2 -> myArrayList.addValue(userValue())
            3 -> myArrayList.addIndexAndValue(userIndex(), userValue())
            4 -> myArrayList.remove(userIndex())
            5 -> myArrayList.removeValue(userValue())
            6 -> myArrayList.get(userIndex())
            7 -> return

            else -> {
                println("JAVе так спокойнее")
                continue
            }
        }
    }
}

    fun userIndex(): Int {
        println("Введите номер ячейки")

        val scan = Scanner(System.`in`)
        var n = 0
        while (true) {
            if (scan.hasNextInt()) {
                n = scan.nextInt()
                scan.nextLine()
                break
            } else {
                println("Только цифры пожалуйста!")
                scan.nextLine()
            }
        }
        return n
    }

    fun userValue(): String {
        println("Введите значение ячейки")
        val sc1 = Scanner(System.`in`)
        val str = sc1.nextLine()
        return str
    }





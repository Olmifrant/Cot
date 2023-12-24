package test.lessons.less_001

class MyArrayList {


    private val INIT_SIZE = 2
    private val CUT_RATE = 2
    private var array = arrayOfNulls<String>(INIT_SIZE)
    private var count = 0


    fun get(index: Int) {
        if (index <= count) {
            println("Ячейка " + index + " содержит значение " + array[index])
        } else {
            println("Невозможно вывести значение ячейки " + index + " поскольку текущая длина массива " + array.size)
        }
    }

    fun addIndexAndValue(index: Int, value: String?) {
        val n = array.size
        if (n < index) {
            println("Невозможно использовать ячейку $index поскольку текущая длина массива $n")
        } else {
            val newArray = arrayOfNulls<String>(n + 1)
            for (i in 0 until index) {
                newArray[i] = array[i]
            }
            newArray[index] = value
            for (i in index + 1..n) {
                newArray[i] = array[i - 1]
            }
            array = newArray
        }
    }

    fun addValue(value: String?) {
        if (count == array.size) resize(array.size * 2)
        array[count++] = value
    }

    fun print() {
        println()
        for (i in array.indices) {
            if (i == array.size - 1) {
                print(array[i])
            } else {
                print(array[i] + ", ")
            }
        }
        println()
    }

    fun remove(index: Int) {
        if (index <= array.size) {
            for (i in index until count) array[i] = array[i + 1]
            array[count] = null
            count--
            println("Значение ячейки $index успешно удалено")
            if (array.size > INIT_SIZE && count < array.size / CUT_RATE) resize(array.size / 2)
        } else {
            println("Невозможно удалить ячейку " + index + " поскольку длинны массива " + array.size)
        }
    }

    fun removeValue(value: String) {
        var z = 0

        for (i in 0 until count) {
            if (value == array[i]) {
                z = i
            }
        }

        if (z > 0) {
            for (i in z until count) array[i] = array[i + 1]
            array[count] = null
            count--
            println("Значение $value обнаружено в ячейке $z и успешно удалено")
            if (array.size > INIT_SIZE && count < array.size / CUT_RATE) resize(array.size / 2)
        } else {
            println("В массиве нет таких значений")
        }
    }


    private fun resize(newLength: Int) {
        val newArray = arrayOfNulls<String>(newLength)
        System.arraycopy(array, 0, newArray, 0, count)
        array = newArray
    }
}

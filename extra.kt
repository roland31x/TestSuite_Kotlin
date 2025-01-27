object Extra {

    fun isPrime(num: Int): Boolean {
        if (num < 2) return false
        for (i in 2..kotlin.math.sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) return false
        }
        return true
    }

    fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }

    fun lcm(a: Int, b: Int): Int = a * (b / gcd(a, b))

    fun flattenMap(map: Map<String, Any?>, prefix: String = ""): Map<String, Any?> {
        val result = mutableMapOf<String, Any?>()
        for ((k, v) in map) {
            val key = if (prefix.isEmpty()) k else "$prefix.$k"
            if (v is Map<*, *>) {
                @Suppress("UNCHECKED_CAST")
                result.putAll(flattenMap(v as Map<String, Any?>, key))
            } else {
                result[key] = v
            }
        }
        return result
    }

    fun <T> mostCommon(list: List<T>): T? {
        return list.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key
    }

    fun <T> transpose(matrix: List<List<T>>): List<List<T>> {
        if (matrix.isEmpty()) return emptyList()
        val cols = matrix[0].size
        return (0 until cols).map { col -> matrix.map { row -> row[col] } }
    }

    fun camelToSnake(str: String): String =
        str.replace(Regex("([A-Z])"), "_$1").lowercase()

    fun swapCase(str: String): String =
        str.map { if (it.isUpperCase()) it.lowercaseChar() else it.uppercaseChar() }.joinToString("")

    fun nestedSum(list: List<Any>): Int {
        var sum = 0
        for (item in list) {
            sum += when (item) {
                is List<*> -> nestedSum(item.filterNotNull())
                is Int -> item
                else -> 0
            }
        }
        return sum
    }

    fun digitSum(num: Int): Int = num.toString().filter { it.isDigit() }.sumOf { it.digitToInt() }
}
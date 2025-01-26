import kotlin.random.Random

object Extra {

    fun randomString(length: Int = 10): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        return (1..length)
            .map { chars.random() }
            .joinToString("")
    }

    fun factorial(n: Int): Long = if (n == 0) 1 else n * factorial(n - 1)

    fun isPalindrome(s: String): Boolean {
        val str = s.toLowerCase().replace(" ", "")
        return str == str.reversed()
    }

    fun <T> uniqueElements(list: List<T>): List<T> = list.distinct()

    fun <T> flattenList(nestedList: List<List<T>>): List<T> = nestedList.flatten()

    fun fibonacci(n: Int): Long {
        var a = 0L
        var b = 1L
        repeat(n) {
            val temp = a
            a = b
            b = temp + b
        }
        return a
    }

    fun countVowels(s: String): Int =
        s.count { it.lowercaseChar() in "aeiou" }

    fun <K, V> mergeMaps(vararg maps: Map<K, V>): Map<K, V> =
        maps.flatMap { it.entries }.associate { it.toPair() }

    fun reverseWords(sentence: String): String =
        sentence.split(" ").joinToString(" ") { it.reversed() }

    fun <T> chunkList(list: List<T>, chunkSize: Int): List<List<T>> =
        list.chunked(chunkSize)
}
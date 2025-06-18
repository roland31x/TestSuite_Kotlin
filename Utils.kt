package utils

import java.util.*
import kotlin.random.Random

object Utils {

    // 1. Check if string is palindrome
    fun isPalindrome_1(s: String): Boolean {
        val normalized = s.lowercase()
        return normalized == normalized.reversed()
    }

    // 2. Reverse a string
    fun reverseString_2(s: String): String = s.reversed()

    // 3. Count vowels in a string
    fun countVowels_3(s: String): Int {
        return s.count { it.lowercaseChar() in "aeiou" }
    }

    // 4. Capitalize first letter of each word
    fun toTitleCase_4(s: String): String = s.split(" ").joinToString(" ") { it.replaceFirstChar(Char::uppercaseChar) }

    // 5. Remove whitespace from string
    fun removeWhitespace_5(s: String): String = s.replace("\\s+".toRegex(), "")

    // 6. Check if array has duplicates
    fun <T> hasDuplicates_6(arr: Array<T>): Boolean = arr.size != arr.toSet().size

    // 7. Flatten a 2D array to 1D
    fun <T> flatten_7(arr: Array<Array<T>>): List<T> = arr.flatten()

    // 8. Find max value in array
    fun <T: Comparable<T>> max_8(arr: Array<T>): T = arr.maxOrNull() ?: throw IllegalArgumentException("Empty array")

    // 9. Find min value in array
    fun <T: Comparable<T>> min_9(arr: Array<T>): T = arr.minOrNull() ?: throw IllegalArgumentException("Empty array")

    // 10. Calculate average of IntArray
    fun average_10(arr: IntArray): Double = if (arr.isEmpty()) 0.0 else arr.average()

    // 11. Remove null or empty strings from array
    fun removeEmpty_11(arr: Array<String?>): List<String> = arr.filter { !it.isNullOrEmpty() }

    // 12. Repeat string n times
    fun repeatString_12(s: String, n: Int): String = s.repeat(n)

    // 13. Check if string contains only digits
    fun isNumeric_13(s: String): Boolean = s.all { it.isDigit() }

    // 14. Convert string to snake_case
    fun toSnakeCase_14(s: String): String {
        return s.fold(StringBuilder()) { acc, c ->
            when {
                c.isUpperCase() -> if (acc.isNotEmpty()) acc.append('_').append(c.lowercaseChar()) else acc.append(c.lowercaseChar())
                else -> acc.append(c)
            }
            acc
        }.toString()
    }

    // 15. Generate random int between min and max inclusive
    fun randomInt_15(min: Int, max: Int): Int = Random.nextInt(min, max + 1)

    // 16. Shuffle an array in place
    fun <T> shuffle_16(arr: Array<T>) = arr.shuffle()

    // 17. Remove duplicates from array
    fun <T> distinct_17(arr: Array<T>): List<T> = arr.distinct()

    // 18. Find index of max element
    fun <T: Comparable<T>> indexOfMax_18(arr: Array<T>): Int {
        return arr.indices.maxByOrNull { arr[it] } ?: -1
    }

    // 19. Find index of min element
    fun <T: Comparable<T>> indexOfMin_19(arr: Array<T>): Int {
        return arr.indices.minByOrNull { arr[it] } ?: -1
    }

    // 20. Convert list to CSV string
    fun <T> toCsv_20(list: List<T>): String = list.joinToString(",")

    // 21. Parse CSV string to list of strings
    fun fromCsv_21(csv: String): List<String> = csv.split(",").map { it.trim() }

    // 22. Remove duplicates from list
    fun <T> distinctList_22(list: List<T>): List<T> = list.distinct()

    // 23. Reverse a list
    fun <T> reverseList_23(list: List<T>): List<T> = list.reversed()

    // 24. Get last element or null
    fun <T> lastOrNull_24(arr: Array<T>): T? = arr.lastOrNull()

    // 25. Join strings with delimiter
    fun joinStrings_25(strings: List<String>, delimiter: String): String = strings.joinToString(delimiter)

    // 26. Check if string is null or blank
    fun isNullOrBlank_26(s: String?): Boolean = s.isNullOrBlank()

    // 27. Count words in string
    fun wordCount_27(s: String): Int = Regex("""\b\w+\b""").findAll(s).count()

    // 28. Convert seconds to HH:mm:ss
    fun secondsToTime_28(seconds: Int): String {
        val hrs = seconds / 3600
        val mins = (seconds % 3600) / 60
        val secs = seconds % 60
        return "%02d:%02d:%02d".format(hrs, mins, secs)
    }

    // 29. Generate random UUID string
    fun generateUUID_29(): String = UUID.randomUUID().toString()

    // 30. Check if string contains only letters
    fun isAlpha_30(s: String): Boolean = s.all { it.isLetter() }

    // 31. Replace multiple spaces with single space
    fun normalizeSpaces_31(s: String): String = s.trim().replace("\\s+".toRegex(), " ")

    // 32. Remove all digits from string
    fun removeDigits_32(s: String): String = s.replace("\\d".toRegex(), "")

    // 33. Substring between two strings
    fun substringBetween_33(s: String, start: String, end: String): String {
        val startIndex = s.indexOf(start)
        if (startIndex == -1) return ""
        val endIndex = s.indexOf(end, startIndex + start.length)
        if (endIndex == -1) return ""
        return s.substring(startIndex + start.length, endIndex)
    }

    // 34. Check if array contains a value
    fun <T> contains_34(arr: Array<T>, value: T): Boolean = arr.contains(value)

    // 35. Convert array to list
    fun <T> toList_35(arr: Array<T>): List<T> = arr.toList()

    // 36. Capitalize first letter of string
    fun capitalize_36(s: String): String = s.replaceFirstChar { it.uppercaseChar() }

    // 37. Check if string ends with any of given suffixes
    fun endsWithAny_37(s: String, vararg suffixes: String): Boolean = suffixes.any { s.endsWith(it) }

    // 38. Remove punctuation from string
    fun removePunctuation_38(s: String): String = s.replace("[^\\w\\s]".toRegex(), "")

    // 39. Convert string to kebab-case
    fun toKebabCase_39(s: String): String {
        return s.fold(StringBuilder()) { acc, c ->
            when {
                c.isUpperCase() -> if (acc.isNotEmpty()) acc.append('-').append(c.lowercaseChar()) else acc.append(c.lowercaseChar())
                c == ' ' || c == '_' -> acc.append('-')
                else -> acc.append(c)
            }
            acc
        }.toString()
    }

    // 40. Calculate factorial recursively
    fun factorial_40(n: Int): Long = when {
        n < 0 -> throw IllegalArgumentException("Negative numbers not allowed")
        n == 0 || n == 1 -> 1
        else -> n * factorial_40(n - 1)
    }

    // 41. Check if number is prime
    fun isPrime_41(n: Int): Boolean {
        if (n <= 1) return false
        if (n <= 3) return true
        if (n % 2 == 0 || n % 3 == 0) return false
        var i = 5
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) return false
            i += 6
        }
        return true
    }

    // 42. Convert degrees to radians
    fun degreesToRadians_42(degrees: Double): Double = degrees * Math.PI / 180.0

    // 43. Convert radians to degrees
    fun radiansToDegrees_43(radians: Double): Double = radians * 180.0 / Math.PI

    // 44. Check if string is a valid email (simple regex)
    fun isValidEmail_44(email: String): Boolean {
        val regex = "^[A-Za-z](.*)([@]{1})(.+)(\\.)(.+)"
        return email.matches(regex.toRegex())
    }

    // 45. Generate random string of length n (alphanumeric)
    fun randomString_45(n: Int): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        return (1..n)
            .map { chars.random() }
            .joinToString("")
    }

    // 46. Convert list of strings to uppercase
    fun toUpperCaseList_46(list: List<String>): List<String> = list.map { it.uppercase() }

    // 47. Find longest string in array
    fun longestString_47(arr: Array<String>): String = arr.maxByOrNull { it.length } ?: ""

    // 48. Calculate sum of IntArray
    fun sum_48(arr: IntArray): Int = arr.sum()

    // 49. Check if two lists have intersection
    fun <T> hasIntersection_49(list1: List<T>, list2: List<T>): Boolean = list1.any { it in list2 }

    // 50. Repeat a list n times
    fun <T> repeatList_50(list: List<T>, n: Int): List<T> = List(n) { list }.flatten()

    // 51. Convert list to set (remove duplicates)
    fun <T> toSet_51(list: List<T>): Set<T> = list.toSet()

    // 52. Check if string is uppercase
    fun isUpperCase_52(s: String): Boolean = s == s.uppercase()

    // 53. Check if string is lowercase
    fun isLowerCase_53(s: String): Boolean = s == s.lowercase()

    // 54. Find nth Fibonacci number (recursive)
    fun fibonacci_54(n: Int): Long = when (n) {
        0 -> 0
        1 -> 1
        else -> fibonacci_54(n - 1) + fibonacci_54(n - 2)
    }

    // 55. Check if list is sorted ascending
    fun <T: Comparable<T>> isSortedAsc_55(list: List<T>): Boolean =
        list.zipWithNext().all { it.first <= it.second }

    // 56. Check if list is sorted descending
    fun <T: Comparable<T>> isSortedDesc_56(list: List<T>): Boolean =
        list.zipWithNext().all { it.first >= it.second }

    // 57. Convert list of ints to comma separated string
    fun intListToString_57(list: List<Int>): String = list.joinToString(",")

    // 58. Parse comma separated string to list of ints
    fun stringToIntList_58(s: String): List<Int> = s.split(",").mapNotNull { it.trim().toIntOrNull() }

    // 59. Merge two sorted lists into one sorted list
    fun mergeSortedLists_59(list1: List<Int>, list2: List<Int>): List<Int> {
        val result = mutableListOf<Int>()
        var i = 0
        var j = 0
        while (i < list1.size && j < list2.size) {
            if (list1[i] < list2[j]) {
                result.add(list1[i])
                i++
            } else {
                result.add(list2[j])
                j++
            }
        }
        while (i < list1.size) {
            result.add(list1[i])
            i++
        }
        while (j < list2.size) {
            result.add(list2[j])
            j++
        }
        return result
    }

    // 60. Find all primes up to n using Sieve of Eratosthenes
    fun sievePrimes_60(n: Int): List<Int> {
        if (n < 2) return emptyList()
        val sieve = BooleanArray(n + 1) { true }
        sieve[0] = false
        sieve[1] = false
        for (i in 2..n) {
            if (sieve[i]) {
                var j = i * 2
                while (j <= n) {
                    sieve[j] = false
                    j += i
                }
            }
        }
        return sieve.mapIndexedNotNull { index, isPrime -> if (isPrime) index else null }
    }

    // 61. Count occurrences of character in string
    fun countChar_61(s: String, c: Char): Int = s.count { it == c }

    // 62. Convert Map keys to list
    fun <K, V> mapKeysToList_62(map: Map<K, V>): List<K> = map.keys.toList()

    // 63. Convert Map values to list
    fun <K, V> mapValuesToList_63(map: Map<K, V>): List<V> = map.values.toList()

    // 64. Invert a map (swap keys and values)
    fun <K, V> invertMap_64(map: Map<K, V>): Map<V, K> = map.entries.associate { (k, v) -> v to k }

    // 65. Group list by first letter
    fun groupByFirstLetter_65(list: List<String>): Map<Char, List<String>> =
        list.groupBy { it.firstOrNull() ?: ' ' }

    // 66. Find median of a list of Ints
    fun median_66(list: List<Int>): Double {
        if (list.isEmpty()) throw IllegalArgumentException("Empty list")
        val sorted = list.sorted()
        val middle = sorted.size / 2
        return if (sorted.size % 2 == 0) {
            (sorted[middle - 1] + sorted[middle]) / 2.0
        } else {
            sorted[middle].toDouble()
        }
    }

    // 67. Remove duplicates but keep order
    fun <T> distinctOrdered_67(list: List<T>): List<T> {
        val seen = mutableSetOf<T>()
        return list.filter { seen.add(it) }
    }

    // 68. Convert list of ints to binary strings
    fun toBinaryStrings_68(list: List<Int>): List<String> = list.map { it.toString(2) }

    // 69. Find factorial using loop
    fun factorialLoop_69(n: Int): Long {
        if (n < 0) throw IllegalArgumentException("Negative numbers not allowed")
        var result = 1L
        for (i in 2..n) {
            result *= i
        }
        return result
    }

    // 70. Get substring safely (handles out of bounds)
    fun safeSubstring_70(s: String, start: Int, end: Int): String {
        val safeStart = start.coerceAtLeast(0).coerceAtMost(s.length)
        val safeEnd = end.coerceAtLeast(safeStart).coerceAtMost(s.length)
        return s.substring(safeStart, safeEnd)
    }

    // 71. Find all anagrams in a list of strings (grouped)
    fun groupAnagrams_71(words: List<String>): Map<String, List<String>> =
        words.groupBy { it.lowercase().toCharArray().sorted().joinToString("") }

    // 72. Check if string is a valid IPv4 address
    fun isValidIPv4_72(ip: String): Boolean {
        val parts = ip.split(".")
        if (parts.size != 4) return false
        return parts.all {
            it.toIntOrNull()?.let { n -> n in 0..255 } ?: false
        }
    }

    // 73. Convert decimal to hex string
    fun toHex_73(n: Int): String = n.toString(16)

    // 74. Convert hex string to decimal
    fun hexToDecimal_74(hex: String): Int = hex.toInt(16)

    // 75. Remove HTML tags from string
    fun removeHtmlTags_75(s: String): String = s.replace("<[^>]*>".toRegex(), "")

    // 76. Repeat a char n times
    fun repeatChar_76(c: Char, n: Int): String = c.toString().repeat(n)

    // 77. Find longest common prefix in list of strings
    fun longestCommonPrefix_77(strings: List<String>): String {
        if (strings.isEmpty()) return ""
        var prefix = strings[0]
        for (str in strings) {
            while (!str.startsWith(prefix)) {
                prefix = prefix.dropLast(1)
                if (prefix.isEmpty()) return ""
            }
        }
        return prefix
    }

    // 78. Calculate GCD of two numbers
    fun gcd_78(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }

    // 79. Calculate LCM of two numbers
    fun lcm_79(a: Int, b: Int): Int = (a / gcd_78(a, b)) * b

    // 80. Count number of digits in an integer
    fun digitCount_80(n: Int): Int = n.toString().length

    // 81. Reverse digits of an integer
    fun reverseDigits_81(n: Int): Int {
        val reversedStr = n.toString().reversed()
        return reversedStr.toInt()
    }

    // 82. Check if list contains any null elements
    fun <T> containsNull_82(list: List<T?>): Boolean = list.any { it == null }

    // 83. Merge two maps (second overwrites first)
    fun <K, V> mergeMaps_83(map1: Map<K, V>, map2: Map<K, V>): Map<K, V> = map1 + map2

    // 84. Get keys from map where value satisfies predicate
    fun <K, V> keysWhereValue_84(map: Map<K, V>, predicate: (V) -> Boolean): List<K> =
        map.filterValues(predicate).keys.toList()

    // 85. Convert list of strings to lowercase
    fun toLowerCaseList_85(list: List<String>): List<String> = list.map { it.lowercase() }

    // 86. Remove elements from list matching predicate
    fun <T> removeWhere_86(list: MutableList<T>, predicate: (T) -> Boolean) {
        list.removeAll(predicate)
    }

    // 87. Find second largest number in list
    fun secondLargest_87(list: List<Int>): Int? {
        val distinctSorted = list.distinct().sortedDescending()
        return if (distinctSorted.size >= 2) distinctSorted[1] else null
    }

    // 88. Convert Map to List of Pairs
    fun <K, V> mapToPairs_88(map: Map<K, V>): List<Pair<K, V>> = map.toList()

    // 89. Get all substrings of a string
    fun allSubstrings_89(s: String): List<String> {
        val substrings = mutableListOf<String>()
        for (i in s.indices) {
            for (j in i + 1..s.length) {
                substrings.add(s.substring(i, j))
            }
        }
        return substrings
    }

    // 90. Check if a number is even
    fun isEven_90(n: Int): Boolean = n % 2 == 0

    // 91. Check if a number is odd
    fun isOdd_91(n: Int): Boolean = n % 2 != 0

    // 92. Convert List<Int> to IntArray
    fun toIntArray_92(list: List<Int>): IntArray = list.toIntArray()

    // 93. Count vowels and consonants in string
    fun countVowelsConsonants_93(s: String): Pair<Int, Int> {
        val vowels = "aeiou"
        val lower = s.lowercase()
        val vowelCount = lower.count { it in vowels }
        val consonantCount = lower.count { it.isLetter() && it !in vowels }
        return vowelCount to consonantCount
    }

    // 94. Remove elements at given indices from list
    fun <T> removeIndices_94(list: MutableList<T>, indices: List<Int>) {
        indices.sortedDescending().forEach {
            if (it in list.indices) list.removeAt(it)
        }
    }

    // 95. Find index of first element satisfying predicate
    fun <T> indexOfFirst_95(list: List<T>, predicate: (T) -> Boolean): Int = list.indexOfFirst(predicate)

    // 96. Find index of last element satisfying predicate
    fun <T> indexOfLast_96(list: List<T>, predicate: (T) -> Boolean): Int = list.indexOfLast(predicate)

    // 97. Remove element from list if exists
    fun <T> removeElement_97(list: MutableList<T>, element: T) {
        list.remove(element)
    }

    // 98. Count elements satisfying predicate
    fun <T> countWhere_98(list: List<T>, predicate: (T) -> Boolean): Int = list.count(predicate)

    // 99. Get first n elements of list safely
    fun <T> takeFirstN_99(list: List<T>, n: Int): List<T> = list.take(n)

    // 100. Get last n elements of list safely
    fun <T> takeLastN_100(list: List<T>, n: Int): List<T> = list.takeLast(n)

    // 101. Check if a string is a palindrome (case insensitive)
    fun isPalindrome_101(s: String): Boolean {
        val normalized = s.lowercase().filter { it.isLetterOrDigit() }
        return normalized == normalized.reversed()
    }

    // 102. Capitalize the first letter of each word in a string
    fun capitalizeWords_102(s: String): String = s.split(" ").joinToString(" ") { it.capitalize() }

    // 103. Flatten a list of lists into a single list
    fun <T> flattenList_103(listOfLists: List<List<T>>): List<T> = listOfLists.flatten()

    // 104. Find the maximum element in a list or null if empty
    fun <T: Comparable<T>> maxOrNull_104(list: List<T>): T? = list.maxOrNull()

    // 105. Find the minimum element in a list or null if empty
    fun <T: Comparable<T>> minOrNull_105(list: List<T>): T? = list.minOrNull()

    // 106. Sum all elements in a list of Int
    fun sumIntList_106(list: List<Int>): Int = list.sum()

    // 107. Sum all elements in a list of Double
    fun sumDoubleList_107(list: List<Double>): Double = list.sum()

    // 108. Count the number of words in a string
    fun wordCount_108(s: String): Int = s.trim().split("\\s+".toRegex()).size

    // 109. Reverse each word in a string but keep word order
    fun reverseWords_109(s: String): String =
        s.split(" ").joinToString(" ") { it.reversed() }

    // 110. Remove whitespace from both ends of a string
    fun trimString_110(s: String): String = s.trim()

    // 111. Generate list of first n squares
    fun generateSquares_111(n: Int): List<Int> = (1..n).map { it * it }

    // 112. Check if two lists are permutations of each other
    fun <T> arePermutations_112(list1: List<T>, list2: List<T>): Boolean =
        list1.sorted() == list2.sorted()

    // 113. Find index of max element in list
    fun <T: Comparable<T>> indexOfMax_113(list: List<T>): Int? =
        list.indices.maxByOrNull { list[it] }

    // 114. Find index of min element in list
    fun <T: Comparable<T>> indexOfMin_114(list: List<T>): Int? =
        list.indices.minByOrNull { list[it] }

    // 115. Repeat a string n times
    fun repeatString_115(s: String, n: Int): String = s.repeat(n)

    // 116. Check if list contains duplicates
    fun <T> containsDuplicates_116(list: List<T>): Boolean =
        list.size != list.toSet().size

    // 117. Find all subsets of a list (power set)
    fun <T> powerSet_117(list: List<T>): List<List<T>> {
        val powerSetSize = 1 shl list.size
        val result = mutableListOf<List<T>>()
        for (i in 0 until powerSetSize) {
            val subset = mutableListOf<T>()
            for (j in list.indices) {
                if ((i and (1 shl j)) != 0) {
                    subset.add(list[j])
                }
            }
            result.add(subset)
        }
        return result
    }

    // 118. Calculate average of a list of numbers
    fun average_118(list: List<Double>): Double =
        if (list.isEmpty()) 0.0 else list.sum() / list.size

    // 119. Remove all occurrences of a character from a string
    fun removeChar_119(s: String, c: Char): String = s.filter { it != c }

    // 120. Get list of odd numbers from a list
    fun getOddNumbers_120(list: List<Int>): List<Int> = list.filter { it % 2 != 0 }

    // 121. Get list of even numbers from a list
    fun getEvenNumbers_121(list: List<Int>): List<Int> = list.filter { it % 2 == 0 }

    // 122. Convert string to title case
    fun toTitleCase_122(s: String): String = s.split(" ").joinToString(" ") {
        it.lowercase().replaceFirstChar { ch -> ch.uppercase() }
    }

    // 123. Check if a string contains only digits
    fun isDigitsOnly_123(s: String): Boolean = s.all { it.isDigit() }

    // 124. Replace all spaces with underscores
    fun replaceSpaces_124(s: String): String = s.replace(' ', '_')

    // 125. Sort a list of strings alphabetically
    fun sortStrings_125(list: List<String>): List<String> = list.sorted()

    // 126. Find the second smallest number in a list
    fun secondSmallest_126(list: List<Int>): Int? {
        val distinctSorted = list.distinct().sorted()
        return if (distinctSorted.size >= 2) distinctSorted[1] else null
    }

    // 127. Convert List<String> to a single CSV line
    fun listToCsv_127(list: List<String>): String = list.joinToString(",")

    // 128. Convert CSV line to List<String>
    fun csvToList_128(csv: String): List<String> = csv.split(",")

    // 129. Check if all elements in a list satisfy a predicate
    fun <T> allSatisfy_129(list: List<T>, predicate: (T) -> Boolean): Boolean =
        list.all(predicate)

    // 130. Check if any element in a list satisfies a predicate
    fun <T> anySatisfy_130(list: List<T>, predicate: (T) -> Boolean): Boolean =
        list.any(predicate)

    // 131. Get list of indexes where predicate is true
    fun <T> indexesWhere_131(list: List<T>, predicate: (T) -> Boolean): List<Int> =
        list.mapIndexedNotNull { index, value -> if (predicate(value)) index else null }

    // 132. Convert list of strings to uppercase
    fun toUpperCaseList_132(list: List<String>): List<String> = list.map { it.uppercase() }

    // 133. Remove duplicates from list of strings ignoring case
    fun distinctIgnoreCase_133(list: List<String>): List<String> {
        val seen = mutableSetOf<String>()
        return list.filter {
            val lower = it.lowercase()
            if (lower in seen) false else {
                seen.add(lower)
                true
            }
        }
    }

    // 134. Check if a string contains another string (case insensitive)
    fun containsIgnoreCase_134(s: String, sub: String): Boolean =
        s.lowercase().contains(sub.lowercase())

    // 135. Shuffle a list randomly
    fun <T> shuffleList_135(list: List<T>): List<T> = list.shuffled()

    // 136. Get first element or null if empty
    fun <T> firstOrNull_136(list: List<T>): T? = list.firstOrNull()

    // 137. Get last element or null if empty
    fun <T> lastOrNull_137(list: List<T>): T? = list.lastOrNull()

    // 138. Check if a number is a perfect square
    fun isPerfectSquare_138(n: Int): Boolean {
        val root = kotlin.math.sqrt(n.toDouble()).toInt()
        return root * root == n
    }

    // 139. Find the length of the longest word in a list of strings
    fun longestWordLength_139(list: List<String>): Int =
        list.maxOfOrNull { it.length } ?: 0

    // 140. Convert list of doubles to list of rounded integers
    fun roundDoubles_140(list: List<Double>): List<Int> = list.map { it.roundToInt() }

    // 141. Calculate the product of all elements in a list
    fun product_141(list: List<Int>): Int = list.fold(1) { acc, i -> acc * i }

    // 142. Get list of unique characters in a string
    fun uniqueChars_142(s: String): Set<Char> = s.toSet()

    // 143. Repeat a list n times
    fun <T> repeatList_143(list: List<T>, n: Int): List<T> = List(n) { list }.flatten()

    // 144. Get elements at even indices
    fun <T> evenIndexElements_144(list: List<T>): List<T> =
        list.filterIndexed { index, _ -> index % 2 == 0 }

    // 145. Get elements at odd indices
    fun <T> oddIndexElements_145(list: List<T>): List<T> =
        list.filterIndexed { index, _ -> index % 2 != 0 }

    // 146. Check if two strings are anagrams (case insensitive)
    fun areAnagrams_146(s1: String, s2: String): Boolean =
        s1.lowercase().toCharArray().sorted() == s2.lowercase().toCharArray().sorted()

    // 147. Get list of primes in a range (simple check)
    fun primesInRange_147(start: Int, end: Int): List<Int> {
        fun isPrime(n: Int): Boolean {
            if (n < 2) return false
            for (i in 2..kotlin.math.sqrt(n.toDouble()).toInt()) {
                if (n % i == 0) return false
            }
            return true
        }
        return (start..end).filter { isPrime(it) }
    }

    // 148. Find longest string in a list
    fun longestString_148(list: List<String>): String? = list.maxByOrNull { it.length }

    // 149. Replace multiple spaces with single space
    fun normalizeSpaces_149(s: String): String = s.replace("\\s+".toRegex(), " ")

    // 150. Convert seconds to hh:mm:ss format
    fun secondsToHMS_150(seconds: Int): String {
        val h = seconds / 3600
        val m = (seconds % 3600) / 60
        val s = seconds % 60
        return "%02d:%02d:%02d".format(h, m, s)
    }
}


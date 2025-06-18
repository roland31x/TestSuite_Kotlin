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

    // 151. Convert a list of strings to a map of string length -> list of strings with that length
    fun groupByLength_151(list: List<String>): Map<Int, List<String>> =
        list.groupBy { it.length }

    // 152. Find the mode (most frequent element) in a list
    fun <T> mode_152(list: List<T>): T? =
        list.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key

    // 153. Check if a string is a valid email (simple regex)
    fun isValidEmail_153(email: String): Boolean =
        Regex("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$").matches(email)

    // 154. Merge two sorted lists into one sorted list
    fun mergeSorted_154(list1: List<Int>, list2: List<Int>): List<Int> {
        val result = mutableListOf<Int>()
        var i = 0
        var j = 0
        while (i < list1.size && j < list2.size) {
            if (list1[i] <= list2[j]) {
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

    // 155. Flatten a map of lists to a list of pairs (key, value)
    fun <K, V> flattenMap_155(map: Map<K, List<V>>): List<Pair<K, V>> =
        map.flatMap { (k, vs) -> vs.map { v -> k to v } }

    // 156. Calculate factorial of n (recursive)
    fun factorial_156(n: Int): Long = when {
        n < 0 -> throw IllegalArgumentException("Negative number")
        n == 0 -> 1
        else -> n * factorial_156(n - 1)
    }

    // 157. Check if a list is sorted ascending
    fun <T: Comparable<T>> isSortedAscending_157(list: List<T>): Boolean =
        list.zipWithNext().all { it.first <= it.second }

    // 158. Check if a list is sorted descending
    fun <T: Comparable<T>> isSortedDescending_158(list: List<T>): Boolean =
        list.zipWithNext().all { it.first >= it.second }

    // 159. Find the longest common prefix of a list of strings
    fun longestCommonPrefix_159(list: List<String>): String {
        if (list.isEmpty()) return ""
        val shortest = list.minByOrNull { it.length } ?: ""
        for (i in shortest.indices) {
            val c = shortest[i]
            if (list.any { it[i] != c }) return shortest.substring(0, i)
        }
        return shortest
    }

    // 160. Convert camelCase string to snake_case
    fun camelToSnake_160(s: String): String =
        s.replace(Regex("([a-z])([A-Z])"), "$1_$2").lowercase()

    // 161. Convert snake_case string to camelCase
    fun snakeToCamel_161(s: String): String {
        val parts = s.split('_')
        return parts.first() + parts.drop(1).joinToString("") { it.capitalize() }
    }

    // 162. Compute the nth Fibonacci number (iterative)
    fun fibonacci_162(n: Int): Long {
        if (n < 0) throw IllegalArgumentException("Negative index")
        var a = 0L
        var b = 1L
        for (i in 0 until n) {
            val tmp = a
            a = b
            b += tmp
        }
        return a
    }

    // 163. Remove duplicate characters from a string keeping order
    fun removeDuplicateChars_163(s: String): String {
        val seen = mutableSetOf<Char>()
        val result = StringBuilder()
        for (c in s) {
            if (c !in seen) {
                seen.add(c)
                result.append(c)
            }
        }
        return result.toString()
    }

    // 164. Convert a list of integers to a hex string (e.g. [255, 0] -> "FF00")
    fun intListToHex_164(list: List<Int>): String =
        list.joinToString("") { it.toString(16).padStart(2, '0').uppercase() }

    // 165. Convert hex string to list of integers (e.g. "FF00" -> [255, 0])
    fun hexToIntList_165(hex: String): List<Int> {
        val cleaned = hex.trim()
        require(cleaned.length % 2 == 0) { "Hex string length must be even" }
        return (0 until cleaned.length step 2).map {
            cleaned.substring(it, it + 2).toInt(16)
        }
    }

    // 166. Calculate the Euclidean distance between two points
    fun euclideanDistance_166(x1: Double, y1: Double, x2: Double, y2: Double): Double =
        kotlin.math.sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))

    // 167. Calculate n choose k (binomial coefficient)
    fun nChooseK_167(n: Int, k: Int): Long {
        if (k < 0 || k > n) return 0
        var result = 1L
        for (i in 1..k) {
            result = result * (n - i + 1) / i
        }
        return result
    }

    // 168. Generate all permutations of a list (recursive)
    fun <T> permutations_168(list: List<T>): List<List<T>> {
        if (list.isEmpty()) return listOf(emptyList())
        val result = mutableListOf<List<T>>()
        for (i in list.indices) {
            val element = list[i]
            val rest = list.take(i) + list.drop(i + 1)
            for (perm in permutations_168(rest)) {
                result.add(listOf(element) + perm)
            }
        }
        return result
    }

    // 169. Check if a string contains only alphabetic letters
    fun isAlphabetic_169(s: String): Boolean = s.all { it.isLetter() }

    // 170. Convert a string to Pig Latin (simple version)
    fun toPigLatin_170(word: String): String {
        val vowels = "aeiouAEIOU"
        if (word.isEmpty()) return word
        return if (vowels.contains(word[0])) {
            word + "way"
        } else {
            val firstVowelIndex = word.indexOfFirst { vowels.contains(it) }
            if (firstVowelIndex == -1) word + "ay"
            else word.substring(firstVowelIndex) + word.substring(0, firstVowelIndex) + "ay"
        }
    }

    // 171. Reverse a list recursively
    fun <T> reverseList_171(list: List<T>): List<T> =
        if (list.isEmpty()) list else reverseList_171(list.drop(1)) + list.first()

    // 172. Check if a number is even
    fun isEven_172(n: Int): Boolean = n % 2 == 0

    // 173. Check if a number is odd
    fun isOdd_173(n: Int): Boolean = n % 2 != 0

    // 174. Generate a random alphanumeric string of given length
    fun randomAlphaNumeric_174(length: Int): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        return (1..length).map { chars.random() }.joinToString("")
    }

    // 175. Calculate the sum of digits in an integer
    fun sumOfDigits_175(n: Int): Int {
        var num = kotlin.math.abs(n)
        var sum = 0
        while (num > 0) {
            sum += num % 10
            num /= 10
        }
        return sum
    }

    // 176. Find the GCD of two numbers using Euclid's algorithm
    fun gcd_176(a: Int, b: Int): Int {
        var x = kotlin.math.abs(a)
        var y = kotlin.math.abs(b)
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }

    // 177. Find the LCM of two numbers
    fun lcm_177(a: Int, b: Int): Int {
        if (a == 0 || b == 0) return 0
        return kotlin.math.abs(a / gcd_176(a, b) * b)
    }

    // 178. Get initials from full name string (e.g. "John Doe" -> "J.D.")
    fun getInitials_178(fullName: String): String =
        fullName.split(" ").filter { it.isNotEmpty() }.map { it[0].uppercaseChar() }.joinToString(".") + "."

    // 179. Check if a year is a leap year
    fun isLeapYear_179(year: Int): Boolean =
        (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)

    // 180. Convert list of strings to a map of string -> length
    fun stringLengthMap_180(list: List<String>): Map<String, Int> =
        list.associateWith { it.length }

    // 181. Check if a list is a palindrome
    fun <T> isPalindromeList_181(list: List<T>): Boolean =
        list == list.reversed()

    // 182. Get frequency map of characters in a string
    fun charFrequency_182(s: String): Map<Char, Int> =
        s.groupingBy { it }.eachCount()

    // 183. Check if two strings are rotations of each other
    fun areRotations_183(s1: String, s2: String): Boolean =
        s1.length == s2.length && (s1 + s1).contains(s2)

    // 184. Convert integer to binary string
    fun intToBinary_184(n: Int): String = Integer.toBinaryString(n)

    // 185. Convert binary string to integer
    fun binaryToInt_185(bin: String): Int = Integer.parseInt(bin, 2)

    // 186. Capitalize only the first letter of a string
    fun capitalizeFirst_186(s: String): String =
        s.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }

    // 187. Find all indices of a character in a string
    fun indicesOfChar_187(s: String, c: Char): List<Int> =
        s.mapIndexedNotNull { idx, ch -> if (ch == c) idx else null }

    // 188. Convert list of strings to lowercase
    fun toLowerCaseList_188(list: List<String>): List<String> = list.map { it.lowercase() }

    // 189. Calculate the sum of squares of numbers in a list
    fun sumOfSquares_189(list: List<Int>): Int = list.sumOf { it * it }

    // 190. Find median of a sorted list
    fun medianSorted_190(list: List<Double>): Double? {
        if (list.isEmpty()) return null
        val mid = list.size / 2
        return if (list.size % 2 == 1) list[mid] else (list[mid - 1] + list[mid]) / 2
    }

    // 191. Calculate standard deviation of a list of numbers
    fun standardDeviation_191(list: List<Double>): Double {
        if (list.isEmpty()) return 0.0
        val mean = list.average()
        val variance = list.sumOf { (it - mean) * (it - mean) } / list.size
        return kotlin.math.sqrt(variance)
    }

    // 192. Convert list of Int to comma separated string
    fun intListToCSV_192(list: List<Int>): String = list.joinToString(",")

    // 193. Convert CSV string to list of Int
    fun csvToIntList_193(csv: String): List<Int> =
        csv.split(",").mapNotNull { it.trim().toIntOrNull() }

    // 194. Repeat a character n times as a string
    fun repeatChar_194(c: Char, n: Int): String = c.toString().repeat(n)

    // 195. Check if a number is prime (naive)
    fun isPrime_195(n: Int): Boolean {
        if (n < 2) return false
        for (i in 2..kotlin.math.sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) return false
        }
        return true
    }

    // 196. Convert List of Boolean to Int (treat true as 1, false as 0)
    fun booleanListToInt_196(list: List<Boolean>): Int {
        var result = 0
        for (b in list) {
            result = (result shl 1) or if (b) 1 else 0
        }
        return result
    }

    // 197. Convert Int to List of Boolean (bits)
    fun intToBooleanList_197(n: Int, size: Int): List<Boolean> {
        val list = mutableListOf<Boolean>()
        for (i in size - 1 downTo 0) {
            list.add(n and (1 shl i) != 0)
        }
        return list
    }

    // 198. Replace vowels in a string with a given character
    fun replaceVowels_198(s: String, replacement: Char): String {
        val vowels = "aeiouAEIOU"
        return s.map { if (vowels.contains(it)) replacement else it }.joinToString("")
    }

    // 199. Convert a list of pairs to a map
    fun <K, V> pairsToMap_199(pairs: List<Pair<K, V>>): Map<K, V> =
        pairs.toMap()

    // 200. Remove all punctuation from a string
    fun removePunctuation_200(s: String): String =
        s.filter { it.isLetterOrDigit() || it.isWhitespace() }

    // 201. Calculate the dot product of two vectors
    fun dotProduct_201(vec1: List<Double>, vec2: List<Double>): Double {
        require(vec1.size == vec2.size) { "Vectors must be of same size" }
        return vec1.indices.sumOf { vec1[it] * vec2[it] }
    }

    // 202. Calculate the cross product of two 3D vectors
    fun crossProduct_202(a: List<Double>, b: List<Double>): List<Double> {
        require(a.size == 3 && b.size == 3) { "Both vectors must be 3D" }
        return listOf(
            a[1] * b[2] - a[2] * b[1],
            a[2] * b[0] - a[0] * b[2],
            a[0] * b[1] - a[1] * b[0]
        )
    }

    // 203. Normalize a vector
    fun normalize_203(vec: List<Double>): List<Double> {
        val length = sqrt(vec.sumOf { it * it })
        require(length != 0.0) { "Zero vector cannot be normalized" }
        return vec.map { it / length }
    }

    // 204. Generate a random integer between min and max (inclusive)
    fun randomInt_204(min: Int, max: Int): Int = (min..max).random()

    // 205. Generate a random double between min and max
    fun randomDouble_205(min: Double, max: Double): Double = min + Math.random() * (max - min)

    // 206. Find the second largest element in a list of Ints
    fun secondLargest_206(list: List<Int>): Int? {
        if (list.size < 2) return null
        val sorted = list.distinct().sortedDescending()
        return if (sorted.size >= 2) sorted[1] else null
    }

    // 207. Convert Celsius to Fahrenheit
    fun celsiusToFahrenheit_207(c: Double): Double = c * 9 / 5 + 32

    // 208. Convert Fahrenheit to Celsius
    fun fahrenheitToCelsius_208(f: Double): Double = (f - 32) * 5 / 9

    // 209. Get the extension of a filename
    fun getFileExtension_209(filename: String): String =
        filename.substringAfterLast('.', "")

    // 210. Check if a list contains duplicates
    fun <T> hasDuplicates_210(list: List<T>): Boolean =
        list.size != list.toSet().size

    // 211. Find indices of all even numbers in a list
    fun indicesOfEven_211(list: List<Int>): List<Int> =
        list.mapIndexedNotNull { index, value -> if (value % 2 == 0) index else null }

    // 212. Generate all subsets of a set
    fun <T> allSubsets_212(set: List<T>): List<List<T>> {
        val subsets = mutableListOf<List<T>>()
        val n = set.size
        for (i in 0 until (1 shl n)) {
            val subset = mutableListOf<T>()
            for (j in 0 until n) {
                if ((i and (1 shl j)) != 0) subset.add(set[j])
            }
            subsets.add(subset)
        }
        return subsets
    }

    // 213. Flatten a nested list of lists into a single list
    fun <T> flatten_213(nested: List<List<T>>): List<T> = nested.flatten()

    // 214. Swap two elements in a mutable list by their indices
    fun <T> swap_214(list: MutableList<T>, i: Int, j: Int) {
        require(i in list.indices && j in list.indices) { "Index out of bounds" }
        val temp = list[i]
        list[i] = list[j]
        list[j] = temp
    }

    // 215. Calculate the product of all elements in a list
    fun product_215(list: List<Int>): Long = list.fold(1L) { acc, i -> acc * i }

    // 216. Find the longest string in a list
    fun longestString_216(list: List<String>): String? = list.maxByOrNull { it.length }

    // 217. Check if a string is a palindrome ignoring case and non-alphanumeric
    fun isPalindromeIgnoreCase_217(s: String): Boolean {
        val filtered = s.filter { it.isLetterOrDigit() }.lowercase()
        return filtered == filtered.reversed()
    }

    // 218. Count vowels in a string
    fun countVowels_218(s: String): Int {
        val vowels = "aeiouAEIOU"
        return s.count { vowels.contains(it) }
    }

    // 219. Generate a list of prime numbers up to n using sieve of Eratosthenes
    fun primesUpTo_219(n: Int): List<Int> {
        if (n < 2) return emptyList()
        val sieve = BooleanArray(n + 1) { true }
        sieve[0] = false
        sieve[1] = false
        for (i in 2..sqrt(n.toDouble()).toInt()) {
            if (sieve[i]) {
                for (j in i * i..n step i) {
                    sieve[j] = false
                }
            }
        }
        return sieve.indices.filter { sieve[it] }
    }

    // 220. Check if all elements in a list satisfy a predicate
    fun <T> allSatisfy_220(list: List<T>, predicate: (T) -> Boolean): Boolean =
        list.all(predicate)

    // 221. Check if any element in a list satisfies a predicate
    fun <T> anySatisfy_221(list: List<T>, predicate: (T) -> Boolean): Boolean =
        list.any(predicate)

    // 222. Remove all null elements from a list
    fun <T> removeNulls_222(list: List<T?>): List<T> = list.filterNotNull()

    // 223. Rotate a list to the right by n steps
    fun <T> rotateRight_223(list: List<T>, n: Int): List<T> {
        val size = list.size
        if (size == 0) return list
        val steps = n % size
        return list.takeLast(steps) + list.dropLast(steps)
    }

    // 224. Rotate a list to the left by n steps
    fun <T> rotateLeft_224(list: List<T>, n: Int): List<T> {
        val size = list.size
        if (size == 0) return list
        val steps = n % size
        return list.drop(steps) + list.take(steps)
    }

    // 225. Capitalize every word in a string
    fun capitalizeWords_225(s: String): String =
        s.split(" ").joinToString(" ") { it.replaceFirstChar { ch -> ch.uppercase() } }

    // 226. Calculate the sum of ASCII values of characters in a string
    fun asciiSum_226(s: String): Int = s.sumOf { it.code }

    // 227. Count the number of words in a string
    fun wordCount_227(s: String): Int = s.trim().split(Regex("\\s+")).size

    // 228. Check if a list contains a sublist
    fun <T> containsSublist_228(list: List<T>, sublist: List<T>): Boolean {
        if (sublist.isEmpty()) return true
        for (i in 0..list.size - sublist.size) {
            if (list.subList(i, i + sublist.size) == sublist) return true
        }
        return false
    }

    // 229. Create a map from a list by grouping by a keySelector and counting occurrences
    fun <T, K> groupCount_229(list: List<T>, keySelector: (T) -> K): Map<K, Int> =
        list.groupingBy(keySelector).eachCount()

    // 230. Reverse words in a sentence
    fun reverseWords_230(s: String): String =
        s.split(" ").reversed().joinToString(" ")

    // 231. Calculate the sum of odd numbers in a list
    fun sumOdd_231(list: List<Int>): Int = list.filter { it % 2 != 0 }.sum()

    // 232. Generate a list of factorials from 0 to n
    fun factorialList_232(n: Int): List<Long> {
        require(n >= 0) { "n must be non-negative" }
        val result = mutableListOf(1L)
        for (i in 1..n) {
            result.add(result.last() * i)
        }
        return result
    }

    // 233. Check if a string contains only digits
    fun isNumeric_233(s: String): Boolean = s.all { it.isDigit() }

    // 234. Replace all occurrences of a substring with another substring
    fun replaceAll_234(s: String, old: String, new: String): String = s.replace(old, new)

    // 235. Extract numbers from a string as list of Ints
    fun extractNumbers_235(s: String): List<Int> =
        Regex("\\d+").findAll(s).map { it.value.toInt() }.toList()

    // 236. Find the longest increasing subsequence length (O(n^2) naive)
    fun longestIncreasingSubsequenceLength_236(arr: List<Int>): Int {
        val n = arr.size
        if (n == 0) return 0
        val dp = IntArray(n) { 1 }
        for (i in 1 until n) {
            for (j in 0 until i) {
                if (arr[i] > arr[j]) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }
        return dp.maxOrNull() ?: 1
    }

    // 237. Find the element with maximum frequency in a list
    fun <T> maxFrequencyElement_237(list: List<T>): T? =
        list.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key

    // 238. Convert a map to a query string
    fun mapToQueryString_238(map: Map<String, String>): String =
        map.entries.joinToString("&") { "${it.key}=${it.value}" }

    // 239. Check if two lists are equal ignoring order
    fun <T> listsEqualIgnoreOrder_239(list1: List<T>, list2: List<T>): Boolean =
        list1.groupingBy { it }.eachCount() == list2.groupingBy { it }.eachCount()

    // 240. Count the number of uppercase letters in a string
    fun countUppercase_240(s: String): Int = s.count { it.isUpperCase() }

    // 241. Compute the power of a number with integer exponent (iterative)
    fun powInt_241(base: Double, exp: Int): Double {
        var result = 1.0
        var e = kotlin.math.abs(exp)
        var b = base
        while (e > 0) {
            if (e and 1 == 1) result *= b
            b *= b
            e = e shr 1
        }
        return if (exp < 0) 1 / result else result
    }

    // 242. Check if a string is a valid IPv4 address
    fun isValidIPv4_242(ip: String): Boolean {
        val parts = ip.split(".")
        if (parts.size != 4) return false
        return parts.all {
            it.toIntOrNull()?.let { num -> num in 0..255 } ?: false
        }
    }

    // 243. Calculate the Manhattan distance between two points
    fun manhattanDistance_243(x1: Int, y1: Int, x2: Int, y2: Int): Int =
        abs(x1 - x2) + abs(y1 - y2)

    // 244. Merge two sorted lists into a single sorted list
    fun <T : Comparable<T>> mergeSorted_244(list1: List<T>, list2: List<T>): List<T> {
        val result = mutableListOf<T>()
        var i = 0
        var j = 0
        while (i < list1.size && j < list2.size) {
            if (list1[i] <= list2[j]) {
                result.add(list1[i++])
            } else {
                result.add(list2[j++])
            }
        }
        while (i < list1.size) result.add(list1[i++])
        while (j < list2.size) result.add(list2[j++])
        return result
    }

    // 245. Count occurrences of a character in a string
    fun countChar_245(s: String, ch: Char): Int =
        s.count { it == ch }

    // 246. Check if a list is sorted ascending
    fun <T : Comparable<T>> isSorted_246(list: List<T>): Boolean =
        list.zipWithNext().all { it.first <= it.second }

    // 247. Remove all occurrences of an element from a list
    fun <T> removeAllOccurrences_247(list: List<T>, element: T): List<T> =
        list.filter { it != element }

    // 248. Generate Fibonacci sequence up to n elements
    fun fibonacci_248(n: Int): List<Long> {
        require(n >= 0) { "n must be non-negative" }
        val fibs = mutableListOf<Long>()
        var a = 0L
        var b = 1L
        repeat(n) {
            fibs.add(a)
            val tmp = a + b
            a = b
            b = tmp
        }
        return fibs
    }

    // 249. Get the most frequent character in a string
    fun mostFrequentChar_249(s: String): Char? =
        s.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key

    // 250. Swap two variables without a temporary variable (ints)
    fun swapInts_250(a: Int, b: Int): Pair<Int, Int> {
        var x = a
        var y = b
        x = x + y
        y = x - y
        x = x - y
        return Pair(x, y)
    }

    // 251. Check if a number is prime (simple method)
    fun isPrime_251(n: Int): Boolean {
        if (n < 2) return false
        for (i in 2..kotlin.math.sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) return false
        }
        return true
    }

    // 252. Compute GCD (Greatest Common Divisor) using Euclidean algorithm
    fun gcd_252(a: Int, b: Int): Int {
        var x = abs(a)
        var y = abs(b)
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }

    // 253. Compute LCM (Least Common Multiple)
    fun lcm_253(a: Int, b: Int): Int =
        abs(a * b) / gcd_252(a, b)

    // 254. Reverse a list
    fun <T> reverseList_254(list: List<T>): List<T> = list.reversed()

    // 255. Convert a string to title case
    fun toTitleCase_255(s: String): String =
        s.split(" ").joinToString(" ") { it.replaceFirstChar { c -> c.uppercase() } }

    // 256. Find the maximum element in a list
    fun <T : Comparable<T>> maxElement_256(list: List<T>): T? =
        list.maxOrNull()

    // 257. Find the minimum element in a list
    fun <T : Comparable<T>> minElement_257(list: List<T>): T? =
        list.minOrNull()

    // 258. Remove duplicates from a list preserving order
    fun <T> removeDuplicates_258(list: List<T>): List<T> {
        val seen = mutableSetOf<T>()
        val result = mutableListOf<T>()
        for (item in list) {
            if (seen.add(item)) result.add(item)
        }
        return result
    }

    // 259. Check if a list is a palindrome
    fun <T> isPalindrome_259(list: List<T>): Boolean =
        list == list.reversed()

    // 260. Calculate factorial recursively
    fun factorial_260(n: Int): Long {
        require(n >= 0) { "n must be non-negative" }
        return if (n == 0) 1 else n * factorial_260(n - 1)
    }

    // 261. Merge two maps, summing values if keys collide
    fun mergeMapsSum_261(map1: Map<String, Int>, map2: Map<String, Int>): Map<String, Int> {
        val result = map1.toMutableMap()
        for ((k, v) in map2) {
            result[k] = result.getOrDefault(k, 0) + v
        }
        return result
    }

    // 262. Count words in a string using regex
    fun wordCountRegex_262(s: String): Int =
        Regex("\\b\\w+\\b").findAll(s).count()

    // 263. Get the longest word in a string
    fun longestWord_263(s: String): String? =
        s.split(Regex("\\W+")).maxByOrNull { it.length }

    // 264. Check if a string contains only alphabetic characters
    fun isAlpha_264(s: String): Boolean =
        s.all { it.isLetter() }

    // 265. Flatten a list of nullable elements, removing nulls
    fun <T> flattenNonNull_265(list: List<T?>): List<T> =
        list.filterNotNull()

    // 266. Generate a list of even numbers up to n
    fun evensUpTo_266(n: Int): List<Int> =
        (0..n).filter { it % 2 == 0 }

    // 267. Find the sum of squares of a list
    fun sumSquares_267(list: List<Int>): Int =
        list.sumOf { it * it }

    // 268. Convert list of integers to a comma-separated string
    fun intListToCSV_268(list: List<Int>): String =
        list.joinToString(",")

    // 269. Convert CSV string to list of integers
    fun csvToIntList_269(csv: String): List<Int> =
        csv.split(",").mapNotNull { it.trim().toIntOrNull() }

    // 270. Capitalize first character of a string
    fun capitalizeFirst_270(s: String): String =
        s.replaceFirstChar { it.uppercase() }

    // 271. Check if a list contains an element
    fun <T> containsElement_271(list: List<T>, element: T): Boolean =
        list.contains(element)

    // 272. Count frequency of each character in a string
    fun charFrequency_272(s: String): Map<Char, Int> =
        s.groupingBy { it }.eachCount()

    // 273. Find index of the first occurrence of a character in string or -1 if none
    fun indexOfChar_273(s: String, c: Char): Int =
        s.indexOf(c)

    // 274. Convert a string to snake_case
    fun toSnakeCase_274(s: String): String =
        s.trim().replace(Regex("\\s+"), "_").lowercase()

    // 275. Convert a string to camelCase
    fun toCamelCase_275(s: String): String {
        val parts = s.trim().split(Regex("\\s+"))
        return parts.firstOrNull()?.lowercase() + parts.drop(1).joinToString("") { it.capitalize() }
    }

    // 276. Remove all whitespace from a string
    fun removeWhitespace_276(s: String): String =
        s.replace("\\s".toRegex(), "")

    // 277. Check if two strings are anagrams
    fun areAnagrams_277(s1: String, s2: String): Boolean =
        s1.lowercase().toList().sorted() == s2.lowercase().toList().sorted()

    // 278. Convert a list of strings to uppercase
    fun toUpperCaseList_278(list: List<String>): List<String> =
        list.map { it.uppercase() }

    // 279. Find max element in list of nullable Ints ignoring nulls
    fun maxIgnoreNulls_279(list: List<Int?>): Int? =
        list.filterNotNull().maxOrNull()

    // 280. Calculate sum of digits in an integer
    fun sumDigits_280(n: Int): Int {
        var num = kotlin.math.abs(n)
        var sum = 0
        while (num > 0) {
            sum += num % 10
            num /= 10
        }
        return sum
    }

    // 281. Count number of vowels in a string
    fun countVowels_281(s: String): Int {
        val vowels = "aeiouAEIOU"
        return s.count { vowels.contains(it) }
    }

    // 282. Remove duplicate characters from string preserving order
    fun removeDuplicateChars_282(s: String): String {
        val seen = mutableSetOf<Char>()
        val sb = StringBuilder()
        for (c in s) {
            if (c !in seen) {
                seen.add(c)
                sb.append(c)
            }
        }
        return sb.toString()
    }

    // 283. Reverse words in a sentence
    fun reverseWords_283(s: String): String =
        s.split(" ").reversed().joinToString(" ")

    // 284. Calculate sum of all even numbers in a list
    fun sumEven_284(list: List<Int>): Int =
        list.filter { it % 2 == 0 }.sum()

    // 285. Generate a list of squares from 1 to n
    fun squaresUpTo_285(n: Int): List<Int> =
        (1..n).map { it * it }

    // 286. Check if a string contains only digits
    fun isDigitsOnly_286(s: String): Boolean =
        s.all { it.isDigit() }

    // 287. Convert a map to JSON-like string (simple)
    fun mapToJson_287(map: Map<String, String>): String =
        map.entries.joinToString(prefix = "{", postfix = "}") { "\"${it.key}\":\"${it.value}\"" }

    // 288. Extract digits from a string as list of Ints
    fun extractDigits_288(s: String): List<Int> =
        s.filter { it.isDigit() }.map { it.toString().toInt() }

    // 289. Calculate average of a list of numbers
    fun average_289(list: List<Double>): Double =
        if (list.isEmpty()) 0.0 else list.sum() / list.size

    // 290. Find second smallest element in a list
    fun secondSmallest_290(list: List<Int>): Int? {
        val distinctSorted = list.distinct().sorted()
        return if (distinctSorted.size >= 2) distinctSorted[1] else null
    }

    // 291. Remove elements at even indices from list
    fun <T> removeEvenIndices_291(list: List<T>): List<T> =
        list.filterIndexed { index, _ -> index % 2 != 0 }

    // 292. Generate a list of multiples of a number up to limit
    fun multiplesUpTo_292(num: Int, limit: Int): List<Int> =
        (1..limit).map { it * num }.filter { it <= limit }

    // 293. Find longest common prefix of two strings
    fun longestCommonPrefix_293(s1: String, s2: String): String {
        val minLength = minOf(s1.length, s2.length)
        for (i in 0 until minLength) {
            if (s1[i] != s2[i]) return s1.substring(0, i)
        }
        return s1.substring(0, minLength)
    }

    // 294. Remove punctuation from a string
    fun removePunctuation_294(s: String): String =
        s.filter { it.isLetterOrDigit() || it.isWhitespace() }

    // 295. Check if a string is lowercase
    fun isLowerCase_295(s: String): Boolean =
        s.all { !it.isLetter() || it.isLowerCase() }

    // 296. Calculate sum of positive numbers in a list
    fun sumPositive_296(list: List<Int>): Int =
        list.filter { it > 0 }.sum()

    // 297. Get distinct characters from a string
    fun distinctChars_297(s: String): Set<Char> =
        s.toSet()

    // 298. Repeat a string n times
    fun repeatString_298(s: String, n: Int): String =
        s.repeat(n)

    // 299. Count the number of uppercase letters in a string
    fun countUppercase_299(s: String): Int =
        s.count { it.isUpperCase() }

    // 300. Find indices of all vowels in a string
    fun vowelIndices_300(s: String): List<Int> {
        val vowels = "aeiouAEIOU"
        return s.mapIndexedNotNull { index, c -> if (vowels.contains(c)) index else null }
    }

    // 301. Convert a list of strings to lowercase
    fun toLowerCaseList_301(list: List<String>): List<String> =
        list.map { it.lowercase() }

    // 302. Calculate sum of all odd numbers in a list
    fun sumOdd_302(list: List<Int>): Int =
        list.filter { it % 2 != 0 }.sum()

    // 303. Find the shortest word in a string
    fun shortestWord_303(s: String): String? =
        s.split(Regex("\\W+")).minByOrNull { it.length }

    // 304. Check if a string contains any digits
    fun containsDigit_304(s: String): Boolean =
        s.any { it.isDigit() }

    // 305. Remove all vowels from a string
    fun removeVowels_305(s: String): String {
        val vowels = "aeiouAEIOU"
        return s.filter { it !in vowels }
    }

    // 306. Generate a list of factorials up to n
    fun factorialList_306(n: Int): List<Long> {
        require(n >= 0)
        val list = mutableListOf<Long>(1)
        for (i in 1..n) {
            list.add(list.last() * i)
        }
        return list
    }

    // 307. Count number of words starting with a specific character
    fun countWordsStartingWith_307(s: String, ch: Char): Int =
        s.split(Regex("\\W+")).count { it.startsWith(ch, ignoreCase = true) }

    // 308. Check if two lists have any common elements
    fun <T> haveCommonElements_308(list1: List<T>, list2: List<T>): Boolean =
        list1.any { it in list2 }

    // 309. Find the longest string in a list
    fun longestString_309(list: List<String>): String? =
        list.maxByOrNull { it.length }

    // 310. Check if string is a valid email (basic)
    fun isValidEmail_310(s: String): Boolean =
        Regex("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$").matches(s)

    // 311. Remove trailing whitespace from each line in a multiline string
    fun trimTrailingWhitespace_311(s: String): String =
        s.lines().joinToString("\n") { it.trimEnd() }

    // 312. Repeat each character in a string n times
    fun repeatChars_312(s: String, n: Int): String =
        s.flatMap { List(n) { it } }.joinToString("")

    // 313. Check if string contains only hexadecimal characters
    fun isHex_313(s: String): Boolean =
        s.matches(Regex("^[0-9a-fA-F]+$"))

    // 314. Count the number of words in a string
    fun countWords_314(s: String): Int =
        s.split(Regex("\\W+")).filter { it.isNotBlank() }.size

    // 315. Convert a list of Ints to a list of their squares
    fun squareList_315(list: List<Int>): List<Int> =
        list.map { it * it }

    // 316. Calculate sum of all elements in a list
    fun sumList_316(list: List<Int>): Int =
        list.sum()

    // 317. Find median of a list of numbers
    fun median_317(list: List<Double>): Double? {
        if (list.isEmpty()) return null
        val sorted = list.sorted()
        val mid = sorted.size / 2
        return if (sorted.size % 2 == 0) (sorted[mid - 1] + sorted[mid]) / 2 else sorted[mid]
    }

    // 318. Check if a string is a palindrome ignoring case and spaces
    fun isPalindromeIgnoreCase_318(s: String): Boolean {
        val clean = s.lowercase().filter { !it.isWhitespace() }
        return clean == clean.reversed()
    }

    // 319. Convert map keys to uppercase
    fun mapKeysToUpper_319(map: Map<String, String>): Map<String, String> =
        map.mapKeys { it.key.uppercase() }

    // 320. Get list of characters from string
    fun stringToCharList_320(s: String): List<Char> =
        s.toList()

    // 321. Convert list of Ints to list of Strings
    fun intListToStringList_321(list: List<Int>): List<String> =
        list.map { it.toString() }

    // 322. Get unique elements from list preserving order
    fun <T> uniqueElements_322(list: List<T>): List<T> {
        val seen = mutableSetOf<T>()
        return list.filter { seen.add(it) }
    }

    // 323. Check if a string starts with uppercase letter
    fun startsWithUppercase_323(s: String): Boolean =
        s.firstOrNull()?.isUpperCase() ?: false

    // 324. Calculate product of elements in a list
    fun productList_324(list: List<Int>): Long =
        list.fold(1L) { acc, i -> acc * i }

    // 325. Check if a string contains any special characters
    fun containsSpecialChars_325(s: String): Boolean =
        s.any { !it.isLetterOrDigit() && !it.isWhitespace() }

    // 326. Get all substrings of a string
    fun allSubstrings_326(s: String): List<String> {
        val result = mutableListOf<String>()
        for (i in s.indices) {
            for (j in i+1..s.length) {
                result.add(s.substring(i, j))
            }
        }
        return result
    }

    // 327. Count the number of consonants in a string
    fun countConsonants_327(s: String): Int {
        val vowels = "aeiouAEIOU"
        return s.count { it.isLetter() && it !in vowels }
    }

    // 328. Capitalize every word in a string
    fun capitalizeWords_328(s: String): String =
        s.split(" ").joinToString(" ") { it.replaceFirstChar { c -> c.uppercase() } }

    // 329. Find difference between max and min in list
    fun differenceMaxMin_329(list: List<Int>): Int? {
        if (list.isEmpty()) return null
        return list.maxOrNull()!! - list.minOrNull()!!
    }

    // 330. Convert a string to kebab-case
    fun toKebabCase_330(s: String): String =
        s.trim().lowercase().replace(Regex("\\s+"), "-")

    // 331. Check if two lists are equal ignoring order
    fun <T> equalsIgnoreOrder_331(list1: List<T>, list2: List<T>): Boolean =
        list1.sortedBy { it.hashCode() } == list2.sortedBy { it.hashCode() }

    // 332. Convert a string to a list of ASCII values
    fun stringToAscii_332(s: String): List<Int> =
        s.map { it.code }

    // 333. Find indices of all occurrences of a character in a string
    fun indicesOfChar_333(s: String, c: Char): List<Int> =
        s.mapIndexedNotNull { index, ch -> if (ch == c) index else null }

    // 334. Check if a number is even
    fun isEven_334(n: Int): Boolean =
        n % 2 == 0

    // 335. Get first n elements of a list
    fun <T> firstN_335(list: List<T>, n: Int): List<T> =
        list.take(n)

    // 336. Get last n elements of a list
    fun <T> lastN_336(list: List<T>, n: Int): List<T> =
        list.takeLast(n)

    // 337. Count the number of lines in a string
    fun countLines_337(s: String): Int =
        s.lines().size

    // 338. Remove duplicates from a list of strings ignoring case
    fun removeDuplicatesIgnoreCase_338(list: List<String>): List<String> {
        val seen = mutableSetOf<String>()
        val result = mutableListOf<String>()
        for (item in list) {
            val lower = item.lowercase()
            if (seen.add(lower)) result.add(item)
        }
        return result
    }

    // 339. Reverse the words in a sentence but keep word order intact
    fun reverseWordsInSentence_339(s: String): String =
        s.split(" ").map { it.reversed() }.joinToString(" ")

    // 340. Get sum of ASCII values of characters in a string
    fun sumAscii_340(s: String): Int =
        s.sumOf { it.code }

    // 341. Check if string contains only whitespace
    fun isOnlyWhitespace_341(s: String): Boolean =
        s.all { it.isWhitespace() }

    // 342. Replace all digits in a string with a specific character
    fun replaceDigits_342(s: String, replacement: Char): String =
        s.map { if (it.isDigit()) replacement else it }.joinToString("")

    // 343. Check if list contains null values
    fun <T> containsNulls_343(list: List<T?>): Boolean =
        list.any { it == null }

    // 344. Find element with maximum length in a list of strings
    fun maxLengthString_344(list: List<String>): String? =
        list.maxByOrNull { it.length }

    // 345. Check if two strings differ only in case
    fun equalsIgnoreCase_345(s1: String, s2: String): Boolean =
        s1.equals(s2, ignoreCase = true)

    // 346. Generate list of prime numbers up to n
    fun primesUpTo_346(n: Int): List<Int> {
        val primes = mutableListOf<Int>()
        for (i in 2..n) {
            if (isPrime_251(i)) primes.add(i)
        }
        return primes
    }

    // 347. Calculate the sum of a range of integers inclusive
    fun sumRange_347(start: Int, end: Int): Int {
        val s = minOf(start, end)
        val e = maxOf(start, end)
        return (s..e).sum()
    }

    // 348. Check if string is a valid IPv4 address (basic)
    fun isValidIPv4_348(ip: String): Boolean =
        Regex("^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$").matches(ip)

    // 349. Remove all non-ASCII characters from a string
    fun removeNonAscii_349(s: String): String =
        s.filter { it.code in 0..127 }

    // 350. Get initials from a full name string
    fun getInitials_350(name: String): String =
        name.split(" ").mapNotNull { it.firstOrNull()?.uppercase() }.joinToString("")

    // 351. Convert a string to alternating case (e.g., HeLlO)
    fun toAlternatingCase_351(s: String): String =
        s.mapIndexed { i, c -> if (i % 2 == 0) c.uppercase() else c.lowercase() }.joinToString("")

    // 352. Count how many times a specific character appears in a string
    fun countChar_352(s: String, c: Char): Int =
        s.count { it == c }

    // 353. Check if a list is sorted ascending
    fun <T : Comparable<T>> isSortedAsc_353(list: List<T>): Boolean =
        list.zipWithNext().all { it.first <= it.second }

    // 354. Find duplicate elements in a list
    fun <T> findDuplicates_354(list: List<T>): List<T> =
        list.groupBy { it }.filter { it.value.size > 1 }.keys.toList()

    // 355. Convert a map to a query string
    fun mapToQueryString_355(map: Map<String, String>): String =
        map.entries.joinToString("&") { "${it.key}=${it.value}" }

    // 356. Format a number to n decimal places
    fun formatDecimal_356(number: Double, places: Int): String =
        "%.${places}f".format(number)

    // 357. Get all prefixes of a string
    fun stringPrefixes_357(s: String): List<String> =
        (1..s.length).map { s.substring(0, it) }

    // 358. Get all suffixes of a string
    fun stringSuffixes_358(s: String): List<String> =
        (s.indices).map { s.substring(it) }

    // 359. Check if list contains only unique values
    fun <T> allUnique_359(list: List<T>): Boolean =
        list.size == list.toSet().size

    // 360. Remove all digits from a string
    fun removeDigits_360(s: String): String =
        s.filterNot { it.isDigit() }

    // 361. Capitalize first and last letter of each word
    fun capitalizeFirstLast_361(s: String): String =
        s.split(" ").joinToString(" ") {
            if (it.length <= 1) it.uppercase()
            else it.first().uppercase() + it.substring(1, it.length - 1) + it.last().uppercase()
        }

    // 362. Rotate a list left by n positions
    fun <T> rotateLeft_362(list: List<T>, n: Int): List<T> {
        val shift = n % list.size
        return list.drop(shift) + list.take(shift)
    }

    // 363. Rotate a list right by n positions
    fun <T> rotateRight_363(list: List<T>, n: Int): List<T> {
        val shift = n % list.size
        return list.takeLast(shift) + list.dropLast(shift)
    }

    // 364. Filter strings containing a given substring
    fun filterBySubstring_364(list: List<String>, substring: String): List<String> =
        list.filter { it.contains(substring) }

    // 365. Flatten a list of lists
    fun <T> flattenList_365(nested: List<List<T>>): List<T> =
        nested.flatten()

    // 366. Group list of strings by their first character
    fun groupByFirstChar_366(list: List<String>): Map<Char, List<String>> =
        list.filter { it.isNotEmpty() }.groupBy { it.first() }

    // 367. Count the number of times each character appears in a string
    fun charFrequency_367(s: String): Map<Char, Int> =
        s.groupingBy { it }.eachCount()

    // 368. Replace all spaces in a string with a given character
    fun replaceSpaces_368(s: String, replacement: Char): String =
        s.replace(' ', replacement)

    // 369. Convert a string to title case
    fun toTitleCase_369(s: String): String =
        s.split(" ").joinToString(" ") { it.lowercase().replaceFirstChar { c -> c.uppercase() } }

    // 370. Check if a string is alphanumeric
    fun isAlphanumeric_370(s: String): Boolean =
        s.all { it.isLetterOrDigit() }

    // 371. Convert seconds to HH:mm:ss format
    fun secondsToTime_371(seconds: Int): String {
        val h = seconds / 3600
        val m = (seconds % 3600) / 60
        val s = seconds % 60
        return "%02d:%02d:%02d".format(h, m, s)
    }

    // 372. Get all distinct characters from a string
    fun distinctChars_372(s: String): List<Char> =
        s.toSet().toList()

    // 373. Pad a string to a specific length with a character
    fun padString_373(s: String, length: Int, padChar: Char): String =
        s.padEnd(length, padChar)

    // 374. Count the number of vowels in a string
    fun countVowels_374(s: String): Int =
        s.count { it.lowercaseChar() in "aeiou" }

    // 375. Check if all elements in a list are equal
    fun <T> allElementsEqual_375(list: List<T>): Boolean =
        list.distinct().size <= 1

    // 376. Interleave two lists
    fun <T> interleaveLists_376(list1: List<T>, list2: List<T>): List<T> =
        list1.zip(list2).flatMap { listOf(it.first, it.second) } + list1.drop(list2.size) + list2.drop(list1.size)

    // 377. Get the mode (most frequent) of a list
    fun <T> mode_377(list: List<T>): T? =
        list.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key

    // 378. Check if a number is a perfect square
    fun isPerfectSquare_378(n: Int): Boolean {
        val root = kotlin.math.sqrt(n.toDouble()).toInt()
        return root * root == n
    }

    // 379. Convert a list of booleans to binary string
    fun boolListToBinary_379(list: List<Boolean>): String =
        list.joinToString("") { if (it) "1" else "0" }

    // 380. Remove punctuation from a string
    fun removePunctuation_380(s: String): String =
        s.filter { it.isLetterOrDigit() || it.isWhitespace() }

    // 381. Join list of strings with a custom delimiter
    fun joinWithDelimiter_381(list: List<String>, delimiter: String): String =
        list.joinToString(delimiter)

    // 382. Get second highest number in a list
    fun secondHighest_382(list: List<Int>): Int? =
        list.distinct().sortedDescending().getOrNull(1)

    // 383. Check if string ends with a digit
    fun endsWithDigit_383(s: String): Boolean =
        s.lastOrNull()?.isDigit() ?: false

    // 384. Count words of a certain length in a string
    fun countWordsOfLength_384(s: String, length: Int): Int =
        s.split(Regex("\\W+")).count { it.length == length }

    // 385. Find longest common prefix in list of strings
    fun longestCommonPrefix_385(strings: List<String>): String {
        if (strings.isEmpty()) return ""
        var prefix = strings[0]
        for (str in strings.drop(1)) {
            while (!str.startsWith(prefix)) {
                prefix = prefix.dropLast(1)
                if (prefix.isEmpty()) return ""
            }
        }
        return prefix
    }

    // 386. Remove elements from a list based on a predicate
    fun <T> removeIf_386(list: List<T>, predicate: (T) -> Boolean): List<T> =
        list.filterNot(predicate)

    // 387. Get elements that appear only once in a list
    fun <T> uniqueOnly_387(list: List<T>): List<T> =
        list.groupBy { it }.filterValues { it.size == 1 }.keys.toList()

    // 388. Check if all characters in string are lowercase
    fun isAllLowerCase_388(s: String): Boolean =
        s.all { it.isLowerCase() }

    // 389. Get the average word length in a string
    fun averageWordLength_389(s: String): Double {
        val words = s.split(Regex("\\W+")).filter { it.isNotBlank() }
        return if (words.isEmpty()) 0.0 else words.sumOf { it.length }.toDouble() / words.size
    }

    // 390. Convert list of string numbers to integers
    fun stringListToInt_390(list: List<String>): List<Int> =
        list.mapNotNull { it.toIntOrNull() }

    // 391. Count capital letters in a string
    fun countUpperCase_391(s: String): Int =
        s.count { it.isUpperCase() }

    // 392. Replace multiple spaces with a single space
    fun normalizeSpaces_392(s: String): String =
        s.replace(Regex("\\s+"), " ")

    // 393. Remove surrounding quotes from a string
    fun removeSurroundingQuotes_393(s: String): String =
        s.trim().removeSurrounding("\"")

    // 394. Format a number with commas (e.g. 1,000)
    fun formatWithCommas_394(n: Int): String =
        "%,d".format(n)

    // 395. Return all words of a string that start with a capital letter
    fun capitalizedWords_395(s: String): List<String> =
        s.split(Regex("\\W+")).filter { it.firstOrNull()?.isUpperCase() == true }

    // 396. Check if a string is a valid Java identifier
    fun isValidIdentifier_396(s: String): Boolean =
        s.matches(Regex("[a-zA-Z_][a-zA-Z0-9_]*"))

    // 397. Get last word in a sentence
    fun lastWord_397(s: String): String =
        s.trim().split(Regex("\\s+")).lastOrNull() ?: ""

    // 398. Remove all non-letter characters from string
    fun removeNonLetters_398(s: String): String =
        s.filter { it.isLetter() }

    // 399. Truncate a string to a maximum length and append "..."
    fun truncateWithEllipsis_399(s: String, maxLength: Int): String =
        if (s.length <= maxLength) s else s.take(maxLength - 3) + "..."

    // 400. Get list of even numbers from 0 to n
    fun evenNumbersUpTo_400(n: Int): List<Int> =
        (0..n).filter { it % 2 == 0 }
}


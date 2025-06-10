import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    // Test cases for each function - students shouldn't modify these
    run5PointTests()
    run10PointTests()
    run15PointTest()
}

/* 5-POINT FUNCTIONS (Implement all these) */

/**
 * Calculates the sum of digits in a 4-digit number.
 * @param number A 4-digit number (0-9999)
 * @return Sum of all digits
 * @throws IllegalArgumentException if number is negative or more than 4 digits
 */
fun sumOfDigits(number: Int): Int {
    // TODO: Implement this function
    var somme = 0
    var copyOfNumber = number
    while (copyOfNumber > 10) {
        somme += copyOfNumber % 10
        copyOfNumber /= 10
    }
    somme += copyOfNumber

    return somme
}

/**
 * Calculates the nth Fibonacci number.
 * Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, ...
 * @param n The index in Fibonacci sequence (0-based)
 * @return The nth Fibonacci number
 */
fun fibonacci(n: Int): Int {
    // TODO: Implement this function
    if (n == 0) return 0
    if (n == 1) return 1

    return fibonacci(n-1)+fibonacci(n-2)
}

/**
 * Converts numerical points to letter grade.
 * Grading scale:
 * - 90+ = A
 * - 80-89 = B
 * - 70-79 = C
 * - 60-69 = D
 * - Below 60 = F
 * @param points Score from 0 to 100
 * @return Corresponding letter grade
 */
fun pointsToGrade(points: Int): Char {
    // TODO: Implement this function
    return when {
        points > 90 -> return 'A'
        points > 80 -> return 'B'
        points > 70 -> return 'C'
        points > 60 -> return 'D'
        else -> 'F'
    };
}

/**
 * Calculates factorial of a number (n!).
 * Note: 0! = 1
 * @param n Non-negative integer
 * @return Factorial of n
 */
fun factorial(n: Int): Int {
    if (n == 0) return 1
    return n * factorial(n-1)
}

/**
 * Checks if a number is prime.
 * Prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.
 * @param n Number to check
 * @return true if prime, false otherwise
 */
fun isPrime(n: Int): Boolean {

    for (i in 2..n / 2) {
        if (n % i == 0) {
            return false;
        }
    }

    return true
}

/**
 * Checks if a list contains at least one even number.
 * @param list List of integers to check
 * @return true if any even number exists, false otherwise
 */
fun containsEven(list: List<Int>): Boolean {

    for (it in list) {
        if (it % 2 == 0){
            return true
        }
    }

    return false
}

/**
 * Calculates the arithmetic mean (average) of a list of numbers.
 * Formula: sum(numbers) / count(numbers)
 */
fun arithmeticMean(list: List<Double>): Double {
    var somme = 0.0

    for (it in list) {
        somme += it
    }

    return somme / list.size
}

/**
 * Calculates the geometric mean of a list of numbers.
 * Formula: nth root of (x1 * x2 * ... * xn)
 */
fun geometricMean(list: List<Double>): Double {
    var somme = 1.0

    for (it in list) {
        somme *= it
    }

    return somme.pow(1.0 / list.size)
}

/**
 * Calculates the harmonic mean of a list of numbers.
 * Formula: n / (1/x1 + 1/x2 + ... + 1/xn)
 */
fun harmonicMean(list: List<Double>): Double {
    var somme = 0.0

    for (it in list) {
        somme += 1/it
    }

    return list.size / somme
}

/**
 * Calculates the quadratic mean (RMS) of a list of numbers.
 * Formula: square root of (sum(x²) / n)
 */
fun quadraticMean(list: List<Double>): Double {
    var somme = 0.0

    for (it in list) {
        somme += it*it
    }

    return sqrt(somme/list.size)
}

/* 10-POINT FUNCTIONS (Implement all these) */

/**
 * Checks if two strings are anagrams (contain same letters in different order).
 * Should be case-insensitive and ignore spaces.
 * Example: "listen" and "silent" are anagrams
 * @param s1 First string
 * @param s2 Second string
 * @return true if anagrams, false otherwise
 */
fun isAnagram(s1: String, s2: String): Boolean {

    val sl1 = s1.toList().sorted()
    val sl2 = s2.toList().sorted()

    return sl1 == sl2
}

/**
 * Implements the Sieve of Eratosthenes algorithm to find all prime numbers up to n.
 * @param n Upper limit
 * @return List of all prime numbers ≤ n
 */
fun sieveOfEratosthenes(n: Int): List<Int> {
    val L = BooleanArray(n + 1) { true }
    L[0] = false
    L[1] = false

    for (i in 2..n) {
        if (L[i]) {
            for (j in i * i..n step i) {
                L[j] = false
            }
        }
    }

    return (2..n).filter { L[it] }
}

    /**
 * Checks if a string is a palindrome (reads same backward as forward).
 * Should be case-insensitive and ignore spaces.
 * Example: "A man a plan a canal Panama" is a palindrome
 * @param s String to check
 * @return true if palindrome, false otherwise
 */
fun isPalindrome(s: String): Boolean {
    for (i in 0 .. s.length - 1) {
        if (s[i] != s[s.length - 1 - i]) {
            return false
        }
    }
    return true
}

/* 15-POINT FUNCTION (Implement this) */

/**
 * Solves the N-Queens puzzle - finding all distinct solutions for placing N queens
 * on an N×N chessboard where no two queens threaten each other.
 * @param n Size of chessboard and number of queens
 * @return List of all solutions, where each solution is a list of queen positions (row, col)
 */
fun nQueens(n: Int): List<List<Pair<Int, Int>>> {
    // TODO: Implement this function
    return emptyList()
}

/* TEST FUNCTIONS (Students shouldn't modify these) */

private fun run5PointTests() {
    println("5-POINT FUNCTIONS TESTS:")
    
    // sumOfDigits
    println("sumOfDigits(1234) = ${sumOfDigits(1234)} (Expected: 10)")
    println("sumOfDigits(9999) = ${sumOfDigits(9999)} (Expected: 36)")
    
    // fibonacci
    println("fibonacci(5) = ${fibonacci(5)} (Expected: 5)")
    println("fibonacci(10) = ${fibonacci(10)} (Expected: 55)")
    
    // pointsToGrade
    println("pointsToGrade(85) = ${pointsToGrade(85)} (Expected: B)")
    println("pointsToGrade(62) = ${pointsToGrade(62)} (Expected: D)")
    
    // factorial
    println("factorial(5) = ${factorial(5)} (Expected: 120)")
    
    // isPrime
    println("isPrime(29) = ${isPrime(29)} (Expected: true)")
    println("isPrime(12) = ${isPrime(12)} (Expected: false)")
    
    // containsEven
    println("containsEven([1, 3, 5]) = ${containsEven(listOf(1, 3, 5))} (Expected: false)")
    println("containsEven([1, 2, 3]) = ${containsEven(listOf(1, 2, 3))} (Expected: true)")
    
    // averages
    val nums = listOf(1.0, 2.0, 3.0, 4.0)
    println("arithmeticMean = ${arithmeticMean(nums)} (Expected: 2.5)")
    println("geometricMean = ${geometricMean(nums)} (Expected: ~2.213)")
    println("harmonicMean = ${harmonicMean(nums)} (Expected: ~1.92)")
    println("quadraticMean = ${quadraticMean(nums)} (Expected: ~2.738)")
    
    println()
}

private fun run10PointTests() {
    println("10-POINT FUNCTIONS TESTS:")
    
    // isAnagram
    println("isAnagram('listen', 'silent') = ${isAnagram("listen", "silent")} (Expected: true)")
    println("isAnagram('hello', 'world') = ${isAnagram("hello", "world")} (Expected: false)")
    
    // sieveOfEratosthenes
    println("sieveOfEratosthenes(20) = ${sieveOfEratosthenes(20)} (Expected: [2, 3, 5, 7, 11, 13, 17, 19])")
    
    // isPalindrome
    println("isPalindrome('kajak') = ${isPalindrome("kajak")} (Expected: true)")
    println("isPalindrome('hello') = ${isPalindrome("hello")} (Expected: false)")
    
    println()
}

private fun run15PointTest() {
    println("15-POINT FUNCTION TEST:")
    
    // nQueens
    println("nQueens(4).size = ${nQueens(4).size} (Expected: 2)")
    println("nQueens(8).size = ${nQueens(8).size} (Expected: 92)")
}
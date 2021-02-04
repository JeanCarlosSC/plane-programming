package lib.sRAD.logic

// forma escalonada
private fun performOperation(a: Array<DoubleArray>): Int {
    var j: Int
    var k: Int
    var c: Int
    var flag = 0
    val n = a.size

    // Performing elementary operations
    var i = 0
    while (i < n) {
        if (a[i][i] == 0.0) {
            c = 1
            while (i + c < n && a[i + c][i] == 0.0) c++
            if (i + c == n) {
                flag = 1
                break
            }
            j = i
            k = 0
            while (k <= n) {
                val temp = a[j][k]
                a[j][k] = a[j + c][k]
                a[j + c][k] = temp
                k++
            }
        }
        j = 0
        while (j < n) {

            // Excluding all i == j
            if (i != j) {
                // Converting Matrix to reduced row
                // echelon form(diagonal matrix)
                val p = a[j][i] / a[i][i]
                k = 0
                while (k <= n) {
                    a[j][k] = a[j][k] - a[i][k] * p
                    k++
                }
            }
            j++
        }
        i++
    }
    return flag
}

// To check whether infinite solutions
// exists or no solution exists
private fun checkConsistency(a: Array<DoubleArray>): Int {
    var j: Int
    val n = a.size
    var sum: Double

    // flag == 2 for infinite solution
    // flag == 3 for No solution
    var flag = 3
    var i = 0
    while (i < n) {
        sum = 0.0
        j = 0
        while (j < n) {
            sum += a[i][j]
            j++
        }
        if (sum == a[i][j]) flag = 2
        i++
    }
    return flag
}

fun gaussJordan(a: Array<DoubleArray>): DoubleArray {
    var flag: Int

    // Performing Matrix transformation
    flag = performOperation(a)
    if (flag == 1) flag = checkConsistency(a)

    // Printing Solutions(if exist)
    val n = a.size
    print("Result is : ")
    return when (flag) {
        2 -> doubleArrayOf(-1.0) // Infinite Solutions Exists
        3 -> doubleArrayOf(0.0) // No Solution Exists
        else -> {
            val resultado = DoubleArray(n)
            for (i in 0 until n) resultado[i] = a[i][n] / a[i][i]
            resultado
        }
    }
}

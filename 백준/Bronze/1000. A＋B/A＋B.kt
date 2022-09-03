import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val solution = Solution()
    val stringTokenizer = StringTokenizer(br.readLine())
    val a = stringTokenizer.nextToken().toInt()
    val b = stringTokenizer.nextToken().toInt()
    val answer = solution.solution(a, b)

    println(answer)
}
class Solution {
    fun solution(a: Int, b: Int): Int {
        return a+b
    }
}


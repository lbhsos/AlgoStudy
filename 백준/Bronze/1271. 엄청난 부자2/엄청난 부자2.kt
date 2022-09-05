import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stringTokenizer = StringTokenizer(br.readLine())
    val n = stringTokenizer.nextToken().toBigInteger()
    val m = stringTokenizer.nextToken().toBigInteger()
    
    println(n.div(m))
    println(n.rem(m))
}

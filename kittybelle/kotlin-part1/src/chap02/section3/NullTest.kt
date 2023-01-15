package chap02.section3

fun main() {
    var str1: String?
    str1 = null

    // 세이프 콜 ?. 사용시 뒷부분 실행X -> str1: null, length: null
    println("str1: $str1, length: ${str1?.length}")

    // !!. 사용시 null일리 없다고 가정 -> NPE 발생
    // println("str1: $str1, length: ${str1!!.length}")

    var str2: String?
    str2 = "Hello"

    // str2: Hello, length: 5
    println("str2: $str2, length: ${str2?.length}")

    var len1 = if(str1 != null) str1.length else -1

    // 엘비스 연산자 : null 검사 후 null 아니면 왼쪽 식 실행, null 이면 오른쪽 식 실행
    var len = str1?.length ?: -1

    // -1
    println("str1: $str1, length: $len")
}
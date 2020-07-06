fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    println(allCaps)
}

printAllCaps("abc")
printAllCaps(null)

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}
ignoreNulls(null)

fun sendEmail(email: String) {
    email?.let { println(it) }
}
sendEmail("test@email.com")
sendEmail("")

val answer: Any = 42
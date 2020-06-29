class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}

sealed class Expr {
    class Num(val value: Int): Expr()
    class Sum(val left: Expr, val right: Expr): Expr()
}

fun eval(e: Expr): Int =
        when (e) {
            is Expr.Num -> e.value
            is Expr.Sum -> eval(e.right) + eval(e.left)
        }

// Types of class initializers (all the same, just different levels of concise syntax)
class User constructor(_nickname: String) {
    val nickname: String

    init {
        nickname = _nickname
    }
}

class User(_nickname: String) {
    val nickname = _nickname
}

class User(val nickname: String)

class User(val nickname: String, val isSuscribd: Boolean = false)

val alice = User("Alice")

//Secondary class constructor (uses constructor keyword)
class MyButton: View {
    constructor(ctx: Context)
        : super(ctx) {}
}

interface User {
    var email: String
    val nickname: String
        get() = email.substringBefore('@')
}

// Data class
data class Client(val name: String, val postalCode: Int)

//Object class
object CaseInsensitiveComparator: Comparable<String> {
    override fun compareTo(other: String): Int {
        return this == other1
    }
}

// companion object
class A {
    companion object {
        fun bar() {
            println("Companion called")
        }
    }
}

// Example companion object
class User {
    val nickname: String

    constructor(email: String) {
        nickname = email.substringBefore("@");
    }

    constructor(facebookId: Int) {
        nickname = getFacebookName(facebookId)
    }
}

class User private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) = User(email.substringBefore("@"))
        fun newFacebookUser(accountId: Int) = User(getFacebookName(facebookId))
    }
}

// Operators

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}
val p1 = Point(10, 20)
val p2 = Point(20, 30)
println(p1 + p2)

// can be used for set and get
operator fun Point.get(index: Int): Int {
    return when(index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid Index")
    }
}
println(p1[1])

// Destructuring
val (x, y) = p1
println(x)
println(y)

// Delegates
class Person {
    private val _attributes = hashMapOf<String, String>()
    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String
        get() = _attributes["name"]!!

    // Using delegated property
//    val name: String by _attributes
}

val p = Person()
val data = mapOf("name" to "Dmitry", "company" to "MiCasa")
for ((attrName, value) in data)
p.setAttribute(attrName, value)
println(p.name)
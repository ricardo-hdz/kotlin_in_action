class Person(val name: String, val age: Int)

val p = Person("Alice", 34)
val kClass = p.javaClass.kotlin
println(kClass.simpleName)

// member property
val memberProperty = Person::age
println(memberProperty.get(p))

class Person(val name: String)

fun sendEmail(person: Person, message: String) {
    println("Email sent")
}

val action = { person: Person, message: String ->
    sendEmail(person, message)
}
val nextAction = ::sendEmail


// Member refereces
data class Person(val name: String, val age: Int)

val createPerson = ::Person
val p = createPerson("Alice", 10)
print(p)

fun Person.isAdult() = age >= 21
val predicate = Person::isAdult

// Bound references
data class Person(val name: String, val age: Int)

val p = Person("Dmitry", 34)
val personAgeFunction = Person::age
println(personAgeFunction(p))

val dimitryAfeFunction = p::age
println(dimitryAfeFunction())

// Collection functions
data class Person(val name: String, val age: Int)

val canBeInClub27 = { p: Person -> p.age <= 27 }
val people = listOf(Person("Alice", 27), Person("Bob", 31))
println(people.all(canBeInClub27))
println(people.any(canBeInClub27))
println(people.count(canBeInClub27))
println(people.find(canBeInClub27))
println(people.firstOrNull(canBeInClub27))
println(people.groupBy { it.age })

// Sequences
data class Person(val name: String, val age: Int)

fun Person.startsWith(char: Char) {
    this.name[0] === char
}

val people = listOf(Person("Alice", 27), Person("Bob", 31))
people.asSequence()
.map(Person::name)
.filter { it.startsWith("A") }
.toList()

// Lambdas with receivers
// With function
fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet")
    return result.toString()
}

fun alphabet(): String {
    val stringBuilder = StringBuilder()
    with (stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        this.append("\nNow i Know the alphabet")
        this.toString()
    }

    fun alphabet() = with (StringBuilder()) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        this.append("\nNow i Know the alphabet")
        this.toString()
    }

    // Apply function
    fun alphabet() = StringBuilder().apply {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        this.append("\nNow i Know the alphabet")
    }.toString()


package chap02.section2

import kotlin.properties.Delegates

class User {
    var name: String by Delegates.observable("Noname") {
        prop, old, new ->
        println("old: $old, new: $new")
    }
}

fun main() {
    val user = User()

    user.name = "Kitty"
    user.name = "Belle"
}
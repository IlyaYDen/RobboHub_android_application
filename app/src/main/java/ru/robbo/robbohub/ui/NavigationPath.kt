package ru.robbo.robbohub.ui

sealed class NavigationPath(val path: String) {
    object Start : NavigationPath(path = "start_screen")
    object Authorization : NavigationPath(path = "login_screen")
    object Registration : NavigationPath(path = "registration_screen")
    object RecordList : NavigationPath(path = "note_screen")

    fun withArgs(vararg args: Pair<String,String>) =
        buildString {
            append(path)
            args.forEach { arg ->
                append("?${arg.first}=${arg.second}")
            }
        }
}
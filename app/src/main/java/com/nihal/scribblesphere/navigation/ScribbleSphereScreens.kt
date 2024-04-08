package com.nihal.scribblesphere.navigation

sealed class ScribbleSphereScreens(val name: String) {

    data object Notes : ScribbleSphereScreens("notes")
    data object AddEditNotes : ScribbleSphereScreens("add_edit_note")
    data object TodoHome : ScribbleSphereScreens("todo_home")
    data object Settings : ScribbleSphereScreens("setting")
    data object TrashNoteScreen : ScribbleSphereScreens("trash_note_route")
}

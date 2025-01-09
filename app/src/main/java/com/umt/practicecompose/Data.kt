package com.umt.practicecompose

data class Data(val name:String, val description:String)


fun getProjects(): List<Data> {
    return listOf(
        Data(
            name = "Weather Tracker",
            description = "An Android app that provides real-time weather updates, forecasts, and severe weather alerts for users based on their location."
        ),
        Data(
            name = "Expense Manager",
            description = "A mobile app to help users manage personal finances, track expenses, and set budget goals with graphical insights and reminders."
        ),
        Data(
            name = "Recipe Finder",
            description = "An app that allows users to search for recipes based on ingredients, dietary preferences, and cooking time, featuring a recipe bookmarking option."
        ),
        Data(
            name = "Fitness Buddy",
            description = "A fitness tracking app with workout routines, progress monitoring, and nutrition tips tailored to the user's fitness level and goals."
        )
    )
}
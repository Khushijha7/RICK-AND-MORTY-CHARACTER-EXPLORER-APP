package eu.tutorials.assignment_task1.model

data class Pagination(
    val current: Int,
    val last: Int,
    val next: Int,
    val records: Int
)
package com.example.myapp.service

class ListDataResponse(
    val children: List<ListChildrenResponse>,
    val after: String?,
    val before: String?
)
package com.dkproject.compose_codelab.Chapter4.Reply.utils

enum class ReplyNavigationType {
    BOTTOM_NAVIGATION, NAVIGATION_RAIL, PERMANENT_NAVIGATION_DRAWER
}

/**
 * Content shown depending on size and state of device.
 */
enum class ReplyContentType {
    LIST_ONLY, LIST_AND_DETAIL
}
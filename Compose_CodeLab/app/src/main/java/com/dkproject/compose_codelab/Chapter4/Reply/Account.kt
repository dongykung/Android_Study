package com.dkproject.compose_codelab.Chapter4.Reply

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Account(
    /** Unique ID of a user **/
    val id: Long,
    /** User's first name **/
    @StringRes val firstName: Int,
    /** User's last name **/
    @StringRes val lastName: Int,
    /** User's email address **/
    @StringRes val email: Int,
    /** User's avatar image resource id **/
    @DrawableRes val avatar: Int
)
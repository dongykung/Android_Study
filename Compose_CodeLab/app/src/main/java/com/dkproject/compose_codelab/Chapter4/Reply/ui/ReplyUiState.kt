package com.dkproject.compose_codelab.Chapter4.Reply.ui

import com.dkproject.compose_codelab.Chapter4.Reply.Email
import com.dkproject.compose_codelab.Chapter4.Reply.MailboxType
import com.dkproject.compose_codelab.Chapter4.Reply.local.LocalEmailsDataProvider

data class ReplyUiState(
    val mailboxes: Map<MailboxType, List<Email>> = emptyMap(),
    val currentMailbox: MailboxType = MailboxType.Inbox,
    val currentSelectedEmail: Email = LocalEmailsDataProvider.defaultEmail,
    val isShowingHomepage: Boolean = true
) {
    val currentMailboxEmails: List<Email> by lazy { mailboxes[currentMailbox]!! }
}

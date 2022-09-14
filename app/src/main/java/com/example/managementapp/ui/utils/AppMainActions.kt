package com.example.managementapp.ui.utils

import com.example.managementapp.R

enum class AppMainActions {

    ARCHIVE {
        override val actionName: String
            get() = "Склад"
        override val image: Int
            get() = R.drawable.ic_bx_archive

    },

    REPORT {
        override val actionName: String
            get() = "Отчёт"
        override val image: Int
            get() = R.drawable.ic_bx_book

    },

    ARCHIVE_ADD {
        override val actionName: String
            get() = "Добавить предмет"
        override val image: Int
            get() = R.drawable.ic_bx_archive_in

    },

    SEARCH {
        override val actionName: String
            get() = "Поиск"
        override val image: Int
            get() = R.drawable.ic_bx_zoom_out
    },

    EXPENSES {
        override val actionName: String
            get() = "Затраты"
        override val image: Int
            get() = R.drawable.ic_bx_bitcoin

    },

    QRCODE {
        override val actionName: String
            get() = "Сканировать QR-код"
        override val image: Int
            get() = R.drawable.qr_code_icon

    },

    FEEDBACK {
        override val actionName: String
            get() = "Обратная связь"
        override val image: Int
            get() = R.drawable.ic_bx_message_dots

    },

    REFERENCE {
        override val actionName: String
            get() = "Справка"
        override val image: Int
            get() = R.drawable.ic_bx_question_mark

    },

    PROFILE {
        override val actionName: String
            get() = "Профиль"
        override val image: Int
            get() = R.drawable.ic_profile

    },

    HOME {
        override val actionName: String
            get() = "Главное меню"
        override val image: Int
            get() = R.drawable.ic_home

    },

    SETTINGS {
        override val actionName: String
            get() = "Настройки"
        override val image: Int
            get() = R.drawable.ic_settings
    };

    abstract val actionName: String
    abstract val image: Int

}

package dev.whysoezzy.ui.utils

import dev.whysoezzy.ui.R

internal enum class Country(val country: String, val phoneCode: String, val flagId: Int) {
    ARMENIA("Armenia", "+374", R.drawable.ic_am_flag),
    AZERBAIJAN("Azerbaijan", "+994", R.drawable.ic_az_flag),
    BElARUS("Belarus", "+375", R.drawable.ic_by_flag),
    CHINA("China", "+86", R.drawable.ic_cn_flag),
    GREAT_BRITAIN("GreatBritain", "+44", R.drawable.ic_gb_flag),
    TURKMENISTAN("Turkmenistan", "+993", R.drawable.ic_tr_flag),
    KAZAKHSTAN("Kazakhstan", "+7", R.drawable.ic_kz_flag),
    RUSSIA("Russia", "+7", R.drawable.ic_ru_flag),
    USA("USA", "+1", R.drawable.ic_us_flag),
    UZBEKISTAN("Uzbekistan", "+998", R.drawable.ic_uz_flag),
    TURKEY("Turkey", "+90", R.drawable.ic_tr_flag),
    GEORGIA("Georgia", "+995", R.drawable.ic_ge_flag),
    SOUTH_KOREA("Korea", "+82", R.drawable.ic_kr_flag),
    UAE("AE", "+971", R.drawable.ic_ae_flag),
}
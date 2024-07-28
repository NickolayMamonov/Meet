package dev.whysoezzy.ui.screens.auth.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

private const val PHONE_NUMBER_WITHOUT_COUNTRY_CODE_LENGTH = 10

class PhoneNumViewModel : ViewModel() {
    private val _phoneNumber = MutableStateFlow("")
    private val phoneNumber: StateFlow<String> = _phoneNumber.asStateFlow()
    private val _countryCode = MutableStateFlow("+7")
    private val countryCode: StateFlow<String> = _countryCode.asStateFlow()
    private val _isPhoneNumberValid = MutableStateFlow(false)
    private val isPhoneNumberValid: StateFlow<Boolean> = _isPhoneNumberValid.asStateFlow()

    fun phoneNumber() = phoneNumber
    fun countryCode() = countryCode
    fun isPhoneNumberValid() = isPhoneNumberValid

    fun updatePhoneNumber(number: String) {
        _phoneNumber.value = number
        validatePhoneNumber()
    }

    fun updateCountryCode(code: String) {
        _countryCode.value = code
    }

    private fun validatePhoneNumber() {
        _isPhoneNumberValid.value =
            _phoneNumber.value.length == PHONE_NUMBER_WITHOUT_COUNTRY_CODE_LENGTH
    }

}
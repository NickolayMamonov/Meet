package ru.wb.meetings.ui.screens.auth.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

private const val PHONE_NUMBER_WITHOUT_COUNTRY_CODE_LENGTH = 10

class PhoneNumViewModel() : ViewModel() {
    private val _phoneNumber = MutableStateFlow("")
    val phoneNumber: StateFlow<String> = _phoneNumber

    private val _countryCode = MutableStateFlow("+7")
    val countryCode: StateFlow<String> = _countryCode

    private val _isPhoneNumberValid = MutableStateFlow(false)
    val isPhoneNumberValid: StateFlow<Boolean> = _isPhoneNumberValid

    fun updatePhoneNumber(number: String) {
        _phoneNumber.value = number
        validatePhoneNumber()
    }

    fun updateCountryCode(code: String) {
        _countryCode.value = code
    }

    private fun validatePhoneNumber() {
        _isPhoneNumberValid.value = _phoneNumber.value.length == PHONE_NUMBER_WITHOUT_COUNTRY_CODE_LENGTH
    }

    fun onContinueClicked(action: (String, String) -> Unit) {
        if (_isPhoneNumberValid.value) {
            viewModelScope.launch {
                action(_phoneNumber.value, _countryCode.value)
            }
        }
    }
}
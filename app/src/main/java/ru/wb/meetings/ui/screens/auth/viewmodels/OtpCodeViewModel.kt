package ru.wb.meetings.ui.screens.auth.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val OTP_CODE_LENGTH = 4

class OtpCodeViewModel : ViewModel() {
    private val _otpCode = MutableStateFlow("")
    val otpCode: StateFlow<String> = _otpCode

    private val _isOtpValid = MutableStateFlow(false)
    val isOtpValid: StateFlow<Boolean> = _isOtpValid

    fun updateOtpCode(code: String) {
        _otpCode.value = code
        validateOtpCode()
    }

    private fun validateOtpCode() {
        _isOtpValid.value = _otpCode.value.length == OTP_CODE_LENGTH
    }

}
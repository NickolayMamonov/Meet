package dev.whysoezzy.ui.screens.auth.viewmodels

import androidx.lifecycle.ViewModel
import dev.whysoezzy.ui.utils.OTP_LENGTH
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class OtpCodeViewModel : ViewModel() {
    private val _otpCode = MutableStateFlow("")
    private val otpCode: StateFlow<String> = _otpCode.asStateFlow()
    private val _isOtpValid = MutableStateFlow(false)
    private val isOtpValid: StateFlow<Boolean> = _isOtpValid.asStateFlow()

    fun otpCode() = otpCode
    fun isOtpValid() = isOtpValid

    fun updateOtpCode(code: String) {
        _otpCode.value = code
        validateOtpCode()
    }

    private fun validateOtpCode() {
        _isOtpValid.value = _otpCode.value.length == OTP_LENGTH
    }

}
package dev.whysoezzy.ui.screens.auth.profile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class AddProfileViewModel : ViewModel() {
    private val _firstName = MutableStateFlow("")
    private val firstName: StateFlow<String> = _firstName.asStateFlow()
    private val _lastName = MutableStateFlow("")
    private val lastName: StateFlow<String> = _lastName.asStateFlow()

    fun lastName() = lastName
    fun firstName() = firstName

    fun updateFirstName(name: String) {
        _firstName.value = name
    }

    fun updateLastName(name: String) {
        _lastName.value = name
    }
}
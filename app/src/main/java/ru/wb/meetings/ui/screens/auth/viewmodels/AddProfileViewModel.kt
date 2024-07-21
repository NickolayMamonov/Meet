package ru.wb.meetings.ui.screens.auth.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AddProfileViewModel : ViewModel() {
    private val _firstName = MutableStateFlow("")
    private val firstName: StateFlow<String> = _firstName.asStateFlow()

    fun firstName() = firstName

    private val _lastName = MutableStateFlow("")
    private val lastName: StateFlow<String> = _lastName.asStateFlow()

    fun lastName() = lastName

    fun updateFirstName(name: String) {
        _firstName.value = name
    }

    fun updateLastName(name: String) {
        _lastName.value = name
    }
}
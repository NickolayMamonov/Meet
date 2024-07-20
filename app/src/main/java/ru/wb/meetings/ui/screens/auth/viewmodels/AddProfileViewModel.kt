package ru.wb.meetings.ui.screens.auth.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddProfileViewModel : ViewModel() {
    private val _firstName = MutableStateFlow("")
    val firstName: StateFlow<String> = _firstName

    private val _lastName = MutableStateFlow("")
    val lastName: StateFlow<String> = _lastName

    fun updateFirstName(name: String) {
        _firstName.value = name
    }

    fun updateLastName(name: String) {
        _lastName.value = name
    }


}
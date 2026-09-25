package com.example.andegym.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.andegym.ui.friends.FriendProfileScreen

class FriendViewModelFactory(private  val uid:String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FriendProfileViewModel(uid) as T
    }
}
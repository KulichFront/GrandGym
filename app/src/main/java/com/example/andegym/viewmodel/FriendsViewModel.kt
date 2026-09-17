package com.example.andegym.viewmodel

import androidx.lifecycle.ViewModel
import com.example.andegym.data.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FriendsViewModel(): ViewModel() {

    private val _searchText= MutableStateFlow<String>("")
    val searchText: StateFlow<String> =_searchText

    private val _searchResult= MutableStateFlow<User?>(null)
    val searchResult: StateFlow<User?> =_searchResult

    private val _searchError =MutableStateFlow<String?>(null)
    val searchError: StateFlow<String?> =_searchError

    private val _isLoading =MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean> =_isLoading
    val firestore= FirebaseFirestore.getInstance()

    fun updateSearchText(text:String){
        _searchText.value=text
    }

    fun clearSearch() {
        _searchError.value = null
        _searchResult.value = null
    }

    fun searchUser(){
        val searchingUser=searchText.value
        if(searchText.value!=""){
            _isLoading.value=true

            firestore.collection("users")
                .whereEqualTo("nickname",searchText.value)
                .get()
                .addOnSuccessListener {
                    result->
                    if(!result.isEmpty){
                        val document=result.documents.first()
                        val id=document.id
                        val nick=document.getString("nickname")
                        val level=document.getLong("level")?.toInt()
                        val xp=document.getLong("xp")?.toInt()
                        val user=User(
                            id,
                            nick?:"без ника",
                            level?: 0,
                            xp?: 0
                        )
                        _searchResult.value=user
                        _searchError.value=null
                    }
                    else{
                        _searchError.value="Пользователь не найден"
                    }
                    _isLoading.value=false
                }
        }
    }
    fun addFriend(uid:String){
        val myId=FirebaseAuth.getInstance().currentUser?.uid
        if(myId!=null){
            val requestData=hashMapOf(
                "from" to myId,
                "to" to uid,
                "status" to "pending",
                "timestamp" to System.currentTimeMillis()
            )
            firestore.collection("friend_requests")
                .add(requestData)
                .addOnSuccessListener {
                    clearSearch()
                }
        }
    }



}
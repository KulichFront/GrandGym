package com.example.andegym.viewmodel

import androidx.lifecycle.ViewModel
import com.example.andegym.data.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.TODO

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

    private val _friends=MutableStateFlow<List<User>>(emptyList())
    val friends: StateFlow<List<User>> =_friends

    private val _requestsFlow=MutableStateFlow<List<User>>(emptyList())
    val requestsFlow: StateFlow<List<User>> =_requestsFlow

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
                            nick ?: "без ника",
                            level ?: 0,
                            xp ?: 0,
                            document.getBoolean("isPublic") ?: true,
                            document.getLong("totalVolume")?.toInt() ?: 0,
                            document.getLong("workoutCount")?.toInt() ?: 0,
                            document.get("friends") as? List<String> ?: emptyList()
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

    fun loadFriends(){
        val myId= FirebaseAuth.getInstance().currentUser?.uid
        if(myId!=null){
            val resultList=mutableListOf<User>()
            firestore.collection("users").document(myId).get().addOnSuccessListener {document ->

                val friendsList=document.get("friends") as? List<String> ?: emptyList()
                if(!friendsList.isEmpty()){
                    val totalCount=friendsList.size
                    var currentCount=0
                    friendsList.forEach { uid->
                        firestore.collection("users").document(uid).get().addOnSuccessListener { frienddoc->
                            val user=User(
                                frienddoc.id,
                                frienddoc.getString("nickname")?: "",
                                frienddoc.getLong("level")?.toInt()?: 0,
                                frienddoc.getLong("xp")?.toInt() ?: 0,
                                frienddoc.getBoolean("isPublic") ?: true,
                                frienddoc.getLong("totalVolume")?.toInt() ?: 0,
                                frienddoc.getLong("workoutCount")?.toInt() ?: 0,
                                frienddoc.get("friends") as? List<String> ?: emptyList()
                            )
                            resultList.add(user)
                            currentCount++
                            if(totalCount==currentCount){
                                _friends.value=resultList
                            }
                        }

                    }

                }
                else{
                    _friends.value=emptyList()
                }
            }
        }

    }
    fun loadRequest(){
        val myId= FirebaseAuth.getInstance().currentUser?.uid
        if(myId!=null){
            val resultList=mutableListOf<User>()

            firestore.collection("friend_requests")
                .whereEqualTo("to",myId)
                .whereEqualTo("status","pending")
                .get()
                .addOnSuccessListener { document ->
                    if(document.isEmpty()){
                        _requestsFlow.value=emptyList()
                    }
                    else{
                        var currentCount=0
                        val totalCount=document.documents.size
                        document.documents.forEach {doc ->
                            val fromId=doc.getString("from") ?: return@forEach
                            firestore.collection("users").document(fromId).get().addOnSuccessListener { doc->
                                val user=User(
                                    doc.id,
                                    doc.getString("nickname")?:"",
                                    doc.getLong("level")?.toInt() ?:0,
                                    doc.getLong("xp")?.toInt() ?:0,
                                    doc.getBoolean("isPublic") ?: true,
                                    doc.getLong("totalVolume")?.toInt() ?: 0,
                                    doc.getLong("workoutCount")?.toInt() ?: 0,
                                    doc.get("friends") as? List<String> ?: emptyList()
                                )
                                resultList.add(user)
                                currentCount++
                                if(currentCount==totalCount){
                                    _requestsFlow.value=resultList
                                }

                            }
                        }
                    }
                }
        }
    }

    fun declineRequest(uId: String){
        val myId= FirebaseAuth.getInstance().currentUser?.uid
        if (myId != null) {
            firestore.collection("friend_requests")
                .whereEqualTo("to", myId)
                .whereEqualTo("from", uId)
                .whereEqualTo("status", "pending")
                .get()
                .addOnSuccessListener { result ->
                    val resultDoc = result.documents.firstOrNull()
                    resultDoc?.reference?.update("status", "declined")
                }
        }

    }
    fun acceptRequest(uid: String){
        val myId=FirebaseAuth.getInstance().currentUser?.uid
        if(myId!=null){
            firestore.collection("users").document(myId).get().addOnSuccessListener {
                doc->
                val myFriends=doc.get("friends") as? List<String> ?: emptyList()
                val newFriends=myFriends+uid
                firestore.collection("users").document(myId)
                    .update("friends",newFriends)
            }
            firestore.collection("users").document(uid).get().addOnSuccessListener { doc->
                val youFriends=doc.get("friends") as? List<String> ?: emptyList()
                val newYouFriends=youFriends+myId
                firestore.collection("users").document(uid)
                    .update("friends",newYouFriends)
            }
            firestore.collection("friend_requests")
                .whereEqualTo("to", myId)
                .whereEqualTo("from", uid)
                .whereEqualTo("status", "pending")
                .get()
                .addOnSuccessListener { result ->
                    val resultDoc = result.documents.firstOrNull()
                    resultDoc?.reference?.update("status", "accepted")
                }
        }
    }

}
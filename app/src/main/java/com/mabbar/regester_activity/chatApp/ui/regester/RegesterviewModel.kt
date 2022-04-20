package com.mabbar.regester_activity.chatApp.ui.regester

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.mabbar.regester_activity.chatApp.base.BaseViewModel

class RegesterviewModel:BaseViewModel() {

    val firstname=ObservableField<String>()
    val firstnameerror=ObservableField<String>()
    val lastname=ObservableField<String>()
    val lastnameerror=ObservableField<String>()

    val username=ObservableField<String>()
    val usernameerror=ObservableField<String>()

    val email=ObservableField<String>()
    val emailerror=ObservableField<String>()
    val password=ObservableField<String>()
    val passworderror=ObservableField<String>()


    val auth=Firebase.auth




    fun createAccount(){
        if (validate()){
            addaccountToFirebase()



        }

}
fun addaccountToFirebase(){
    showLoading.value=true
    auth.createUserWithEmailAndPassword(email.get()!!,password.get()!!)
        .addOnCompleteListener { Task->
            showLoading.value=false
            if (!Task.isSuccessful){
                //show error message
                    messageLiveData.value=Task.exception?.localizedMessage
                Log.e("fire base","failed"
                +Task.exception?.localizedMessage)
            }else{
                //show success message
                    messageLiveData.value="successful registration"
                Log.e("firebase","success registration")
            }
        }
}

    fun validate():Boolean {
     var valid=true
        if (firstname.get().isNullOrBlank()) {
            //set error from first name
            firstnameerror.set("please enter first name")
            valid=false
        } else {
            firstnameerror.set(null)
        }
        if (lastname.get().isNullOrBlank()) {
            lastnameerror.set("please enter lastname")
        } else {
            lastnameerror.set(null)
        }
        if (username.get().isNullOrBlank()) {
            usernameerror.set("please enter user name")
        } else {
            usernameerror.set(null)
        }
        if (email.get().isNullOrBlank()) {
            emailerror.set("please enter your email")
        } else {
            emailerror.set(null)
        }
        if (password.get().isNullOrBlank()) {
            passworderror.set("please enter your password")

        } else {
            passworderror.set(null)
        }
        return valid
    }

}
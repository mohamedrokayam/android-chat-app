package com.mabbar.regester_activity.chatApp.base

import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mabbar.regester_activity.R

open abstract class BaseActivity <DB:ViewDataBinding,VM:BaseViewModel>:AppCompatActivity(){
    lateinit var viewModel: VM
    lateinit var viewDataBinding: DB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, getlayoutId())
        viewModel = initviewmodel()
        subScribetoliveData()
    }
    fun subScribetoliveData(){
        viewModel.messageLiveData.observe(this,{


            showDialog(it,"ok")
        })
        viewModel.showLoading.observe(this,{
            show->
            if (show)

                showLoading()
            else hideLoading()


        })


    }
    var alertDialog:AlertDialog?=null;
    fun showDialog(message:String,posAtionName:String?=null,
    posAction:DialogInterface.OnClickListener?=null,
    negActionName:String?=null,negAtion:DialogInterface.OnClickListener?=null
    ,cancelable:Boolean=true){
        val defAction= DialogInterface.OnClickListener { dialog, p1 -> dialog?.dismiss() }
        val builder=AlertDialog.Builder(this)
            .setMessage(message)
        if (posAction!=null)
            builder.setPositiveButton(posAtionName,
                posAction ?: defAction
            )
        if (negActionName!=null)
            builder.setNegativeButton(negActionName,negAtion?:defAction)
        builder.setCancelable(cancelable)
        alertDialog=builder.show()
    }
    fun hideAlertDialog(){
        alertDialog?.dismiss()
        alertDialog=null
    }
    var progressDialog:ProgressDialog?=null
    fun showLoading(){
        progressDialog=ProgressDialog(this)
            progressDialog?.setMessage("Loading...")
        progressDialog?.setCancelable(false)
        progressDialog?.show()

    }
    fun hideLoading(){
        progressDialog?.dismiss()
        progressDialog=null
    }
abstract fun getlayoutId():Int
abstract fun initviewmodel():VM



}
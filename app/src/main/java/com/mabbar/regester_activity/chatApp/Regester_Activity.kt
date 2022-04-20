package com.mabbar.regester_activity.chatApp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mabbar.regester_activity.R
import com.mabbar.regester_activity.chatApp.base.BaseActivity
import com.mabbar.regester_activity.chatApp.ui.regester.RegesterviewModel
import com.mabbar.regester_activity.databinding.ActivityRegesterBinding

class Regester_Activity : BaseActivity<ActivityRegesterBinding,RegesterviewModel>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding.vm=viewModel

//
//viewDataBinding.createAccount.setOnClickListener {
//
//}
//        viewModel.createAccount()
    }

    override fun getlayoutId(): Int {
        return R.layout.activity_regester
    }

    override fun initviewmodel(): RegesterviewModel {
        return ViewModelProvider(this).get(RegesterviewModel::class.java)
    }
}
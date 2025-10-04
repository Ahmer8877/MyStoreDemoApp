package com.e.ahmer.bottomnavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set BottomNavigationView varable

        val bottomView=findViewById<BottomNavigationView>(R.id.BottomNavigationView)

        //replaceFragment func. set with HomeFarg
        replaceFragment(HomeFarg())

        //bottomView btn click code
        bottomView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.Item1 -> replaceFragment(HomeFarg())
                R.id.Item2 -> replaceFragment(SearchFarg())
                R.id.Item3 -> replaceFragment(ProfileFarg())
                else -> {

                }

            }
            true
        }


        }

    //replaceFragment func.
    private fun replaceFragment(fragment: Fragment) {

       val fragmentManager=supportFragmentManager
        val fragTrans=fragmentManager.beginTransaction()
        fragTrans.replace(R.id.frameLayout,fragment)
        fragTrans.commit()
    }
}
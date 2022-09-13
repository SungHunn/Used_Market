package com.example.usedmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.usedmarket.chatlist.ChatListFragment
import com.example.usedmarket.home.HomeFragment
import com.example.usedmarket.mypage.MyPageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomnavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        val homeFragment = HomeFragment()
        val chatlistFragment = ChatListFragment()
        val myPageFragment = MyPageFragment()

        replaceFragment(homeFragment)

        bottomnavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.home -> replaceFragment(homeFragment)

                R.id.chatList -> replaceFragment(chatlistFragment)

                R.id.mypage -> replaceFragment(myPageFragment)

            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){

        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fragmentContainer, fragment)
                commit()
            }

    }
}
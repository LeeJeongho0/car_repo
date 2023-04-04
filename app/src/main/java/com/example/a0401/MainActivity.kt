package com.example.a0401

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.viewpager2.widget.ViewPager2
import com.example.a0401.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var customAdapter: CustomAdapter
    lateinit var toggle:ActionBarDrawerToggle
    lateinit var tabTitleList:MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        customAdapter = CustomAdapter(this)
        customAdapter.addListFragment(OneFragment())
        customAdapter.addListFragment(TwoFragment())
        customAdapter.addListFragment(ThreeFragment())
        tabTitleList = mutableListOf("car1", "car2", "car3")
        binding.viewPager2.adapter = customAdapter
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // 1. 액션바대신에 툴바로 대체 BEGIN
        setSupportActionBar(binding.toolbar)
        // 2. ActionBarDrawerTogle 버튼 적용
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.drawer_open,R.string.drawer_close)
        // 3. 앱버튼 활성화
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // 4. 토글 sync
        toggle.syncState()

        TabLayoutMediator(binding.tabLayout,binding.viewPager2){ tab, position ->
            tab.text = tabTitleList.get(position)
        }.attach()
        binding.navigationView.setNavigationItemSelectedListener(object: NavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.item_callcenter -> Toast.makeText(applicationContext,"고객센터",Toast.LENGTH_SHORT).show()
                    R.id.item_stars -> {
                        val intent:Intent = Intent(applicationContext, MainActivity2::class.java)
                        startActivity(intent)
                    }

                }
                return true
            }

        })

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)

        val searchMenuItem = menu?.findItem(R.id.menuSearch)
        val searchView = searchMenuItem?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            //검색창에 검색글을 입력하고 엔터를 칠때 콜백함수
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(applicationContext, "${query}", Toast.LENGTH_SHORT).show()
                return true
            }
            //검색창에 검색글을 입력할때마다 콜백발생
            override fun onQueryTextChange(newText: String?): Boolean { Log.e("MainActivity", "${newText}")
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }



}
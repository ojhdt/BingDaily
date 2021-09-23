package com.example.bingdaily

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.example.bingdaily.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar.let {
            it?.setDisplayHomeAsUpEnabled(true)
            it?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24)
        }
        binding.nav.setCheckedItem(R.id.main)
        binding.nav.setNavigationItemSelectedListener {
            binding.drawer.closeDrawer(GravityCompat.START)
            true
        }

        binding.fab.setOnClickListener {
            refresh()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                binding.drawer.openDrawer(GravityCompat.START)
            }
            R.id.refresh -> {
                refresh()
            }
            R.id.about -> {// TODO: 2021/9/23
            }
        }
        return true
    }

    fun refresh() {}
}

package com.example.bingdaily

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bingdaily.databinding.ActivityMainBinding
import com.example.bingdaily.logic.modal.ImageData
import com.example.bingdaily.ui.image.ImageAdapter
import com.example.bingdaily.ui.image.ImageViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var imglist: List<ImageData>? = null
    lateinit var adapter: ImageAdapter
    lateinit var viewModel: ImageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        viewModel = ViewModelProvider(this)[ImageViewModel::class.java]
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

        imglist = viewModel.imageLiveData.value
        adapter = ImageAdapter(imglist)
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = adapter

        viewModel.imageLiveData.observe(this) { value -> }
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

    fun refresh() {
        imglist = viewModel.imageLiveData.value
        Snackbar.make(binding.root,"已刷新",Snackbar.LENGTH_SHORT).show()
        adapter.notifyDataSetChanged()
    }
}

package com.esq.tiktokviddownload

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var TAG: String? = MainActivity::class.simpleName
    private var mToolbar: MaterialToolbar? = null
    private var mTabLayout: TabLayout? = null
    private var mViewPager: ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mToolbar = toolbar
        setSupportActionBar(mToolbar)
        //supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        mViewPager = viewPager
        val adapter = HomeAdapter(supportFragmentManager)
        viewPager.adapter = adapter

        mTabLayout = tabs
        mTabLayout!!.setupWithViewPager(viewPager)
        mTabLayout!!.setupWithViewPager(mViewPager)
        setUpTabIcons(mTabLayout!!)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun setUpTabIcons(mTabLayout: TabLayout) {
        for (i in 0 until mTabLayout.tabCount) {
            when (i) {
                0 -> mTabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_home)
                1 -> mTabLayout.getTabAt(1)!!.setIcon(R.drawable.down_arrow)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.rate -> {
                Toast.makeText(this, "Rate", Toast.LENGTH_SHORT).show()
            }
            R.id.tiktokIcon -> {
                Toast.makeText(this, "Tik Tok", Toast.LENGTH_SHORT).show()
            }
            R.id.aboutApp -> {
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show()
            }
            R.id.howToDownload -> {
                Toast.makeText(this, "How to Donwload", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)

    }
}

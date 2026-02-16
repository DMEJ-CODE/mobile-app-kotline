package com.example.shopy

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        session = SessionManager(this)

        if (!session.isLogged()) {
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
            return
        }

        setupBottomNav()
        loadFragment(HomeFragment())
        updateNavSelection(R.id.navHome)
    }

    private fun setupBottomNav() {
        findViewById<LinearLayout>(R.id.navHome).setOnClickListener {
            loadFragment(HomeFragment())
            updateNavSelection(R.id.navHome)
        }

        findViewById<LinearLayout>(R.id.navShop).setOnClickListener {
            loadFragment(ShopFragment())
            updateNavSelection(R.id.navShop)
        }

        findViewById<LinearLayout>(R.id.navCart).setOnClickListener {
            loadFragment(CartFragment())
            updateNavSelection(R.id.navCart)
        }

        findViewById<LinearLayout>(R.id.navProfile).setOnClickListener {
            loadFragment(ProfileFragment())
            updateNavSelection(R.id.navProfile)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    private fun updateNavSelection(selectedId: Int) {
        val items = listOf(R.id.navHome, R.id.navShop, R.id.navCart, R.id.navProfile)

        items.forEach { id ->
            val layout = findViewById<LinearLayout>(id)
            val isSelected = id == selectedId

            val icon = layout.getChildAt(0) as android.widget.ImageView
            icon.setColorFilter(ContextCompat.getColor(
                this,
                if (isSelected) R.color.primary_light else R.color.text_secondary
            ))

            val text = layout.getChildAt(1) as android.widget.TextView
            text.setTextColor(ContextCompat.getColor(
                this,
                if (isSelected) R.color.primary_light else R.color.text_secondary
            ))
        }
    }
}
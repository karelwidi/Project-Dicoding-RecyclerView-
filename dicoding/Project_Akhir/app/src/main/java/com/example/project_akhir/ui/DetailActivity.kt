package com.example.project_akhir.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.project_akhir.R
import com.example.project_akhir.databinding.ActivityDetailBinding
import com.example.project_akhir.model.ShoesData

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var shoe: ShoesData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        shoe = intent.getParcelableExtra("EXTRA_SHOE")

        shoe?.let {
            binding.tvDetailName.text = it.name
            binding.tvDetailDescription.text = it.description
            binding.imgDetailPhoto.setImageResource(it.photo)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Coba lihat sepatu keren ini: ${shoe?.name}\n\n${shoe?.description}")
                startActivity(Intent.createChooser(shareIntent, "Bagikan lewat..."))
                return true
            }
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
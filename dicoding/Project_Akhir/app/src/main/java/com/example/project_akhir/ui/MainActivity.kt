package com.example.project_akhir.ui
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_akhir.R
import com.example.project_akhir.databinding.ActivityMainBinding
import com.example.project_akhir.model.ShoesData
class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    private val list = ArrayList<ShoesData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvShoes.setHasFixedSize(true)
        list.addAll(getListShoes())
        showRecyclerList()
    }

    private fun getListShoes(): ArrayList<ShoesData> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listShoe = ArrayList<ShoesData>()
        for (i in dataName.indices) {
            val shoe = ShoesData(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listShoe.add(shoe)
        }
        dataPhoto.recycle()
        return listShoe
    }

    private fun showRecyclerList() {
        binding.rvShoes.layoutManager = LinearLayoutManager(this)
        val listShoeAdapter = ListShoesAdapter(list)
        binding.rvShoes.adapter = listShoeAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
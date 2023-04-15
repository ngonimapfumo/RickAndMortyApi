package zw.co.nm.rickandmortyapi.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import zw.co.nm.rickandmortyapi.databinding.ActivityMainBinding
import zw.co.nm.rickandmortyapi.models.CharacterModel
import zw.co.nm.rickandmortyapi.models.responses.GetAllCharactersResponse
import zw.co.nm.rickandmortyapi.ui.adapters.CharacterListAdapter
import zw.co.nm.rickandmortyapi.viewmodels.GetAllCharactersViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var charArrayList: ArrayList<CharacterModel>
    private lateinit var adapter: CharacterListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        val getAllCharactersViewModel =
            ViewModelProvider(this)[GetAllCharactersViewModel::class.java]
        lifecycleScope.launchWhenStarted {
            getAllCharactersViewModel.getCharacters().collect(::response)
        }
    }

    private fun response(res: GetAllCharactersResponse?) {

        activityMainBinding.recyclerview.setHasFixedSize(true)
        activityMainBinding.recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
        charArrayList = arrayListOf()


        for (i in res?.results!!.indices) {
            val characters = CharacterModel(res.results[i].image,res.results[i].id.toString())
            charArrayList.add(characters)
        }
        adapter = CharacterListAdapter(charArrayList)
        activityMainBinding.recyclerview.adapter = adapter
        adapter.onItemClick = {
           startActivity(Intent(this@MainActivity,CharacterActivity::class.java)
               .putExtra("id",it.id))
        }



    }
}
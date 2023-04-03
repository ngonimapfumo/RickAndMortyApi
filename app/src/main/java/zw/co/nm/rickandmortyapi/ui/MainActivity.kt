package zw.co.nm.rickandmortyapi.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.launch
import zw.co.nm.rickandmortyapi.databinding.ActivityMainBinding
import zw.co.nm.rickandmortyapi.models.CharacterModel
import zw.co.nm.rickandmortyapi.models.responses.GetAllCharactersResponse
import zw.co.nm.rickandmortyapi.ui.adapters.CharacterListAdapter
import zw.co.nm.rickandmortyapi.viewmodels.GetAllCharactersViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activityMainBinding: ActivityMainBinding
    private var characterListAdapter: CharacterListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        val getAllCharactersViewModel =
            ViewModelProvider(this)[GetAllCharactersViewModel::class.java]
        lifecycleScope.launch {
            getAllCharactersViewModel.getCharacters().collect(::response)
        }
    }

    private fun response(res: GetAllCharactersResponse?) {

       var arrl = arrayListOf<CharacterModel>()

        activityMainBinding.recyclerview.setHasFixedSize(true)
        activityMainBinding.recyclerview.layoutManager= GridLayoutManager(this@MainActivity,2)
        activityMainBinding.recyclerview.adapter = CharacterListAdapter(arrl)
    }

    override fun onClick(p0: View?) {
        startActivity(Intent(this@MainActivity, CharacterActivity::class.java))

    }
}
package zw.co.nm.rickandmortyapi.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import zw.co.nm.rickandmortyapi.databinding.ActivityMainBinding
import zw.co.nm.rickandmortyapi.models.responses.GetAllCharactersResponse
import zw.co.nm.rickandmortyapi.viewmodels.GetAllCharactersViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        activityMainBinding.testButton.setOnClickListener(this)
        val getAllCharactersViewModel = ViewModelProvider(this)[GetAllCharactersViewModel::class.java]
        lifecycleScope.launch {
            getAllCharactersViewModel.getCharacters().collect(::response)
        }
    }
    private fun response(res: GetAllCharactersResponse?) {
        activityMainBinding.texter.text = res!!.results[1].name
    }

    override fun onClick(p0: View?) {
      //  val intent = Intent(this@MainActivity,CharacterActivity::class.java)
        startActivity(Intent(this@MainActivity,CharacterActivity::class.java))

    }
}
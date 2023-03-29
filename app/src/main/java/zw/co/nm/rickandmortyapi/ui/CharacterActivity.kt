package zw.co.nm.rickandmortyapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import zw.co.nm.rickandmortyapi.databinding.ActivityCharacterBinding
import zw.co.nm.rickandmortyapi.models.responses.GetSingleCharacterResponse
import zw.co.nm.rickandmortyapi.viewmodels.GetCharacterViewModel

class CharacterActivity : AppCompatActivity() {
    lateinit var activityCharacterBinding: ActivityCharacterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCharacterBinding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(activityCharacterBinding.root)
        val getCharacterViewModel = ViewModelProvider(this)[GetCharacterViewModel::class.java]

        lifecycleScope.launch {
            getCharacterViewModel.getCharacter(12).collect(::response)
        }

    }

    private fun response(res: GetSingleCharacterResponse?) {
        Picasso.get().load(res?.image).into(activityCharacterBinding.characterImg)
    }
}
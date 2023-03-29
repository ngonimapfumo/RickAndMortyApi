package zw.co.nm.rickandmortyapi.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.Flow
import zw.co.nm.rickandmortyapi.models.responses.GetSingleCharacterResponse
import zw.co.nm.rickandmortyapi.repositories.GetCharacterRepo

class GetCharacterViewModel(application: Application) : AndroidViewModel(application) {

    private val getCharacterRepo = GetCharacterRepo()

    fun getCharacter(characterId: Int): Flow<GetSingleCharacterResponse?> {
        return getCharacterRepo.getCharacter(characterId)
    }
}
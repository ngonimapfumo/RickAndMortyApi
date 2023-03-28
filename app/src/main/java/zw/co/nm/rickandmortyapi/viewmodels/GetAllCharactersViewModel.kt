package zw.co.nm.rickandmortyapi.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.Flow
import zw.co.nm.rickandmortyapi.models.responses.GetAllCharactersResponse
import zw.co.nm.rickandmortyapi.repositories.GetAllCharactersRepo


class GetAllCharactersViewModel(application: Application): AndroidViewModel(application) {
    private val getAllCharactersRepo = GetAllCharactersRepo()

    fun getCharacters(): Flow<GetAllCharactersResponse?>{
        return getAllCharactersRepo.getAllCharacters()
    }
}
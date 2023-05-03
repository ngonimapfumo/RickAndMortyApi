package zw.co.nm.rickandmortyapi.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import zw.co.nm.rickandmortyapi.models.responses.GetSingleCharacterResponse
import zw.co.nm.rickandmortyapi.network.Cache
import zw.co.nm.rickandmortyapi.network.NetworkManager

class GetCharacterRepo {

    fun getCharacter(characterId: Int): Flow<GetSingleCharacterResponse?> = flow {
        val cachedCharacter = Cache.characterMap[characterId]
        if (cachedCharacter != null) {
            emit(cachedCharacter)
        } else {
            emit(NetworkManager.apiService.getCharacterById(characterId).body())
        }
    }.flowOn(Dispatchers.IO)
}
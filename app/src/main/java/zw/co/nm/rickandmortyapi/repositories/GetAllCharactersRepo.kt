package zw.co.nm.rickandmortyapi.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import zw.co.nm.rickandmortyapi.models.responses.GetAllCharactersResponse
import zw.co.nm.rickandmortyapi.network.NetworkManager

class GetAllCharactersRepo {

    fun getAllCharacters():Flow<GetAllCharactersResponse?> = flow{
        emit(NetworkManager.apiService.getAllCharacters().body())
    }.flowOn(Dispatchers.IO)
}
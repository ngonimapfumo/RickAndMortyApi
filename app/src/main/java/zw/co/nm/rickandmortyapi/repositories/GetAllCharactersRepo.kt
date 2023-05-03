package zw.co.nm.rickandmortyapi.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import zw.co.nm.rickandmortyapi.models.responses.GetAllCharactersResponse
import zw.co.nm.rickandmortyapi.network.NetworkManager

class GetAllCharactersRepo {
    fun getAllCharacters(): Flow<zw.co.nm.rickandmortyapi.network.Response<GetAllCharactersResponse>> = flow {
        emit(apiCall { NetworkManager.apiService.getAllCharacters()})
    }.flowOn(Dispatchers.IO)


    //todo: imp DRY
    private inline fun <T> apiCall(apiCall: () -> Response<T>): zw.co.nm.rickandmortyapi.network.Response<T> {
        return try {
            zw.co.nm.rickandmortyapi.network.Response.success(apiCall.invoke())
        } catch (e: Exception) {
            zw.co.nm.rickandmortyapi.network.Response.failure(e)
        }
    }
}

package zw.co.nm.rickandmortyapi.network

import retrofit2.Response
import retrofit2.http.GET
import zw.co.nm.rickandmortyapi.models.responses.GetAllCharactersResponse

interface ApiService {
    @GET("character")
    suspend fun getAllCharacters():Response<GetAllCharactersResponse>

}
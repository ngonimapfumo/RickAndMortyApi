package zw.co.nm.rickandmortyapi.network

import retrofit2.Response
import retrofit2.http.GET
import zw.co.nm.rickandmortyapi.models.responses.GetAllCharactersResponse
import zw.co.nm.rickandmortyapi.models.responses.GetSingleCharacterResponse

interface ApiService {
    @GET("character")
    suspend fun getAllCharacters(): Response<GetAllCharactersResponse>
    @GET("character/{id}")
    suspend fun getCharacterById(id: Int): Response<GetSingleCharacterResponse>


}
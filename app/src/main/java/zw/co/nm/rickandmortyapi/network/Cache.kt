package zw.co.nm.rickandmortyapi.network

import zw.co.nm.rickandmortyapi.models.CharacterModel
import zw.co.nm.rickandmortyapi.models.responses.GetSingleCharacterResponse

object Cache {
    val characterMap = mutableMapOf<Int, GetSingleCharacterResponse>()
}
package com.umutcansahin.refreshtokenwithretrofitandinterceptor.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutcansahin.refreshtokenwithretrofitandinterceptor.data.api.RickAndMortyApi
import com.umutcansahin.refreshtokenwithretrofitandinterceptor.data.dto.CharacterResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
private val rickAndMortyApi: RickAndMortyApi
):ViewModel() {

    private val _character = MutableLiveData<CharacterResponse>()
    val character: LiveData<CharacterResponse> = _character

    fun getCharacter() {
        viewModelScope.launch {
            _character.postValue(rickAndMortyApi.getCharacterById())
        }

    }
}
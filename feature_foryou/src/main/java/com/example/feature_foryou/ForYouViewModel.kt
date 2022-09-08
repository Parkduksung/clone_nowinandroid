package com.example.feature_foryou

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


//SavedStateHandle 의 어노테이션으로 추가.
@OptIn(SavedStateHandleSaveableApi::class)
@HiltViewModel
class ForYouViewModel @Inject constructor(

    savedStateHandle: SavedStateHandle
) : ViewModel(){
}
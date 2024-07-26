package com.rakarguntara.noteappcompose.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rakarguntara.noteappcompose.models.NotesModel
import com.rakarguntara.noteappcompose.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesScreensViewModel @Inject constructor(private val repository: NotesRepository) : ViewModel() {
    private val _noteList = MutableStateFlow<List<NotesModel>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNote().distinctUntilChanged()
                .collect{ list ->
                    if(list.isNotEmpty()){
                        _noteList.value = list
                    }
                }
        }
    }

    fun addNoteList(notesModel: NotesModel) = viewModelScope.launch {
        repository.addNote(notesModel)
    }

    fun removeNoteList(notesModel: NotesModel) = viewModelScope.launch {
        repository.deleteNote(notesModel)
    }

    fun removeAllNoteList() = viewModelScope.launch {
        repository.deleteAllNote()
    }

    fun updateNote(notesModel: NotesModel) = viewModelScope.launch {
        repository.updateNote(notesModel)
    }
}
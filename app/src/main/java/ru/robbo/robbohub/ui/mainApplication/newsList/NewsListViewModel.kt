package ru.robbo.robbohub.ui.mainApplication.newsList

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.robbo.robbohub.domain.model.NewsEntity
import ru.robbo.robbohub.domain.usecase.authorization.AuthorizationUseCases
import ru.robbo.robbohub.domain.usecase.news.GetNewsListUseCase
import ru.robbo.robbohub.domain.usecase.news.NewsUseCases
import ru.robbo.robbohub.ui.authorization.LoginMode
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {
    var newsList = mutableStateListOf<NewsEntity>()

    init {
        //getNews()
        //newsList.add(NewsEntity("1","test","test","test","rsger"))

        viewModelScope.launch(Dispatchers.IO) {
           // newsUseCases.insertNewUseCase(
           //     description = "test",
           //     name = "test",
           //     text = "test"
           // )
        }
    }
    fun getNews() {


        viewModelScope.launch(Dispatchers.IO) {
            newsList.clear()
            newsList.addAll(newsUseCases.getNewsListUseCase.invoke())
        }
    }

}

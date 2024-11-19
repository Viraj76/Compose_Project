package com.appsv.composeproject.pagination_practice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.appsv.composeproject.pagination_practice.data.remote.AirlineAPI
import com.appsv.composeproject.pagination_practice.paging.FakePagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import org.jetbrains.annotations.ApiStatus
import org.koin.androidx.compose.inject
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import javax.inject.Inject

//@HiltViewModel
class HomeViewModel  : ViewModel(), KoinComponent {

    val airlineAPI : AirlineAPI by inject()

    val pager = Pager(
        config = PagingConfig(pageSize = 10, prefetchDistance = 5),
        pagingSourceFactory = { FakePagingSource(apiService = airlineAPI) }
    ).flow.cachedIn(viewModelScope)


}
package com.appsv.composeproject.pagination_practice.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.appsv.composeproject.pagination_practice.data.remote.AirlineAPI
import com.appsv.composeproject.pagination_practice.dto.Data
import java.lang.Exception
import javax.inject.Inject

class FakePagingSource @Inject constructor(private val apiService: AirlineAPI) : PagingSource<Int, Data>(){

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
     return  try{
            val prev = params.key?:0
            val response = apiService.getAirlineResponse(page=prev,size=params.loadSize)
            if(response.isSuccessful){
                val body = response.body()?.data
                LoadResult.Page(
                    data= body!!,
                    prevKey = if(prev==0) null else prev-1,
                    nextKey = if(body.size<params.loadSize) null else prev+1
                )

            }else{
                LoadResult.Error(Exception())
            }
        }catch (e:Exception){
         Log.d("TAG", "load: ${e.printStackTrace()}")
            LoadResult.Error(e)
        }
    }
}
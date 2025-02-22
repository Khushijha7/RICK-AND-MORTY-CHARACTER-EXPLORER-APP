package eu.tutorials.assignment_task1.api

import eu.tutorials.assignment_task1.model.ApiData
import retrofit2.Call
import eu.tutorials.assignment_task1.model.Shopping
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET



interface ApiInterface {
    @GET("/v1/characters")
     fun getData(): Call<ApiData>
//    suspend fun getData(): Response<ApiData>
}
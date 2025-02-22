package eu.tutorials.assignment_task1.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import eu.tutorials.assignment_task1.api.ApiInterface
import eu.tutorials.assignment_task1.model.ApiData
import eu.tutorials.assignment_task1.model.Shopping
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItemViewModel : ViewModel() {
    private var itemArrayList: ArrayList<Shopping> = ArrayList()
    private var _item = MutableLiveData<ArrayList<Shopping>>()
    val item: LiveData<ArrayList<Shopping>> = _item
    lateinit var DataItem: Shopping

    init {

        val api = Retrofit.Builder()
            .baseUrl("https://api.potterdb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        api.getData().enqueue(object : Callback<ApiData> {
            override fun onResponse(
                call: Call<ApiData>,
                response: Response<ApiData>
            ) {
                for (item in response.body()!!.data) {
                    val dataList = Shopping(
                        item.attributes.image,
                        item.attributes.name,
                        item.attributes.height
                    )
                    if (item.attributes.image != null) {
                        itemArrayList.add(dataList)
                    }
                }
                _item.value = itemArrayList

            }


            override fun onFailure(call: Call<ApiData>, t: Throwable) {
//                Log.i("Api", "failure")
            }
        })

    }


}












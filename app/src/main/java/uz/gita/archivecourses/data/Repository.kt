package uz.gita.archivecourses.data

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.gita.archivecourses.data.internet.CourseRetrofit
import uz.gita.archivecourses.data.room.AppDatabase
import uz.gita.archivecourses.data.room.entities.CourseApi
import uz.gita.archivecourses.data.room.entities.CourseEntity

class Repository {
    private val roomDatabase = AppDatabase.getDatabase()
    private val courseDao = roomDatabase.wordDao()
    private val courseService = CourseRetrofit.getRetrofit()

    private lateinit var listener: (List<CourseApi>) -> Unit
    fun setListener(a: ((List<CourseApi>) -> Unit)) {
        listener = a
    }

    fun getAndSave(url: String) {
        val call: Call<List<CourseApi>> = courseService.get(url)
        call.enqueue(object : Callback<List<CourseApi>> {
            override fun onResponse(call: Call<List<CourseApi>>, response: Response<List<CourseApi>>) {
//                for (a in response.body()!!) {
//                    val courseEntity = CourseEntity(0, a.Ccy, a.CcyNm_EN, a.CcyNm_RU, a.CcyNm_UZ, a.CcyNm_UZC, a.Code, a.Date, a.Diff, a.Nominal, a.Rate)
//                    courseDao.insert(courseEntity)
//                }
                Log.d("YYY", "onResponse: ${response.body()}")
                listener.invoke(response.body()!!)
            }

            override fun onFailure(call: Call<List<CourseApi>>, t: Throwable) {

            }
        })
    }

    fun get() {
        val call: Call<List<CourseApi>> = courseService.getAll()
        call.enqueue(object : Callback<List<CourseApi>> {
            override fun onResponse(call: Call<List<CourseApi>>, response: Response<List<CourseApi>>) {
                listener.invoke(response.body()!!)
            }

            override fun onFailure(call: Call<List<CourseApi>>, t: Throwable) {
                listener.invoke(emptyList())
            }
        })
    }
}
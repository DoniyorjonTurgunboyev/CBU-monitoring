package uz.gita.archivecourses.data.internet

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CourseRetrofit {
    companion object {
        private var instance: Retrofit? = null
        fun getRetrofit(): CourseService {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl("https://cbu.uz/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance!!.create(CourseService::class.java)
        }
    }
}
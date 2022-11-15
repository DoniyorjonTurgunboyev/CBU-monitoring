package uz.gita.archivecourses.data.internet

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class CourseRetrofit {
    companion object {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        private var instance: Retrofit? = null
        fun getRetrofit(): CourseService {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl("https://cbu.uz/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return instance!!.create(CourseService::class.java)
        }
    }
}
package uz.gita.archivecourses.data.internet

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url
import uz.gita.archivecourses.data.room.entities.CourseApi
import uz.gita.archivecourses.data.room.entities.CourseEntity

interface CourseService {
    @GET()
    fun get(@Url url: String): Call<List<CourseApi>>

    @GET("uz/arkhiv-kursov-valyut/json/all/2022-06-14/")
    fun getAll(): Call<List<CourseApi>>
}
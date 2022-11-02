package uz.gita.archivecourses.data.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.gita.archivecourses.data.room.entities.CourseEntity

@Dao
interface CourseDao {
    @Query("SELECT * FROM CourseEntity")
    fun getAll(): Flow<List<CourseEntity>>

    @Insert()
    fun insert(courseEntity: CourseEntity)
}
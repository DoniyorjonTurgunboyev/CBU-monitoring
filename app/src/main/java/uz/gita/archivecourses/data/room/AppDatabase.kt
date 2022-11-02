package uz.gita.archivecourses.data.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.archivecourses.app.App
import uz.gita.archivecourses.data.room.daos.CourseDao
import uz.gita.archivecourses.data.room.entities.CourseEntity

@Database(entities = [CourseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wordDao(): CourseDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(): AppDatabase {
            return instance ?: synchronized(this) {
                val _instance = Room.databaseBuilder(App.instance, AppDatabase::class.java, "database")
                    .allowMainThreadQueries()
                    .build()
                instance = _instance
                _instance
            }
        }
    }
}
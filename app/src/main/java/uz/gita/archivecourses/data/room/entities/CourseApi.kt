package uz.gita.archivecourses.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CourseApi(
    val Ccy: String,
    val CcyNm_UZ: String,
    val Code: String,
    val Diff: String,
    val Rate: String
)
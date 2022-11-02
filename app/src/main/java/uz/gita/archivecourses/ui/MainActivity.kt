package uz.gita.archivecourses.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import uz.gita.archivecourses.R
import uz.gita.archivecourses.data.Repository
import uz.gita.archivecourses.ui.adapters.Adapter
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class MainActivity : AppCompatActivity() {
    private val repository = Repository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)+1
        var day = c.get(Calendar.DAY_OF_MONTH)
        val rv = findViewById<RecyclerView>(R.id.rv)
        val date = findViewById<ImageView>(R.id.date)
        val dateTime = findViewById<TextView>(R.id.textDate)
        dateTime.text = "$year-$month-$day"
        date.setOnClickListener {
            val dpd = DatePickerDialog(this, { view, y, monthOfYear, dayOfMonth ->
                val s = "$y-${monthOfYear+1}-$dayOfMonth"
                year = y
                month = monthOfYear+1
                day = dayOfMonth
                dateTime.text = s
                repository.getAndSave("uz/arkhiv-kursov-valyut/json/all/$s/")
            }, year, month-1, day)

            dpd.show()
        }
        repository.get()
        var adapter: Adapter
        repository.setListener {
            adapter = Adapter(it, this)
            rv.adapter = adapter
            adapter.notifyDataSetChanged()
        }

//        findViewById<TextView>(R.id.text).setOnClickListener {
//            for (year in 1995..2021) {
//                Log.d("TTT", "onCreate: $year")
//                for (month in 1..12) {
//                    repository.getAndSave("uz/arkhiv-kursov-valyut/json/all/$year-$month-11/")
//                }
//            }
//        }
////        uz/arkhiv-kursov-valyut/json/all/1994-10-15/
    }
}
package uz.gita.archivecourses.ui

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.klim.tcharts.TChart
import com.klim.tcharts.entities.ChartData
import com.klim.tcharts.entities.ChartItem
import uz.gita.archivecourses.R
import java.util.*

class ChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chart)
        val keys = ArrayList<String>() //keys for each chart
        val names = ArrayList<String>() //names for chart
        val colors = ArrayList<Int>() //colors for lines
        val items = ArrayList<ChartItem>() //charts value for some time
        //ChartItem
// time - time point (on x line)
// values - list values for this moment of time in order from keys
        keys.add("y0")
        keys.add("y1")
        names.add("Red Line")
        names.add("Green Line")
        colors.add(Color.RED)
        colors.add(Color.GREEN)
        var startTime = 1614542230000L
        val random = Random()
        for (i in 0..99) {
            //time moment
            startTime += 86400000

            //all values for this time moment
            val values = ArrayList<Int>()
            for (j in keys.indices) {
                values.add(random.nextInt(1000))
            }
            val chartItem = ChartItem(startTime, values)
            items.add(chartItem)
        }
//        val chartData = ChartData(keys, names, colors, items)
//        val tChart = TChart(this)
//        val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
//        tChart.layoutParams = layoutParams
//        tChart.id = View.generateViewId()
//        tChart.setData(chartData, true)
//        tChart.setTitle(String.format("Chart #%d", i))
//        layout.addView(tChart)
    }
}
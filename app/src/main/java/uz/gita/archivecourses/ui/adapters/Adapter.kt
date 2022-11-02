package uz.gita.archivecourses.ui.adapters

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import uz.gita.archivecourses.R
import uz.gita.archivecourses.data.room.entities.CourseApi
import uz.gita.archivecourses.ui.adapters.Adapter.VH
import uz.gita.archivecourses.utils.inflate

class Adapter(var list: List<CourseApi>, var context: Context) : RecyclerView.Adapter<VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VH(parent.inflate(R.layout.item))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.onBind(position)

    override fun getItemCount() = list.size

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var name: TextView
        private var code: TextView
        private var rate: TextView
        private var dif: TextView
        private var kursName: TextView
        private var image: ImageView
        private var difImage: ImageView
        private var anim: ConstraintLayout
        fun onBind(position: Int) {
            val c: CourseApi = list[position]
            name.text = "1 ${c.Ccy}"
            code.text = "Code ${c.Code}"
            rate.text = c.Rate
            dif.text = c.Diff
            if (c.Diff.startsWith("-")) {
                difImage.setImageResource(R.drawable.ic_down)
                anim.setBackgroundResource(R.drawable.red_anim)
            } else if (c.Diff == "0" || c.Diff == "0.00") {
                difImage.setImageResource(R.drawable.remove)
                anim.setBackgroundResource(R.drawable.yellow_anim)
            } else {
                difImage.setImageResource(R.drawable.ic_up)
                anim.setBackgroundResource(R.drawable.green_anim)
            }
            val animator: AnimationDrawable = anim.background as AnimationDrawable
            animator.start()
            var imageR: String = c.Ccy.lowercase()
            if (imageR == "try") {
                imageR = "tryy"
            }
            val resourceId = context.resources.getIdentifier(imageR, "drawable", context.packageName)
            image.setImageResource(resourceId)
            kursName.text = c.CcyNm_UZ
        }

        init {
            name = itemView.findViewById(R.id.name)
            code = itemView.findViewById(R.id.code)
            rate = itemView.findViewById(R.id.rate)
            dif = itemView.findViewById(R.id.dif)
            image = itemView.findViewById(R.id.image)
            difImage = itemView.findViewById(R.id.difImage)
            kursName = itemView.findViewById(R.id.kursName)
            anim = itemView.findViewById(R.id.anim)

        }
    }
}
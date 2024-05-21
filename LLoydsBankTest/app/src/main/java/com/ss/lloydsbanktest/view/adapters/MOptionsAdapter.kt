package com.ss.lloydsbanktest.view.adapters
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ss.lloydsbanktest.R
import com.ss.lloydsbanktest.model.MOptions
import com.ss.lloydsbanktest.view.HomeAct
import java.util.Date

class MOptionsAdapter(val homeAct: HomeAct, private val dataSet: List<MOptions>) :
    RecyclerView.Adapter<MOptionsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val optionLay:RelativeLayout
        val optionTitle: TextView
        val optionSubTitle: TextView
        val optionDate:TextView
        val optionImg:ImageView
        init {
            optionTitle = view.findViewById(R.id.optionTitle)
            optionSubTitle  = view.findViewById(R.id.optionSubTitle)
            optionDate  = view.findViewById(R.id.optionDate)
            optionImg  = view.findViewById(R.id.optionImg)
            optionLay = view.findViewById(R.id.optionLay)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.moptions_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.optionTitle.text = dataSet.get(position).title
        viewHolder.optionSubTitle.text = dataSet.get(position).desc
        viewHolder.optionDate.text = Date().toString()
        viewHolder.optionImg.setBackgroundResource(dataSet.get(position).img);

        viewHolder.optionLay.setOnClickListener(){

            if(position==0){
                homeAct.goToBooksAct()
            }else  if(position==1){
                homeAct.goToWeasleyAct()
            }else  if(position==2){
                homeAct.goToSpellAct()
            }
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

package com.ss.lloydsbanktest.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ss.lloydsbanktest.R
import com.ss.lloydsbanktest.model.Spells
import java.util.Date

class SpellsAdapter(private val dataSet: List<Spells>) :
    RecyclerView.Adapter<SpellsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val spellsTitle: TextView
        val spellsUse: TextView
        val spellsDate: TextView
        val spellsRowImg: ImageView
        init {
            spellsTitle = view.findViewById(R.id.spellsTitle)
            spellsUse  = view.findViewById(R.id.spellsUse)
            spellsDate  = view.findViewById(R.id.spellsDate)
            spellsRowImg  = view.findViewById(R.id.spellsRowImg)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.spells_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.spellsTitle.text = dataSet.get(position).spell
        viewHolder.spellsUse.text = dataSet.get(position).use
        viewHolder.spellsDate.text = Date().toString()
        //viewHolder.bookRowImg.setBackgroundResource(dataSet.get(position).img);

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
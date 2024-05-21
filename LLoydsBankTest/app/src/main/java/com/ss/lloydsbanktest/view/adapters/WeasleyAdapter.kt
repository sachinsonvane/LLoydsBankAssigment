package com.ss.lloydsbanktest.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ss.lloydsbanktest.R
import com.ss.lloydsbanktest.model.Books
import com.ss.lloydsbanktest.model.MOptions
import com.ss.lloydsbanktest.model.Weasley
import com.ss.lloydsbanktest.view.BooksAct
import com.ss.lloydsbanktest.view.MainActivity
import java.util.Date

class WeasleyAdapter(private val dataSet: List<Weasley>) :
    RecyclerView.Adapter<WeasleyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val weasleyName: TextView
        val weasleyHogwartsHouse: TextView
        val weasleyInterpretedBy: TextView
        val weasleyBirthdate: TextView
        val weasleyRowImg: ImageView
        init {
            weasleyName = view.findViewById(R.id.weasleyName)
            weasleyHogwartsHouse  = view.findViewById(R.id.weasleyHogwartsHouse)
            weasleyInterpretedBy  = view.findViewById(R.id.weasleyInterpretedBy)
            weasleyBirthdate  = view.findViewById(R.id.weasleyBirthdate)
            weasleyRowImg  = view.findViewById(R.id.weasleyRowImg)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.weasley_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.weasleyName.text = dataSet.get(position).fullName
        viewHolder.weasleyHogwartsHouse.text = dataSet.get(position).hogwartsHouse
        viewHolder.weasleyInterpretedBy.text = dataSet.get(position).interpretedBy
        viewHolder.weasleyBirthdate.text = dataSet.get(position).birthdate
        //viewHolder.bookRowImg.setBackgroundResource(dataSet.get(position).img);

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
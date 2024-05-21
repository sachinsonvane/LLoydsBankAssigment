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
import com.ss.lloydsbanktest.view.BooksAct
import com.ss.lloydsbanktest.view.MainActivity
import java.util.Date

class BooksAdapter(private val dataSet: List<Books>) :
    RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val bookRowTitle: TextView
        val bookRowSubTitle: TextView
        val releaseDateDate: TextView
        val bookRowImg: ImageView
        init {
            bookRowTitle = view.findViewById(R.id.bookRowTitle)
            bookRowSubTitle  = view.findViewById(R.id.bookRowSubTitle)
            releaseDateDate  = view.findViewById(R.id.releaseDateDate)
            bookRowImg  = view.findViewById(R.id.bookRowImg)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.books_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.bookRowTitle.text = dataSet.get(position).title
        viewHolder.bookRowSubTitle.text = dataSet.get(position).originalTitle
        viewHolder.releaseDateDate.text = dataSet.get(position).releaseDate
        //viewHolder.bookRowImg.setBackgroundResource(dataSet.get(position).img);

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
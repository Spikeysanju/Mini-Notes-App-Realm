package www.sanju.todonotes.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults
import kotlinx.android.synthetic.main.todo_rv_layout.view.*
import kotlinx.android.synthetic.main.todo_staggered_rv.view.*
import www.sanju.todonotes.Model.Todo
import www.sanju.todonotes.R

class TodoAdapter(val context: Context?, private val todoList: RealmResults<Todo>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        holder.itemView.stag_Title.text = todoList[position]!!.title
        holder.itemView.stag_desc.text = todoList[position]!!.description
        holder.itemView.stag_id.text = todoList[position]!!.id.toString()




    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.todo_staggered_rv, parent, false)
        return ViewHolder(v)


    }

    override fun getItemCount(): Int {
        return todoList.size
    }

}

class ViewHolder(v: View?) : RecyclerView.ViewHolder(v!!), View.OnClickListener {
    override fun onClick(v: View?) {


    }

    init {
        itemView.setOnClickListener(this)
    }


    val title = itemView.findViewById<TextView>(R.id.titleTV)
    val desc = itemView.findViewById<TextView>(R.id.descTV)
    val id = itemView.findViewById<TextView>(R.id.idNumber)






}
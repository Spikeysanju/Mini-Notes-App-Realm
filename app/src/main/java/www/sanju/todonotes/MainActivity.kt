package www.sanju.todonotes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_main.*
import www.sanju.todonotes.Activity.AddNotesActivity
import www.sanju.todonotes.Adapter.TodoAdapter
import www.sanju.todonotes.Model.Todo


class MainActivity : AppCompatActivity() {

    private lateinit var realm: Realm
    private  var todolist = ArrayList<Todo>()
    private lateinit var addNotes: FloatingActionButton



    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init realm
        realm = Realm.getDefaultInstance()


        //init views
        val  todoRV = findViewById<RecyclerView>(R.id.todoRV)
        addNotes = findViewById(R.id.addNotes)

//        // layout manager
//        todoRV.layoutManager = LinearLayoutManager(
//            this,
//            LinearLayout.VERTICAL, false
//        )

        todoRV.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)


        addNotes.setOnClickListener {

            startActivity(Intent(this,AddNotesActivity::class.java))
        }

        getAllTodo()

        addNotes.setOnLongClickListener {



                realm.beginTransaction()
                realm.deleteAll()
                realm.commitTransaction()

            getAllTodo()

            return@setOnLongClickListener true

        }


    }


    private fun getAllTodo() {


        todolist = ArrayList()

        val results: RealmResults<Todo> = realm.where<Todo>(
            Todo::class.java
        ).findAll()


        todoRV.adapter = TodoAdapter(this, results)





    }

}


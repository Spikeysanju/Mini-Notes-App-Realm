package www.sanju.todonotes.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import io.realm.Realm
import www.sanju.todonotes.Interface.TodoModel
import www.sanju.todonotes.MainActivity
import www.sanju.todonotes.Model.Todo
import www.sanju.todonotes.R

class AddNotesActivity : AppCompatActivity() {

    private lateinit var titleET:EditText
    private lateinit var descET:EditText
    private lateinit var saveBtn:Button
    private lateinit var realm: Realm
    private lateinit var helper:TodoModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)


        realm = Realm.getDefaultInstance()

        //init views

        titleET = findViewById(R.id.titleET)
        descET = findViewById(R.id.descET)
        saveBtn = findViewById(R.id.saveBtn)

        saveBtn.setOnClickListener {

            saveData()
        }

    }

    private fun saveData() {


        try {


            helper = TodoModel()
            val task = Todo()
            task.title = titleET.text.toString()
            task.description = descET.text.toString()

            //saving to Database
            helper.addTodo(realm,task)
            Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()

            startActivity(Intent(this,MainActivity::class.java))
            finish()



        } catch (e:Exception){

            Toast.makeText(this,"Failure",Toast.LENGTH_SHORT).show()

        }

    }
}

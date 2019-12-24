package www.sanju.todonotes.Interface

import io.realm.Realm
import www.sanju.todonotes.Model.Todo


class TodoModel :TodoInterface{



    override fun addTodo(realm: Realm, todo: Todo): Boolean {

        return try {
            realm.beginTransaction()

            val currentIdNum: Number? = realm.where(Todo::class.java).max("id")

            val nextId: Int

            nextId = if (currentIdNum == null) {
                1
            } else {
                currentIdNum.toInt() + 1
            }

            todo.id = nextId

            realm.copyToRealmOrUpdate(todo)

            realm.commitTransaction()

            true
        } catch (e: Exception) {
            println(e)
            false
        }

    }

    override fun deleteTodo(realm: Realm, int: Int): Boolean {

        try {
            realm.beginTransaction()
            realm.where(Todo :: class.java).equalTo("id",int).findFirst()?.deleteFromRealm()
            realm.commitTransaction()
            return true
        } catch (e: Exception) {
            println(e)
            return false
        }
    }

    override fun updateTodo(realm: Realm, todo: Todo): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}





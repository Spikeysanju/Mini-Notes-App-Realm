package www.sanju.todonotes.Interface

import io.realm.Realm
import io.realm.RealmResults
import www.sanju.todonotes.Model.Todo

interface TodoInterface {

    fun addTodo(realm: Realm, todo: Todo):Boolean
    fun deleteTodo(realm: Realm,id: Int):Boolean
    fun updateTodo(realm: Realm, todo: Todo):Boolean


}
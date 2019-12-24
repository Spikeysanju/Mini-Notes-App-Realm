package www.sanju.todonotes.Model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Todo(

    @PrimaryKey
    var id:Int?=null,
    var title: String?= null,
    var description: String?= null
) : RealmObject()
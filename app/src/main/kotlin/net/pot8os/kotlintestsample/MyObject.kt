package net.pot8os.kotlintestsample

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

/**
 * Created by lionzxy on 19.08.17.
 */
@Entity(tableName = MyObject.TABLE_NAME,
        indices = arrayOf(Index("id", unique = true)))
data class MyObject(
        @PrimaryKey
        var id: Int,
        var text: String
) {
    constructor() : this(0, "")

    companion object {
        const val TABLE_NAME = "test"
    }
}
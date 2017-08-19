package net.pot8os.kotlintestsample

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

/**
 * Created by lionzxy on 19.08.17.
 */
@Dao
interface MyDao{
    @Query("SELECT * FROM ${MyObject.TABLE_NAME} WHERE id= :arg0")
    fun getById(id: Int): MyObject
}
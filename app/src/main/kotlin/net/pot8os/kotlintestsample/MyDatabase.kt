package net.pot8os.kotlintestsample

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters

/**
 * Created by lionzxy on 19.08.17.
 */
@Database(entities = arrayOf(MyObject::class), version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun myDao(): MyDao
}
package com.nihal.scribblesphere.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nihal.scribblesphere.data.converters.CollectionConverter
import com.nihal.scribblesphere.data.converters.DateTypeConverter
import com.nihal.scribblesphere.data.converters.LocalDateTimeConverter
import com.nihal.scribblesphere.data.converters.UriConverter
import com.nihal.scribblesphere.data.dao.NoteDao
import com.nihal.scribblesphere.data.dao.TrashNoteDao
import com.nihal.scribblesphere.domain.models.Note
import com.nihal.scribblesphere.domain.models.TrashNote

@Database(entities = [Note::class, TrashNote::class], version = 6)
@TypeConverters(
    DateTypeConverter::class,
    UriConverter::class,
    CollectionConverter::class,
    LocalDateTimeConverter::class
)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
    abstract val trashNote: TrashNoteDao

    companion object {
        @Suppress("ktlint:standard:property-naming")
        private var INSTANCE: NoteDatabase? = null
        fun getInstance(context: Context): NoteDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "Note_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

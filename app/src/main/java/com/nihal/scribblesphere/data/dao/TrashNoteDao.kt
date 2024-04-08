package com.nihal.scribblesphere.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.nihal.scribblesphere.domain.models.TrashNoteWithNotes
import com.nihal.scribblesphere.domain.models.TrashNote

@Dao
interface TrashNoteDao {
    @Query("SELECT * FROM TrashNote")
    suspend fun getTrashNote(): List<TrashNote>

    @Query("DELETE FROM TrashNote Where noteId = :noteId")
    suspend fun deleteTrashNoteById(noteId: Int)

    @Upsert
    suspend fun upsertTrashNote(trashNote: TrashNote)

    @Transaction
    @Query("SELECT * FROM TrashNote ")
    suspend fun getTrashNoteWithNote(): List<TrashNoteWithNotes>
}

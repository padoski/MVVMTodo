package com.codinginflow.mvvmtodo.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_table")
    fun getTasks():Flow<List<Task>>//nie potrzebujemy tutaj suspend bo caly suspend i jego magia dzieje sie we flow

    @Insert(onConflict = OnConflictStrategy.REPLACE) // to w konstruktorze mowi o tym, co sie powinno stac gdy bedzie chcieli dodac task z id ktory juz istnieje, wtedy powinnien zostac zamieniony
    suspend fun insert(task: Task)
    @Update
    suspend fun update(task:Task)

    @Delete
    suspend fun delete(task: Task)

}
package com.bignerdranch.android.criminalintent.database

import androidx.room.*
import com.bignerdranch.android.criminalintent.Koala
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface KoalaDao {
    @Query("SELECT * FROM koala")
    fun getCrimes(): Flow<List<Koala>>

    @Query("SELECT * FROM koala WHERE id=(:id)")
    suspend fun getCrime(id: UUID): Koala

    @Update
    suspend fun updateCrime(koala: Koala)

    @Insert
    suspend fun addCrime(koala: Koala)

    @Delete
    suspend fun deleteRecord(koala: Koala)
}

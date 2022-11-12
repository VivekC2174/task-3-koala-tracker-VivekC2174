package com.bignerdranch.android.criminalintent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity
data class Koala(
    @PrimaryKey val id: UUID,
    val title: String,
    val date: Date,
/*    val place: String,*/
    val isSolved: Boolean,
    val suspect: String = "",
    val photoFileName: String? = null
)

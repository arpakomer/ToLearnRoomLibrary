package com.arpak.tolearnroomlibrary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "persons")
data class Persons(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id") @NotNull var id: Int,
    @ColumnInfo(name =  "person_name") @NotNull var name: String,
    @ColumnInfo(name = "person_age") @NotNull var age: Int,
    @ColumnInfo(name = "person_tell") @NotNull var tell: String
)

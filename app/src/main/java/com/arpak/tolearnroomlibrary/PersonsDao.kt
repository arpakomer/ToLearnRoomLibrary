package com.arpak.tolearnroomlibrary

import androidx.core.app.Person
import androidx.room.*

@Dao
interface PersonsDao {

    @Query("SELECT * FROM persons")
    suspend fun allPersons(): List<Persons>

    @Insert
    suspend fun addPerson(person: Persons)

    @Update
    suspend fun updatePerson(person: Persons)

    @Delete
    suspend fun deletePerson(person: Persons)

    @Query("SELECT * FROM persons ORDER BY RANDOM() LIMIT 2")
    suspend fun getRandomToLimit(): List<Persons>

    @Query("SELECT * FROM persons  WHERE person_name LIKE '%' || :searchWord || '%' ")
    suspend fun searchPerson(searchWord: String): List<Persons>

    @Query("SELECT * FROM persons WHERE  person_id=:person_id")
    suspend fun bringAPerson(person_id: Int): Persons

    @Query("Select count(*) From persons Where person_name=:person_name")
    suspend fun insertControl(person_name: String): Int
}
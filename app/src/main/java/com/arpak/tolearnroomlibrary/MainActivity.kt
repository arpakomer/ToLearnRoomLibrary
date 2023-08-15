package com.arpak.tolearnroomlibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var database: PersonsDatabase
    private lateinit var personDao: PersonsDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = PersonsDatabase.accessToDatabase(this)!!

        personDao = database.getPersonsDao()

//        addPersonsDatabase()

//        updatePersonsDatabase()

//        deletePersonsDatabase()

//       getRandomPersonsDatabase()
//
//        searchPersonsDatabase()

//        getAllPersons()

//        BringAPersonsDatabase()

        controlPersonDatabase()
    }

    private fun getAllPersons() {
        val job = CoroutineScope(Dispatchers.Main).launch {

            val incomingList = personDao.allPersons()

            for (p in incomingList) {

                Log.e("persons_id", p.id.toString())
                Log.e("persons_ad", p.name)
                Log.e("persons_age", p.age.toString())
                Log.e("persons_tell", p.tell)
            }
        }
    }

    private fun addPersonsDatabase() {
        val job = CoroutineScope(Dispatchers.Main).launch {

            val newToAdd = Persons(0, "Omer", 22, "098765433234")

            personDao.addPerson(newToAdd)
        }
    }

    private fun updatePersonsDatabase() {
        val job = CoroutineScope(Dispatchers.Main).launch {

            val exitsToUpdateDatabase = Persons(3, "New Omer", 17, "5468454654")

            personDao.updatePerson(exitsToUpdateDatabase)
        }
    }

    private fun deletePersonsDatabase() {

        val job = CoroutineScope(Dispatchers.Main).launch {

            val exitsPersonsInDatabase = Persons(3, "New Omer", 17, "5468454654")

            personDao.deletePerson(exitsPersonsInDatabase)
        }
    }


    private fun getRandomPersonsDatabase() {
        val job = CoroutineScope(Dispatchers.Main).launch {

            val incomingList = personDao.getRandomToLimit()

            for (p in incomingList) {

                Log.e("persons_id", p.id.toString())
                Log.e("persons_ad", p.name)
                Log.e("persons_age", p.age.toString())
                Log.e("persons_tell", p.tell)
            }
        }
    }

    private fun searchPersonsDatabase() {
        val job = CoroutineScope(Dispatchers.Main).launch {

            val incomingList = personDao.searchPerson("e")
            for (p in incomingList) {

                Log.e("persons_id", p.id.toString())
                Log.e("persons_ad", p.name)
                Log.e("persons_age", p.age.toString())
                Log.e("persons_tell", p.tell)
            }
        }
    }

    private fun BringAPersonsDatabase() {
        val job = CoroutineScope(Dispatchers.Main).launch {

            val incomingPerson = personDao.bringAPerson(2)

            Log.e("person_id", incomingPerson.id.toString())
            Log.e("person_name", incomingPerson.name)
            Log.e("person_age", incomingPerson.age.toString())
            Log.e("person_tell", incomingPerson.tell)
        }

    }

    private fun controlPersonDatabase() {
        val job = CoroutineScope(Dispatchers.Main).launch {

            val incomingPerson = personDao.insertControl("Omer")

            Log.e("Result a insert control", incomingPerson.toString())

        }

    }
}
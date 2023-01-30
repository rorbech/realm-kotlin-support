package com.example.github1252

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val realm = Realm.open(RealmConfiguration.create(setOf(Sample::class)))
        realm.writeBlocking { copyToRealm(Sample()) }

        Log.d("HILTTEST", "${realm.query<Sample>().find().size}")
    }
}

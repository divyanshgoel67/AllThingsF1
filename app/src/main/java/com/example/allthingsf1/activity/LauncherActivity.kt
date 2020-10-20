package com.example.allthingsf1.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.allthingsf1.F1SharedPreference
import com.example.allthingsf1.R
import com.example.allthingsf1.RepositoryManager
import com.example.f1repository.SeasonsListRepository
import javax.inject.Inject

class LauncherActivity : AppCompatActivity() {

    @Inject
    lateinit var seasonsListRepository: SeasonsListRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.LauncherActivityTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        RepositoryManager.instance.getStaticRepositoryComponent().inject(this)

        seasonsListRepository.getCurrentSeason().observe(this, Observer {
            F1SharedPreference.instance.setDisplaySeason(it.season)
            openMainActivity()
        })

    }

    private fun openMainActivity() {

    }
}

package com.example.database.dagger

import android.content.Context
import androidx.room.Room
import com.example.database.F1Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    companion object {

        @Singleton
        @Provides
        @JvmStatic
        fun getDatabase(context: Context): F1Database {
            return Room.databaseBuilder(
                context.applicationContext,
                F1Database::class.java,
                "notes_database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }

    }

}

package com.example.skynews.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.skynews.data.local.dao.ArticleDao
import com.example.skynews.data.local.entity.LocalArticle

@Database(entities = [LocalArticle::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}

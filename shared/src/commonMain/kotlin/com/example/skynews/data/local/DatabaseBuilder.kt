package com.example.skynews.data.local

import androidx.room.RoomDatabase

expect fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>

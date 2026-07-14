package com.example.skynews.data.local

import androidx.room.RoomDatabase

actual fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    // Empty implementation as requested
    throw NotImplementedError("iOS Room implementation is not yet provided")
}

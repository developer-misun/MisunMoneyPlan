package com.misun.misunmoneyplan.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.misun.misunmoneyplan.data.local.dao.AssetDao
import com.misun.misunmoneyplan.data.local.entity.AssetEntity

@Database(entities = [AssetEntity::class], version = 1, exportSchema = false)
@TypeConverters(AssetTypeConverter::class)
abstract class AssetDatabase : RoomDatabase() {
    abstract fun assetDao(): AssetDao

    companion object {
        const val DATABASE_NAME = "misun_money_plan_db"
    }
}

package com.misun.misunmoneyplan.data.local

import androidx.room.TypeConverter
import com.misun.misunmoneyplan.domain.model.AssetType

class AssetTypeConverter {
    @TypeConverter
    fun fromAssetType(value: AssetType): String {
        return value.name
    }

    @TypeConverter
    fun toAssetType(value: String): AssetType {
        return try {
            AssetType.valueOf(value)
        } catch (e: Exception) {
            AssetType.ETC
        }
    }
}

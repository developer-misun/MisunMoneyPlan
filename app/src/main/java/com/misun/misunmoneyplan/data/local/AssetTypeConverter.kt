package com.misun.misunmoneyplan.data.local

import androidx.room.TypeConverter
import com.misun.misunmoneyplan.domain.model.AssetType
import com.misun.misunmoneyplan.domain.model.AssetLocation

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

    @TypeConverter
    fun fromAssetLocation(value: AssetLocation): String {
        return value.name
    }

    @TypeConverter
    fun toAssetLocation(value: String): AssetLocation {
        return try {
            AssetLocation.valueOf(value)
        } catch (e: Exception) {
            AssetLocation.DOMESTIC
        }
    }
}

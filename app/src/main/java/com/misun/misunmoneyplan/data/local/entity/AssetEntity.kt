package com.misun.misunmoneyplan.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.misun.misunmoneyplan.domain.model.AssetType
import com.misun.misunmoneyplan.domain.model.AssetLocation

@Entity(tableName = "assets")
data class AssetEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val amount: Long,
    val type: AssetType,
    val location: AssetLocation,
    val updatedAt: Long,
    val memo: String
)


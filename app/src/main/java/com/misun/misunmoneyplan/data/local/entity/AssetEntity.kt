package com.misun.misunmoneyplan.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.misun.misunmoneyplan.domain.model.Asset
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

/**
 * Entity를 Domain Model로 변환
 */
fun AssetEntity.toDomain(): Asset {
    return Asset(
        id = id,
        name = name,
        amount = amount,
        type = type,
        location = location,
        updatedAt = updatedAt,
        memo = memo
    )
}

/**
 * Domain Model을 Entity로 변환
 */
fun Asset.toEntity(): AssetEntity {
    return AssetEntity(
        id = id,
        name = name,
        amount = amount,
        type = type,
        location = location,
        updatedAt = updatedAt,
        memo = memo
    )
}

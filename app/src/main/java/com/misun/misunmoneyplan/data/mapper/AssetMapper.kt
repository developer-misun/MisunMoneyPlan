package com.misun.misunmoneyplan.data.mapper

import com.misun.misunmoneyplan.data.local.entity.AssetEntity
import com.misun.misunmoneyplan.domain.model.Asset

/**
 * DB 엔티티(AssetEntity)와 도메인 모델(Asset) 간의 변환 로직
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

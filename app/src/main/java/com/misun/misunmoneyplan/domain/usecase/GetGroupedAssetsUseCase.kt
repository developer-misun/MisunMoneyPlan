package com.misun.misunmoneyplan.domain.usecase

import com.misun.misunmoneyplan.domain.model.Asset
import com.misun.misunmoneyplan.domain.model.AssetType
import com.misun.misunmoneyplan.domain.model.AssetLocation
import com.misun.misunmoneyplan.domain.model.SortOrder

/**
 * [T2-4] 자산 목록을 특정 기준(유형/지역)으로 그룹화하여 반환하는 유즈케이스
 */
class GetGroupedAssetsUseCase {

    /**
     * [F1-7a] 자산 목록을 유형별로 그룹화하고 금액순으로 정렬
     */
    fun groupByType(assets: List<Asset>, sortOrder: SortOrder = SortOrder.DESC): Map<AssetType, Long> {
        val grouped = assets.groupBy { it.type }
            .mapValues { entry -> entry.value.sumOf { it.amount } }
            .toList()
        
        return if (sortOrder == SortOrder.DESC) {
            grouped.sortedByDescending { it.second }.toMap()
        } else {
            grouped.sortedBy { it.second }.toMap()
        }
    }

    /**
     * [F1-8b] 자산 목록을 지역별로 그룹화하고 금액순으로 정렬
     */
    fun groupByLocation(assets: List<Asset>, sortOrder: SortOrder = SortOrder.DESC): Map<AssetLocation, Long> {
        val grouped = assets.groupBy { it.location }
            .mapValues { entry -> entry.value.sumOf { it.amount } }
            .toList()

        return if (sortOrder == SortOrder.DESC) {
            grouped.sortedByDescending { it.second }.toMap()
        } else {
            grouped.sortedBy { it.second }.toMap()
        }
    }
}

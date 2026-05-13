package com.misun.misunmoneyplan.domain.usecase

import com.misun.misunmoneyplan.domain.model.Asset
import com.misun.misunmoneyplan.domain.model.AssetType
import com.misun.misunmoneyplan.domain.model.AssetLocation
import org.junit.Assert.assertEquals
import org.junit.Test

class GetGroupedAssetsUseCaseTest {

    private val useCase = GetGroupedAssetsUseCase()

    private val testAssets = listOf(
        Asset("1", "Cash1", 1000, AssetType.CASH, AssetLocation.DOMESTIC, 0),
        Asset("2", "Stock1", 5000, AssetType.STOCK, AssetLocation.OVERSEAS, 0),
        Asset("3", "Cash2", 2000, AssetType.CASH, AssetLocation.DOMESTIC, 0),
        Asset("4", "Stock2", 3000, AssetType.STOCK, AssetLocation.DOMESTIC, 0)
    )

    @Test
    fun `TC-T2-4-01 유형별 자산 그룹화 및 정렬 확인`() {
        // When
        val result = useCase.groupByType(testAssets)

        // Then
        // STOCK: 5000 + 3000 = 8000
        // CASH: 1000 + 2000 = 3000
        assertEquals(2, result.size)
        assertEquals(8000L, result[AssetType.STOCK])
        assertEquals(3000L, result[AssetType.CASH])
        
        // 정렬 확인 (금액 내림차순)
        assertEquals(AssetType.STOCK, result.keys.first())
    }

    @Test
    fun `TC-T2-4-02 지역별 자산 그룹화 및 정렬 확인`() {
        // When
        val result = useCase.groupByLocation(testAssets)

        // Then
        // DOMESTIC: 1000 + 2000 + 3000 = 6000
        // OVERSEAS: 5000
        assertEquals(2, result.size)
        assertEquals(6000L, result[AssetLocation.DOMESTIC])
        assertEquals(5000L, result[AssetLocation.OVERSEAS])
        
        // 정렬 확인 (금액 내림차순)
        assertEquals(AssetLocation.DOMESTIC, result.keys.first())
    }
}

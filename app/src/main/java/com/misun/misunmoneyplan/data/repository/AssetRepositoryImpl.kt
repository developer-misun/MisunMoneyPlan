package com.misun.misunmoneyplan.data.repository

import com.misun.misunmoneyplan.domain.model.Asset
import com.misun.misunmoneyplan.domain.model.AssetType
import com.misun.misunmoneyplan.domain.repository.AssetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

/**
 * AssetRepository 인터페이스의 실제 구현부
 * 현재는 메모리 기반 또는 DB 시뮬레이션으로 동작
 */
@Singleton
class AssetRepositoryImpl @Inject constructor() : AssetRepository {

    // 테스트를 위한 임시 메모리 데이터
    private var mockAssets = mutableListOf<Asset>()

    override fun getAllAssets(): Flow<List<Asset>> {
        return flowOf(mockAssets)
    }

    override suspend fun getAssetById(id: String): Asset? {
        return mockAssets.find { it.id == id }
    }

    override suspend fun updateAsset(asset: Asset) {
        val index = mockAssets.indexOfFirst { it.id == asset.id }
        if (index != -1) {
            mockAssets[index] = asset
        } else {
            mockAssets.add(asset)
        }
    }

    override suspend fun deleteAsset(id: String) {
        mockAssets.removeIf { it.id == id }
    }
}

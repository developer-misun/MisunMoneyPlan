package com.misun.misunmoneyplan.domain.repository

import com.misun.misunmoneyplan.domain.model.Asset
import kotlinx.coroutines.flow.Flow

/**
 * 자산 데이터에 접근하기 위한 인터페이스
 */
interface AssetRepository {
    /**
     * 모든 자산 목록을 Flow 형태로 가져온다.
     */
    fun getAllAssets(): Flow<List<Asset>>

    /**
     * 특정 ID를 가진 자산 정보를 가져온다.
     */
    suspend fun getAssetById(id: String): Asset?

    /**
     * 자산 정보를 업데이트하거나 새로 추가한다.
     */
    suspend fun updateAsset(asset: Asset)

    /**
     * 자산을 삭제한다.
     */
    suspend fun deleteAsset(id: String)
}

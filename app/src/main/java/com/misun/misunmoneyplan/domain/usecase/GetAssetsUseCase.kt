package com.misun.misunmoneyplan.domain.usecase

import com.misun.misunmoneyplan.domain.model.Asset
import com.misun.misunmoneyplan.domain.repository.AssetRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * 모든 자산 목록을 가져오는 유스케이스
 */
class GetAssetsUseCase @Inject constructor(
    private val repository: AssetRepository
) {
    operator fun invoke(): Flow<List<Asset>> {
        return repository.getAllAssets()
    }
}

package com.misun.misunmoneyplan.domain.usecase

import com.misun.misunmoneyplan.domain.model.Asset
import com.misun.misunmoneyplan.domain.repository.AssetRepository
import javax.inject.Inject

/**
 * 특정 ID를 가진 자산 정보를 가져오는 유스케이스
 */
class GetAssetByIdUseCase @Inject constructor(
    private val repository: AssetRepository
) {
    suspend operator fun invoke(id: String): Asset? {
        return repository.getAssetById(id)
    }
}

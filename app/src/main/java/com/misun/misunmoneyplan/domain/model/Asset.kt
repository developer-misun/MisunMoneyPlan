package com.misun.misunmoneyplan.domain.model

/**
 * 자산 정보를 나타내는 도메인 엔티티
 * @param id 고유 식별자
 * @param name 종목명 (예: 삼성전자)
 * @param amount 현재 자산 가치 (원화 기준)
 * @param type 자산 유형 (주식, 현금 등)
 * @param updatedAt 최신 업데이트 시간 (timestamp)
 * @param memo 자산 관련 메모
 */
data class Asset(
    val id: String,
    val name: String,
    val amount: Long,
    val type: AssetType,
    val location: AssetLocation = AssetLocation.DOMESTIC,
    val updatedAt: Long,
    val memo: String = ""
)

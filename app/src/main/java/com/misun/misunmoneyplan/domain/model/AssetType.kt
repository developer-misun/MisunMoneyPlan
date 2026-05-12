package com.misun.misunmoneyplan.domain.model

/**
 * 자산의 유형을 정의하는 Enum 클래스
 */
enum class AssetType(val displayName: String) {
    CASH("현금"),
    STOCK("주식"),
    ETF("ETF"),
    COIN("코인"),
    ETC("기타")
}

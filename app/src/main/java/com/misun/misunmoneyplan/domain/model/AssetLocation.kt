package com.misun.misunmoneyplan.domain.model

/**
 * 자산의 지역 속성 (국내/국외)
 */
enum class AssetLocation(val displayName: String) {
    DOMESTIC("국내"),
    OVERSEAS("국외")
}

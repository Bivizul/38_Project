package aaa.bivizul.a38project.domain.model

@kotlinx.serialization.Serializable
data class Spohows(
    val id: Int,
    val spohowtit: String,
    val spohowdesc: String,
    val spohowin: List<Spohowin>,
)
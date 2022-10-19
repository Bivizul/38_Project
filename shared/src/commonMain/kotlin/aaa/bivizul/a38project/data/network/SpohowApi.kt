package aaa.bivizul.a38project.data.network

import aaa.bivizul.a38project.domain.model.Spohow
import aaa.bivizul.a38project.domain.model.Spohowg
import aaa.bivizul.a38project.domain.model.Spohows
import aaa.bivizul.a38project.domain.util.Spohowcon.SPOHOWBASEURL
import aaa.bivizul.a38project.domain.util.Spohowcon.SPOHOWGURL
import aaa.bivizul.a38project.domain.util.Spohowcon.SPOHOWITEMURL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class SpohowApi {

    val spotloshc = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    private fun HttpRequestBuilder.spotlosbase(path: String) {
        url {
            takeFrom(SPOHOWBASEURL)
            encodedPath = path
        }
    }

    suspend fun getSpohowItem(): List<Spohows> {
        val getspotlositemurl = SPOHOWITEMURL
        val spotloshr = spotloshc.get { spotlosbase(getspotlositemurl) }
        val getspotlositembody = spotloshr.body<List<Spohows>>()
        return getspotlositembody
    }

    suspend fun getSpohowg(spotlos: Spohow): Spohowg {
        val getspotlosurl = SPOHOWGURL
        val spotloshr = spotloshc.post {
            spotlosbase(getspotlosurl)
            contentType(Json)
            setBody(spotlos)
        }
        val getspotlosbody = spotloshr.body<Spohowg>()
        return getspotlosbody
    }

}
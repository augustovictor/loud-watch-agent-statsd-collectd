package augustovictor.com.github.cloudwatchagentstatsdcollectd

import com.timgroup.statsd.NonBlockingStatsDClient
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/sales")
class SalesController(private val statsdClient: NonBlockingStatsDClient) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    @ResponseStatus(CREATED)
    fun createSale(@RequestBody saleSchemaDTO: SaleSchemaDTO) {
        logger.info(saleSchemaDTO.toString())
        statsdClient.incrementCounter("sales.new")
    }
}
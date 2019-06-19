package augustovictor.com.github.cloudwatchagentstatsdcollectd

import com.timgroup.statsd.NonBlockingStatsDClient
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/users")
class UserController(private val statsdClient: NonBlockingStatsDClient) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    @RequestMapping("/login")
    @ResponseStatus(CREATED)
    fun login(@RequestBody loginSchemaDTO: LoginSchemaDTO) {
        logger.info(loginSchemaDTO.toString())
        statsdClient.increment("users.login")
    }
}
package ca.tetervak.mathtrainer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MathTrainerServerApplication

fun main(args: Array<String>) {
    runApplication<MathTrainerServerApplication>(*args)
}

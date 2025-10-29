package ca.tetervak.mathtrainer

import ca.tetervak.mathtrainer.service.AlgebraQuiz
import ca.tetervak.mathtrainer.service.RandomQuizService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class RandomQuizController(
    private val randomQuizService: RandomQuizService
) {
    val logger: Logger = LoggerFactory.getLogger(RandomQuizController::class.java)

    @GetMapping("/random-quiz")
    fun getRandomQuiz(
        @RequestParam(value = "number-of-problems", defaultValue = "5") numberOfProblems: Int
    ): AlgebraQuiz {
        logger.info("getRandomQuiz: received GET request")
        logger.info("number-of-problems: $numberOfProblems")

        if (numberOfProblems !in 1..20) {
            logger.error("number-of-problems must be between 1 and 20")
            throw IllegalArgumentException("number-of-problems must be between 1 and 20")
        }

        val quiz: AlgebraQuiz = randomQuizService.getRandomQuiz(numberOfProblems)
        logger.info("generated quiz: quiz.numberOfProblems = ${quiz.numberOfProblems}")

        return randomQuizService.getRandomQuiz(numberOfProblems)
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException::class)
    fun illegalArgumentHandler(ex: IllegalArgumentException): Map<String, String?> {
        return mapOf("error" to ex.message)
    }
}
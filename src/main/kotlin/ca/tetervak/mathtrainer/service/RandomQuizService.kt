package ca.tetervak.mathtrainer.service

import ca.tetervak.mathtrainer.domain.AlgebraProblem
import ca.tetervak.mathtrainer.domain.AlgebraProblemFactory
import org.springframework.stereotype.Service

@Service
class RandomQuizService(
    private val problemFactory: AlgebraProblemFactory
) {

    private fun getRandomProblemList(numberOfProblems: Int):List<AlgebraQuizProblem> =
        List(size = numberOfProblems) { index ->
            val problem: AlgebraProblem = problemFactory.createRandomProblem()
            AlgebraQuizProblem(
                id = index + 1,
                text = problem.text,
                answer = problem.answer
            )
        }

    fun getRandomQuiz(numberOfProblems: Int): AlgebraQuiz =
        AlgebraQuiz(
            numberOfProblems = numberOfProblems,
            problems = getRandomProblemList(numberOfProblems)
        )
}
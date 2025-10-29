package ca.tetervak.mathtrainer.service

data class AlgebraQuiz(
    val numberOfProblems: Int,
    val problems: List<AlgebraQuizProblem>
)

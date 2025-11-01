package ca.tetervak.mathtrainer.domain

import kotlin.random.Random

class AlgebraProblemFactory(
    private val random: Random = Random.Default
){
    private val additionProblemFactory = AdditionProblemFactory(random)
    private val subtractionProblemFactory = SubtractionProblemFactory(random)
    private val multiplicationProblemFactory = MultiplicationProblemFactory(random)
    private val divisionProblemFactory = DivisionProblemFactory(random)

    fun createRandomProblem(): AlgebraProblem =
        when (random.nextInt(1, 5)) {
            1 -> additionProblemFactory.createRandomProblem()
            2 -> subtractionProblemFactory.createRandomProblem()
            3 -> multiplicationProblemFactory.createRandomProblem()
            else -> divisionProblemFactory.createRandomProblem()
        }
}

class AdditionProblemFactory(
    private val random: Random = Random.Default
) {

    fun createRandomProblem(): AlgebraProblem {
        val larger = getRandomLargerValue()
        val smaller = getRandomSmallerValue(larger)
        return AlgebraProblem(a = larger - smaller, b = smaller, op = AlgebraOperation.ADDITION)
    }

    private fun getRandomLargerValue() =
        random.nextInt(LARGER_VALUE_FROM, LARGER_VALUE_UNTIL)

    private fun getRandomSmallerValue(larger: Int) =
        random.nextInt(SMALLER_VALUE_FROM, larger)

    private companion object {
        private const val LARGER_VALUE_UNTIL: Int = 50
        private const val LARGER_VALUE_FROM: Int = 12
        private const val SMALLER_VALUE_FROM: Int = 7
    }
}

class SubtractionProblemFactory(
    private val random: Random = Random.Default
){

    fun createRandomProblem(): AlgebraProblem {
        val larger = getRandomLargerValue()
        val smaller = getRandomSmallerValue(larger)
        return AlgebraProblem(a = larger, b = smaller, op = AlgebraOperation.SUBTRACTION)
    }

    private fun getRandomLargerValue() =
        random.nextInt(LARGER_VALUE_FROM, LARGER_VALUE_UNTIL)

    private fun getRandomSmallerValue(larger: Int) =
        random.nextInt(SMALLER_VALUE_FROM, larger)

    private companion object {
        private const val LARGER_VALUE_UNTIL: Int = 50
        private const val LARGER_VALUE_FROM: Int = 12
        private const val SMALLER_VALUE_FROM: Int = 7
    }
}

class MultiplicationProblemFactory(
    private val random: Random = Random.Default
){

    fun createRandomProblem(): AlgebraProblem {
        val first = getRandomFirstValue()
        val second = getRandomSecondValue()
        return if (random.nextBoolean())
            AlgebraProblem(a = first, b = second, op = AlgebraOperation.MULTIPLICATION)
        else
            AlgebraProblem(a = second, b = first, op = AlgebraOperation.MULTIPLICATION)
    }

    private fun getRandomFirstValue() =
        random.nextInt(FIRST_VALUE_FROM, FIRST_VALUE_UNTIL)

    private fun getRandomSecondValue() =
        random.nextInt(SECOND_VALUE_FROM, SECOND_VALUE_UNTIL)

    private companion object {

        private const val FIRST_VALUE_FROM: Int = 2
        private const val FIRST_VALUE_UNTIL: Int = 10

        private const val SECOND_VALUE_FROM: Int = 2
        private const val SECOND_VALUE_UNTIL: Int = 11
    }
}

class DivisionProblemFactory(
    private val random: Random = Random.Default
){

    fun createRandomProblem(): AlgebraProblem {
        val first = getRandomFirstValue()
        val second = getRandomSecondValue()
        return if (random.nextBoolean())
            AlgebraProblem(a = first * second, b = first, op = AlgebraOperation.DIVISION)
        else
            AlgebraProblem(a = first * second, b = second, op = AlgebraOperation.DIVISION)
    }

    private fun getRandomFirstValue() =
        random.nextInt(FIRST_VALUE_FROM, FIRST_VALUE_UNTIL)

    private fun getRandomSecondValue() =
        random.nextInt(SECOND_VALUE_FROM, SECOND_VALUE_UNTIL)

    private companion object {

        private const val FIRST_VALUE_FROM: Int = 2
        private const val FIRST_VALUE_UNTIL: Int = 10

        private const val SECOND_VALUE_FROM: Int = 2
        private const val SECOND_VALUE_UNTIL: Int = 11
    }
}

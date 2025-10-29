package ca.tetervak.mathtrainer.domain

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FactoryConfig {

    @Bean
    fun problemFactory(): AlgebraProblemFactory = AlgebraProblemFactory()

}
package io.github.patrickbelanger.gptstoryplanner

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GptStoryPlannerApplication

fun main(args: Array<String>) {
	runApplication<GptStoryPlannerApplication>(*args)
}

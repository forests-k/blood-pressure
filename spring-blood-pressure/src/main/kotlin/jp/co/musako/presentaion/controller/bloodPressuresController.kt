package jp.co.musako.presentaion.controller

import jp.co.musako.domain.model.*
import jp.co.musako.domain.service.*
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.*

@RestController()
class bloodPressuresController(
  private val bloodPressureService: BloodPressuresServiceImpl
) {

  @GetMapping("/api/v1/blood-pressures")
  fun findAll(): Flux<BloodPressures> = Flux.fromIterable(bloodPressureService.findAll())

  @PostMapping("/api/v1/blood-pressures")
  fun add(@RequestBody bloodPressures: BloodPressures): Mono<BloodPressures> = Mono.just(bloodPressureService.add(bloodPressures))

  @PutMapping("/api/v1/blood-pressures/{id}")
  fun update(@PathVariable("id") id: Long, @RequestBody bloodPressures: BloodPressures): Mono<BloodPressures> =
    Mono.just(bloodPressureService.update(id, bloodPressures))

  @DeleteMapping("/api/v1/blood-pressures/{id}")
  fun delete(@PathVariable("id") id: Long) = bloodPressureService.delete(id)

}
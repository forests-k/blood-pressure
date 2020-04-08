package jp.co.musako.domain.service

import javassist.*
import jp.co.musako.domain.entity.*
import jp.co.musako.domain.model.*
import jp.co.musako.domain.repository.*
import org.springframework.data.domain.*
import org.springframework.stereotype.*
import org.springframework.transaction.annotation.*
import java.time.*

@Service
class BloodPressuresServiceImpl(
  private val bloodPressureRepository: BloodPressuresRepository
) {

  fun findAll(): List<BloodPressures> =
    bloodPressureRepository.findAll(
      Sort.by(
        mutableListOf(
          Sort.Order(Sort.Direction.ASC, "measuringDate"),
          Sort.Order(Sort.Direction.ASC, "measuringTimeZoneType")
        )
      )
    ).map { it.getModel() }

  fun findAll(yearMonth: YearMonth): List<BloodPressures> =
    bloodPressureRepository.findAllBetweenMeasuringDate(
      LocalDate.of(yearMonth.year, yearMonth.month, 1),
      LocalDate.of(yearMonth.year, yearMonth.month, LocalDate.of(yearMonth.year, yearMonth.month, 1).minusDays(1).dayOfMonth)
    ).map { it.getModel() }

  @Transactional
  fun add(bloodPressure: BloodPressures): BloodPressures = bloodPressureRepository.save(
    BloodPressureEntity(
      systolicBloodPressure = bloodPressure.systolicBloodPressure,
      diastolicBloodPressure = bloodPressure.diastolicBloodPressure,
      pulse = bloodPressure.pulse,
      measuringDate = bloodPressure.measuringDate,
      measuringTimeZoneType = bloodPressure.measuringTimeZoneType
    )
  ).getModel()

  @Transactional
  fun update(id: Long, bloodPressure: BloodPressures): BloodPressures {
    val bloodPressureEntity =
      bloodPressureRepository.findById(id).orElseThrow { NotFoundException("該当する血圧履歴情報は存在しません。") }
    bloodPressureEntity.update(bloodPressure)
    return bloodPressureRepository.saveAndFlush(bloodPressureEntity).getModel()
  }

  @Transactional
  fun delete(id: Long) = bloodPressureRepository.deleteById(id)
}
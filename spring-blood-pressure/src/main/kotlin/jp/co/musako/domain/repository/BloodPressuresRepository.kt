package jp.co.musako.domain.repository

import jp.co.musako.domain.entity.*
import org.springframework.data.jpa.repository.*
import java.time.*

interface BloodPressuresRepository : JpaRepository<BloodPressureEntity, Long> {

  @Query(
    "SELECT b FROM BloodPressureEntity b " +
          "WHERE b.measuringDate BETWEEN :startDate AND :endDate " +
          "ORDER BY b.measuringDate ASC, b.measuringTimeZoneType ASC"
  )
  fun findAllBetweenMeasuringDate(startDate: LocalDate, endDate: LocalDate): List<BloodPressureEntity>

}
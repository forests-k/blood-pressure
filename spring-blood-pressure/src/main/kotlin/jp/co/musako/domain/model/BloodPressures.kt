package jp.co.musako.domain.model

import com.fasterxml.jackson.annotation.*
import jp.co.musako.domain.model.type.*
import java.io.*
import java.time.*

data class BloodPressures(
  val id: Long? = null,
  @JsonProperty("systolic_blood_pressure")
  val systolicBloodPressure: Int,
  @JsonProperty("diastolic_blood_pressure")
  val diastolicBloodPressure: Int,
  val pulse: Int,
  @JsonProperty("measuring_date")
  @JsonFormat(pattern = "yyyy-MM-dd")
  val measuringDate: LocalDate,
  @JsonProperty("measuring_time_zone_type")
  val measuringTimeZoneType: MeasuringTimeZoneType,
  @JsonProperty("created_at")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  val createdAt: LocalDateTime? = null
) : Serializable {
}
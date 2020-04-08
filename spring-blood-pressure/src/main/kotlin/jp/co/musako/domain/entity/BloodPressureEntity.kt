package jp.co.musako.domain.entity

import jp.co.musako.domain.model.*
import jp.co.musako.domain.model.type.*
import org.hibernate.annotations.*
import javax.persistence.EnumType;
import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.persistence.Entity
import javax.persistence.Table

@Table(name = "blood_pressures")
@Entity
data class BloodPressureEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  val id: Long? = null,
  @Column(name = "systolic_blood_pressure")
  var systolicBloodPressure: Int,
  @Column(name = "diastolic_blood_pressure")
  var diastolicBloodPressure: Int,
  @Column(name = "pulse")
  var pulse: Int,
  @Column(name = "measuring_date")
  var measuringDate: LocalDate,
  @Enumerated(EnumType.ORDINAL)
  @Column(name = "measuring_time_zone_type")
  var measuringTimeZoneType: MeasuringTimeZoneType,
  @CreationTimestamp
  @Column(name = "created_at")
  val createdAt: LocalDateTime? = null
  ): Serializable {

  fun getModel(): BloodPressures = BloodPressures(
    id = id,
    systolicBloodPressure = systolicBloodPressure,
    diastolicBloodPressure = diastolicBloodPressure,
    pulse = pulse,
    measuringDate = measuringDate,
    measuringTimeZoneType = measuringTimeZoneType,
    createdAt = createdAt
  )

  fun update(bloodPressure: BloodPressures) {
    systolicBloodPressure = bloodPressure.systolicBloodPressure
    diastolicBloodPressure = bloodPressure.diastolicBloodPressure
    pulse = bloodPressure.pulse
  }
}

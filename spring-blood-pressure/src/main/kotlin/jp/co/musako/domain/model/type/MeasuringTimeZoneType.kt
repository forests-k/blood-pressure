package jp.co.musako.domain.model.type

enum class MeasuringTimeZoneType(val type: Int) {

  MORNING(0),
  EVENING(1);

  override fun toString(): String {
    return super.toString()
  }
}
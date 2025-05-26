package dji.sdk.mission.timeline

enum class TimelineEvent(private val event: Int) {
    STARTED(0),
    ELEMENT_START_ERROR(1),
    ELEMENT_STARTED(2),
    ELEMENT_PROGRESSED(3),
    ELEMENT_FINISHED(4),
    ELEMENT_ERROR(5),
    PAUSED(6),
    PAUSE_ERROR(7),
    RESUMED(8),
    RESUME_ERROR(9),
    STOPPED(10),
    STOP_ERROR(11),
    FINISHED(12),
    UNKNOWN(255);

    fun value() = event
    fun _equals(var1: Int) = event == var1

    companion object {
        fun find(var0: Int): TimelineEvent {
            return entries.firstOrNull { it.event == var0 } ?: UNKNOWN
        }
    }
}
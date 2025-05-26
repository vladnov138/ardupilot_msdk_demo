package dji.common.flightcontroller

enum class FlightMode(private val data: Int) {
    MANUAL(0),
    ATTI(1),
    ATTI_COURSE_LOCK(2),
    ATTI_HOVER(3),
    HOVER(4),
    GPS_BLAKE(5),
    GPS_ATTI(6),
    GPS_COURSE_LOCK(7),
    GPS_HOME_LOCK(8),
    GPS_HOT_POINT(9),
    ASSISTED_TAKEOFF(10),
    AUTO_TAKEOFF(11),
    AUTO_LANDING(12),
    ATTI_LANDING(13),
    GPS_WAYPOINT(14),
    GO_HOME(15),
    CLICK_GO(16),
    JOYSTICK(17),
    GPS_ATTI_WRISTBAND(18),
    CINEMATIC(19),
    ATTI_LIMITED(20),
    DRAW(21),
    GPS_FOLLOW_ME(22),
    ACTIVE_TRACK(23),
    TAP_FLY(24),
    PANO(25),
    FARMING(26),
    FPV(27),
    GPS_SPORT(28),
    GPS_NOVICE(29),
    CONFIRM_LANDING(30),
    TERRAIN_FOLLOW(31),
    PALM_CONTROL(32),
    QUICK_SHOT(33),
    TRIPOD(34),
    TRACK_SPOTLIGHT(35),
    MOTORS_JUST_STARTED(36),
    DETOUR(37),
    TIME_LAPSE(38),
    POI2(39),
    OMNI_MOVING(40),
    ADSB_AVOIDING(41),
    SMART_TRACK(42),
    MOTOR_STOP_LANDING(43),
    UNKNOWN(255);

    fun value() = data
    fun _equals(var1: Int) = data == var1

    companion object {
        fun find(var0: Int): FlightMode? {
            return entries.firstOrNull { it.data == var0 }
        }
    }
}
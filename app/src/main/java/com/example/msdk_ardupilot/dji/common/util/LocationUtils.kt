package dji.common.util

import java.lang.reflect.InvocationTargetException
import java.util.*
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt


object LocationUtils {
//    private var currentBestLocation: Location? = null
//    private var locationManager: LocationManager? = null
//
//    fun checkValidGPSCoordinate(var0: Double, var2: Double): Boolean {
//        return var0 >= -90.0 && var0 <= 90.0 && var2 >= -180.0 && var2 <= 180.0
//    }
//
//    fun validateLatitude(var0: Double): Boolean {
//        return var0 > 90.0 || var0 < -90.0
//    }
//
//    fun validateLongitude(var0: Double): Boolean {
//        return var0 > 180.0 || var0 < -180.0
//    }
//
//    val lastBestLocation: Location?
//        get() {
//            var var0: Context? = null
//            val var1: Any? = null
//            val var2: Any? = null
//            if (null == locationManager) {
//                try {
//                    var0 = d.a().getApplicationContext()
//                    locationManager = d.a().getSystemService("location") as LocationManager
//                } catch (var7: ClassNotFoundException) {
//                    var7.printStackTrace()
//                } catch (var8: NoSuchMethodException) {
//                    var8.printStackTrace()
//                } catch (var9: InvocationTargetException) {
//                    var9.printStackTrace()
//                } catch (var10: IllegalAccessException) {
//                    var10.printStackTrace()
//                }
//            }
//
//            if (var0.checkCallingOrSelfPermission("gps") === 0 && var0.checkCallingOrSelfPermission("network") === 0) {
//                val var11: Location = locationManager.getLastKnownLocation("gps")
//                val var12: Location = locationManager.getLastKnownLocation("network")
//                var var3 = 0L
//                if (null != var11) {
//                    var3 = var11.getTime()
//                }
//
//                var var5 = 0L
//                if (null != var12) {
//                    var5 = var12.getTime()
//                }
//
//                if (0L < var3 - var5) {
//                    currentBestLocation = var11
//                } else {
//                    currentBestLocation = var12
//                }
//
//                return if (null == currentBestLocation) {
//                    if (var11 != null) {
//                        var11
//                    } else {
//                        if (var12 != null) var12 else null
//                    }
//                } else {
//                    currentBestLocation
//                }
//            } else {
//                return null
//            }
//        }

    fun checkLocationPermission(): Boolean {
        val var0 = "android.permission.ACCESS_FINE_LOCATION"
        var var1 = 0

        try {
//            var1 = d.a().getApplicationContext().checkCallingOrSelfPermission(var0)
        } catch (var3: ClassNotFoundException) {
            var3.printStackTrace()
        } catch (var4: NoSuchMethodException) {
            var4.printStackTrace()
        } catch (var5: InvocationTargetException) {
            var5.printStackTrace()
        } catch (var6: IllegalAccessException) {
            var6.printStackTrace()
        }

        return var1 == 0
    }

    fun gps2m(var0: Double, var2: Double, var4: Double, var6: Double): Double {
        val var8 = 6371000.0
        val var10 = Math.toRadians(var4 - var0)
        val var12 = Math.toRadians(var6 - var2)
        val var14 = sin(var10 / 2.0) * sin(var10 / 2.0) + cos(Math.toRadians(var0)) * cos(
            Math.toRadians(var4)
        ) * sin(var12 / 2.0) * sin(var12 / 2.0)
        val var16 = 2.0 * atan2(sqrt(var14), sqrt(1.0 - var14))
        val var18 = (var8 * var16).toFloat()
        return var18.toDouble()
    }

    fun DegreeToRadian(var0: Double): Double {
        return var0 * Math.PI / 180.0
    }

    val isInUSA: Boolean
        get() = Locale.getDefault().isO3Country == "USA"

    fun getDistanceInMeterFromTwoGPSLocations(var0: Double, var2: Double, var4: Double, var6: Double): Double {
        val var8 = 6371000.0
        val var10 = degreeToRadius(var4 - var0)
        val var12 = degreeToRadius(var6 - var2)
        val var14 = sin(var12 / 2.0) * sin(var12 / 2.0) + cos(degreeToRadius(var2)) * cos(
            degreeToRadius(var6)
        ) * sin(var10 / 2.0) * sin(var10 / 2.0)
        val var16 = 2.0 * atan2(sqrt(var14), sqrt(1.0 - var14))
        val var18 = 6371000.0 * var16
        return var18
    }

    private fun degreeToRadius(var0: Double): Double {
        return var0 * (Math.PI / 180.0)
    }

    fun radianToDegree(var0: Double): Double {
        return var0 * 180.0 / Math.PI
    }
}
package dji.common.model

class LocationCoordinate2D(var latitude: Double, var longitude: Double) {
    override fun equals(var1: Any?): Boolean {
        if (this === var1) {
            return true
        } else if (var1 != null && this.javaClass == var1.javaClass) {
            val var2 = var1 as LocationCoordinate2D
            return if (java.lang.Double.compare(var2.latitude, this.latitude) != 0) {
                false
            } else {
                java.lang.Double.compare(var2.longitude, this.longitude) == 0
            }
        } else {
            return false
        }
    }

    fun isValid(): Boolean {
        return this.latitude >= -90.0 && this.latitude <= 90.0 && this.longitude >= -180.0 && this.longitude <= 180.0
    }

    fun isValid(var0: Double, var2: Double): Boolean {
        return var0 >= -90.0 && var0 <= 90.0 && var2 >= -180.0 && var2 <= 180.0
    }

    override fun hashCode(): Int {
        var var2 = java.lang.Double.doubleToLongBits(this.latitude)
        var var1 = (var2 xor (var2 ushr 32)).toInt()
        var2 = java.lang.Double.doubleToLongBits(this.longitude)
        var1 = 31 * var1 + (var2 xor (var2 ushr 32)).toInt()
        return var1
    }
}
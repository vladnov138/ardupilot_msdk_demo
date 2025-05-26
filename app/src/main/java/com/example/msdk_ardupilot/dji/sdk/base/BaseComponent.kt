package dji.sdk.base

import dji.common.util.CommonCallbacks.CompletionCallbackWith
import dji.midware.MavlinkConnector


abstract class                          BaseComponent(protected val componentId: Int, protected val mavlinkConnection: MavlinkConnector) {
//    protected static val GIMBAL_RESET: String
//    protected static val GIMBAL_CHANGE_MODE: String
//    protected static val GIMBAL_AUTO_CALIBRATION: String
//    protected static val FLIGHT_CONTROLLER_TAKE_OFF: String
//    protected static val FLIGHT_CONTROLLER_CANCEL_TAKE_OFF: String
//    protected static val FLIGHT_CONTROLLER_CHECK_GIMBAL_BEHAVIOR: String
//    protected static const val SHORT_SERIAL_NUM: Int = 0
//    protected static const val LEGACY_SERIAL_NUM: Int = 1
//    protected static const val FULL_SERIAL_NUM: Int = 2
    val START_COUNTING: Int = 0
//    protected static val handler: Handler = Handler(dji.midware.util.gfd.nhf(), object : Callback() {
//        fun handleMessage(var1: Message?): Boolean {
//            return false
//        }
//    })
//    private static val completionCallbackHashMap: WeakHashMap<CompletionTester.KeyHolder, CompletionTester>? = null
    private val componentListener: ComponentListener? = null
    private val isConnected = false
//    protected var index: Int = 0

    fun removeMessages(var0: Int, var1: Any?) {
    }

//    @Synchronized
//    fun getCompletionCallbackHashMap(): WeakHashMap<CompletionTester.KeyHolder, CompletionTester>? {
//        return null
//    }

//    fun startCounting(var0: CompletionTester?) {
//    }

    private fun getMD5Legacy(var1: String): String? {
        return null
    }

    private fun getMD5Short(var1: String): String? {
        return null
    }

    private fun getMD5Full(var1: String): String? {
        return null
    }

    protected fun init(var1: Int) {
    }

    fun setComponentListener(var1: ComponentListener?) {
    }

//    protected fun checkCompletionCallback(var1: CompletionTester.KeyHolder?) {
//    }

    open fun isConnected(): Boolean {
        return false
    }

    open fun getSerialNumber(var1: CompletionCallbackWith<String?>) {
    }

    protected fun getHashSerialNum(var1: String?, var2: Int): String? {
        return null
    }

    protected fun checkConnection() {
    }

    protected fun connectChanged(var1: Boolean) {
    }

    open fun getIndex(): Int {
        return 0
    }

    open fun getFirmwareVersion(var1: CompletionCallbackWith<String?>) {
    }

    protected open fun destroy() {
    }

    interface ComponentListener {
        fun onConnectivityChange(var1: Boolean)
    }
}
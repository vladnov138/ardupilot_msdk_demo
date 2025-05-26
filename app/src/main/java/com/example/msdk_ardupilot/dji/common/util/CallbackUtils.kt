package dji.common.util

import dji.common.error.DJIError
import dji.common.util.CommonCallbacks.CompletionCallback
import dji.common.util.CommonCallbacks.CompletionCallbackWith

object CallbackUtils {
//    fun defaultCB(var0: b.e?): d {
//        val var1: d = object : d() {
//            fun onSuccess(var1: Any?) {
//                if (var0 != null) {
//                    var0.a(null as Any?)
//                }
//            }
//
//            fun onFailure(var1: Ccode?) {
//                if (var0 != null) {
//                    var0.a(CommonError.getDJIError(var1))
//                }
//            }
//        }
//        return var1
//    }

//    fun defaultCB(var0: b.e?, var1: Class<out DJIError?>): d {
//        return object : d() {
//            fun onSuccess(var1x: Any?) {
//                onSuccess(var0 as b.e?, null as Any?)
//            }
//
//            fun onFailure(var1x: Ccode?) {
//                if (null != var0) {
//                    try {
//                        val var2: Method? = var1.getMethod("getDJIError", Ccode::class.java)
//                        if (var2 != null) {
//                            var0.a(var2.invoke(var1, var1x) as CommonError)
//                        } else {
//                            var0.a(CommonError.getDJIError(var1x))
//                        }
//                    } catch (var3: Exception) {
//                        var0.a(CommonError.getDJIError(var1x))
//                        var3.printStackTrace()
//                    }
//                }
//            }
//        }
//    }

    fun onSuccess(var0: Any?, var1: Any?) {
        if (null != var0) {
//            var0.a(var1)
        }
    }

    fun onSuccess(var0: CompletionCallbackWith<*>?, var1: Any?) {
//        var0?.onSuccess(var1)
    }

    fun onFailure(var0: CompletionCallbackWith<*>?, var1: Any?) {
//        var0?.onFailure(CommonError.getDJIError(var1))
    }

    fun onFailure(var0: Any?, var1: Any?) {
        if (null != var0) {
//            var0.a(CommonError.getDJIError(var1))
        }
    }

    fun onFailure(var0: Any?) {
//        if (null != var0) {
//            var0.a(null as CommonError?)
//        }
    }

    fun onFailure(var0: Any?, var1: DJIError?) {
//        if (null != var0) {
//            var0.a(var1)
//        }
    }

    fun onFailure(var0: CompletionCallback<*>?, var1: DJIError) {
//        var0?.onResult(var1)
    }

    fun onFailure(var0: CompletionCallback<*>?, var1: Any?) {
//        var0?.onResult(CommonError.getDJIError(var1))
    }

    fun onFailure(var0: CompletionCallbackWith<*>?, var1: DJIError?) {
        var0?.onFailure(var1)
    }

    fun onSuccess(var0: CompletionCallback<*>?) {
//        var0?.onResult(null as CommonError?)
    }

    fun onResult(var0: CompletionCallback<*>?, var1: DJIError) {
//        var0?.onResult(var1)
    }

//    fun getActionCallback(var0: CompletionCallback<*>?): DJIActionCallback {
//        return object : DJIActionCallback() {
//            fun onSuccess() {
//                onSuccess(var0)
//            }
//
//            fun onFails(var1: CommonError?) {
//                onFailure(var0, var1)
//            }
//        }
//    }

//    fun getSetCallback(var0: CompletionCallback<*>?): DJISetCallback {
//        return object : DJISetCallback() {
//            fun onSuccess() {
//                onSuccess(var0)
//            }
//
//            fun onFails(var1: CommonError?) {
//                onFailure(var0, var1)
//            }
//        }
//    }

//    fun getGetCallback(var0: CompletionCallbackWith<*>?): DJIGetCallback {
//        return object : DJIGetCallback() {
//            fun onSuccess(var1: DJISDKCacheParamValue?) {
//                if (var1 != null && var1.getData() != null) {
//                    onSuccess(var0, var1.getData())
//                } else {
//                    onFailure(var0, CommonError.COMMON_EXECUTION_FAILED)
//                }
//            }
//
//            fun onFails(var1: CommonError?) {
//                onFailure(var0, var1)
//            }
//        }
//    }

//    fun getSetterDJIDataCallback(var0: b.e?): d {
//        return object : d() {
//            fun onSuccess(var1: Any?) {
//                onSuccess(var0 as b.e?, null as Any?)
//            }
//
//            fun onFailure(var1: Ccode?) {
//                onFailure(var0, var1)
//            }
//        }
//    }

//    fun getDJIDataCallback(var0: CompletionCallback<*>?): d {
//        return object : d() {
//            fun onSuccess(var1: Any?) {
//                CallbackUtils.onSuccess(var0)
//            }
//
//            fun onFailure(var1: Ccode?) {
//                onFailure(var0, var1)
//            }
//        }
//    }

//    fun getMissionManagerDJIDataCallback(var0: Int, var1: CompletionCallback<*>?, var2: Runnable?): d {
//        return object : d() {
//            fun onSuccess(var1x: Any?) {
//                val var2x = var0
//                if (var2x == 0) {
//                    CallbackUtils.onSuccess(var1)
//                } else {
//                    var2?.run()
//
//                    onFailure(var1, DJIMissionError.getDJIErrorByCode(var2x) as CommonError)
//                }
//            }
//
//            fun onFailure(var1x: Ccode?) {
//                onFailure(var1, var1x)
//            }
//        }
//    }

//    fun getFlightControllerDefaultMergeSetCallback(var0: b.e?): e {
//        return object : e() {
//            fun onSuccess(var1: Any?) {
//                onSuccess(var0 as b.e?, null as Any?)
//            }
//
//            fun onFailure(var1: CommonError?) {
//                onFailure(var0, var1)
//            }
//        }
//    }

//    fun getFlightControllerDetaultMergeGetCallback(var0: Class<*>, var1: b.e?): e {
//        return object : e() {
//            fun onSuccess(var1x: Any?) {
//                if (var0 == Boolean::class.java) {
//                    onSuccess(var1 as b.e?, a.a(var1x) === 1)
//                } else if (var0 == Int::class.java) {
//                    onSuccess(var1 as b.e?, a.a(var1x))
//                } else if (var0 == Short::class.java) {
//                    onSuccess(var1 as b.e?, a.f(var1x))
//                } else if (var0 == Double::class.java) {
//                    onSuccess(var1 as b.e?, a.d(var1x))
//                } else if (var0 == Float::class.java) {
//                    onSuccess(var1 as b.e?, a.c(var1x))
//                }
//            }
//
//            fun onFailure(var1x: CommonError?) {
//                onFailure(var1, var1x)
//            }
//        }
//    }
}
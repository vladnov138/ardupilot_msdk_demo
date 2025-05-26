package dji.common.util

import dji.common.error.DJIError

class CommonCallbacks {
    interface CompletionCallback<T : DJIError?> {
        fun onResult(var1: T)
    }

    interface CompletionCallbackWith<T> {
        fun onSuccess(var1: T)

        fun onFailure(var1: DJIError?)
    }

    interface CompletionCallbackWithTwoParam<X, Y> {
        fun onSuccess(var1: X, var2: Y)

        fun onFailure(var1: DJIError?)
    }
}
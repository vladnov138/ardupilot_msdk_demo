package dji.sdk.mission.timeline.triggers

import dji.common.error.DJIError
import java.util.concurrent.CopyOnWriteArrayList


abstract class Trigger {
    var isActive: Boolean = false
        private set
    private var action: Action? = null
    private val listeners: CopyOnWriteArrayList<Listener> = CopyOnWriteArrayList()

    fun start() {
        if (!this.isActive) {
            this.isActive = true
            this.notifyListenersOfEvent(TriggerEvent.STARTED, null as DJIError?)
        }
    }

    fun stop() {
    }

    fun setAction(var1: Action?) {
        this.action = var1
    }

    fun addListener(var1: Listener?) {
        listeners.add(var1)
    }

    fun removeListener(var1: Listener?) {
        listeners.remove(var1)
    }

    fun removeAllListeners() {
        listeners.clear()
    }

    fun notifyListenersOfEvent(var1: TriggerEvent?, var2: DJIError?) {
        for (var4 in this.listeners) {
            var4.onEvent(this, var1, var2)
        }
    }

    interface Action {
        fun onCall()
    }

    interface Listener {
        fun onEvent(var1: Trigger?, var2: TriggerEvent?, var3: DJIError?)
    }
}
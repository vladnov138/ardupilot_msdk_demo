package dji.common.bus


object MissionEventBus {
    val instance: EventBus
        get() = LazyHolder.INSTANCE

    private object LazyHolder {
        val INSTANCE: EventBus = BusFactory.createSimple()
    }
}
package dji.thirdparty.rx

interface Subscription {
    fun unsubscribe()

    fun isUnsubscribed(): Boolean
}
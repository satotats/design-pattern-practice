package satotats.practice.designpattern.observer

fun main() {
    val followee1 = FolloweeAccount("goemon")
    val followee2 = FolloweeAccount("zenigata")
    val follower = FollowerAccount()

    followee1.addObserver(follower)
    followee2.addObserver(follower)
    follower.addObserver(SmartPhoneApp())

    repeat(20) {
        followee1.tweet("またつまらるものののきってしまった part$it")
        Thread.sleep(100)
        followee2.tweet("まてるパソ part$it")

        if (it % 5 == 0) follower.check()
    }
}


abstract class Observable {
    private val observers: MutableList<Observer> = mutableListOf()

    fun addObserver(observer: Observer) = observers.add(observer)
    fun removeObserver(observer: Observer) = observers.remove(observer)
    fun notifyObservers() = observers.forEach { it.update(this) }
}

interface Observer {
    fun update(observable: Observable)
}

class FolloweeAccount(val username: String) : Observable() {
    val tweets: MutableList<Tweet> = mutableListOf()

    fun tweet(text: String) {
        tweets.add(Tweet(text, username))
        notifyObservers()
    }
}


class FollowerAccount : Observable(), Observer {
    val timeline: MutableList<Tweet> = mutableListOf()

    override fun update(observable: Observable) {
        if (observable !is FolloweeAccount) return
        val followee = observable
        timeline.addAll(followee.tweets.filter { !it.broadcasted }.onEach { it.broadcasted = true })
        notifyObservers()
    }

    fun check() {
        timeline.filter { it.broadcasted }.forEach { it.read = true }
        println("クソワロタ")
    }
}

class SmartPhoneApp : Observer {
    override fun update(observable: Observable) {
        if (observable !is FollowerAccount) return
        val account = observable

        val unread = account.timeline.filter { !it.read }
        val latest = unread.last()
        println("New ${unread.size} tweet(s) available - ${latest.username} says... \"${latest.text}\"")
    }
}


data class Tweet(
    val text: String,
    val username: String,
    var broadcasted: Boolean = false,
    var read: Boolean = false
) {}
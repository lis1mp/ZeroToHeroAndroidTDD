package ru.easycode.zerotoheroandroidtdd.count

interface Count {

    fun increment(number: String): String

    class Base(private val step: Int) : Count {
        init {
            if (step <= 0) throw IllegalStateException("step should be positive, but was $step")
        }

        override fun increment(number: String): String {
            val digits = number.toInt()
            val result = digits + step
            return result.toString()
        }

    }
}
package com.example.demo

import java.util.function.Predicate

class ErrorPredicate : Predicate<Exception> {
    override fun test(t: Exception): Boolean {
        return true
    }
}
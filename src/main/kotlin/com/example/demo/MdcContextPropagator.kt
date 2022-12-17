package com.example.demo

import io.github.resilience4j.core.ContextPropagator
import org.slf4j.MDC
import java.util.*
import java.util.function.Consumer
import java.util.function.Supplier

class MdcContextPropagator : ContextPropagator<Map<String, String>> {

    override fun retrieve(): Supplier<Optional<Map<String, String>>> {
        return Supplier {
            Optional.ofNullable(
                MDC.getCopyOfContextMap()
            )
        }
    }

    override fun copy(): Consumer<Optional<Map<String, String>>> {
        return Consumer { copyOfContextMap: Optional<Map<String, String>> ->
            copyOfContextMap.ifPresent { contextMap: Map<String, String> -> MDC.setContextMap(contextMap) }
        }
    }

    override fun clear(): Consumer<Optional<Map<String, String>>> {
        return Consumer { contextMap: Optional<Map<String, String>> -> MDC.clear() }
    }
}
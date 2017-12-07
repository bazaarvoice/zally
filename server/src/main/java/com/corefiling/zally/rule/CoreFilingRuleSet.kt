package com.corefiling.zally.rule

import de.zalando.zally.rule.api.Rule
import de.zalando.zally.rule.api.RuleSet
import org.springframework.stereotype.Component
import java.net.URI

@Component
class CoreFilingRuleSet : RuleSet {
    override val id = code(javaClass)
    override val title = "CoreFiling API Guidelines"
    override val url = URI.create("https://wiki.int.corefiling.com/platform/APIGuidelines")

    override fun url(rule: Rule): URI {
        return URI.create(url.toString() + page(javaClass) + "#" + code(javaClass))
    }
}

fun <T> code(clazz: Class<T>): String {
    return clazz.simpleName
}

fun <T> page(clazz: Class<T>): String {
    val name = lastSubpackage(clazz)
    return name.substring(0, 1).toUpperCase() + name.substring(1)
}

fun <T> lastSubpackage(clazz: Class<T>): String {
    val name = clazz.`package`.name
    return name.substring(name.lastIndexOf('.') + 1)
}

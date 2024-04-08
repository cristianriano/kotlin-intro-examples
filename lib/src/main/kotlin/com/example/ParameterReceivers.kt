package com.example

class ParameterReceivers {

  fun format(elements: List<Pair<String, Int>>): List<String> {
    return elements.map { (key, value) ->
      """
        {"$key": $value }
      """.trimIndent()
    }
  }

  fun formatWithReceiver(elements: List<Pair<String, Int>>): List<String> {
    return elements.map { it.toJson() }
  }

  private fun Pair<String, Int>.toJson() = """{"$first": $second}"""
}

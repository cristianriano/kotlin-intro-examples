package com.example

fun nullsExample() {
  var a: String? = "abc"
  a = null
}

fun lengthOf(s: String?): Int {
  return s?.length ?: -1
}

fun capitalize(x: List<String?>): List<String> {
  return x.mapNotNull { it?.uppercase() }
}

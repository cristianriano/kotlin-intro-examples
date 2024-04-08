package com.example

data class Foo(
  var bar: String? = null,
  var baz: Int = 0
)

class ScopedFunctions {

  fun initialize() = Foo()
    .apply {
      this.bar = ""
      this.baz = 1
    }
    .let { println("Initialized") }

  
}


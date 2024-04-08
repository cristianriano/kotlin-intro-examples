package com.example

// BEFORE
fun myComplexFunction(orderId: Int, partnerId: Int, productId: Int) {
  TODO()
}

// AFTER
fun myProperComplexFunction(orderId: OrderId, partnerId: PartnerId, productId: ProductId) {
  TODO()
}

@JvmInline value class OrderId(val value: Int) {
  init {
    require(value > 0) { "Must be greater than 0" }
  }
}

@JvmInline value class PartnerId(val value: Int)

@JvmInline value class ProductId private constructor(val value: Int) {
  companion object {
    fun from(value: Int): ProductId {
      // perform validations
      return ProductId(value)
    }
  }
}

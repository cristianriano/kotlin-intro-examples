package com.example

data class Order(
  val orderId: OrderId,
  val products: List<ProductId>,
  private var numberOfProducts: Int = 0
) {
  fun addProduct(productId: ProductId): Order {
    val newProducts = products.toMutableList()
    newProducts.add(productId)
    numberOfProducts += 1

    return this.copy(products = newProducts)
  }
}

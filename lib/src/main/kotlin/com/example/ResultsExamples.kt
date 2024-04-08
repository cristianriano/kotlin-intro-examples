package com.example

import com.sun.nio.sctp.Notification

interface Repository {
  fun fetch(id: OrderId): Result<Order>

  fun update(order: Order, id: ProductId): Result<Order>
}

interface Notifier {
  fun notify(order: Order): Result<Notification>
}

interface Processor {
  fun updateOrder(id: OrderId, productId: ProductId): Result<Notification>
}

class DefaultProcessor(private val repo: Repository, private val notifier: Notifier): Processor {
  override fun updateOrder(id: OrderId, productId: ProductId): Result<Notification> {
    return repo.fetch(id)
      .flatMap { repo.update(it, productId) }
      .flatMap { notifier.notify(it) }
      .onFailure { ex: Throwable -> ex.printStackTrace() }
  }
}

inline fun <T, R> Result<T>.flatMap(f: (T) -> Result<R>): Result<R> =
  fold(onSuccess = { f(it) }, onFailure = { Result.failure(it) })
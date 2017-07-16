//     Project: scalajs-rxjs
//      Module: rxjs/Subscription.ts
// Description: Façade trait for RxJS5 Subscriptions

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs.core

import rxjs.core.Subscription.TeardownLogic

import scala.scalajs.js

@js.native
trait AnonymousSubscription extends js.Object {
  def unsubscribe(): Unit = js.native
}

@js.native
trait Subscription extends AnonymousSubscription {
  def closed: Boolean = js.native
  def add(teardown: TeardownLogic): Subscription = js.native
  def remove(subscription: Subscription): Unit = js.native
}

object Subscription {
  type TeardownLogic = js.|[AnonymousSubscription,js.Function]
}

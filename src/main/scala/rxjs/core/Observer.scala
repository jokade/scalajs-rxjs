//     Project: scalajs-rxjs
// Description: Scala.js façade trait for core.Observer

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs.core

import scala.scalajs.js

@js.native
trait Observer[T] extends js.Object {
  def onNext(value: T): Unit = js.native
  def onError(error: js.Dynamic): Unit = js.native
  def onCompleted(): Unit = js.native
}

object Observer {
  @inline
  def create[T](onNext: js.Function1[T,Any]) : Observer[T] =
    js.Dynamic.global.Rx.Observer.create(onNext).asInstanceOf[Observer[T]]
  @inline
  def create[T](onNext: js.Function1[T,Any], onComplete: js.Function0[Unit]) : Observer[T] =
    js.Dynamic.global.Rx.Observer.create(onNext,onComplete).asInstanceOf[Observer[T]]

  @inline
  def apply[T](onNext: js.Function1[T,Any],
               onComplete: js.Function0[Unit] = null) : Observer[T] = create(onNext)

}

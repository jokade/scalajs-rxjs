//     Project: scalajs-rxjs
//      Module: rxjs/Observer.ts
// Description: Scala.js façade trait for RxJS5 Observer

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs

import scala.scalajs.js

@js.native
trait Observer[T] extends js.Object {
  def closed: js.UndefOr[Boolean] = js.native
  def next: js.UndefOr[js.Function1[T,Unit]] = js.native
  def error: js.UndefOr[js.Function1[js.Dynamic,Unit]] = js.native
  def complete: js.UndefOr[js.Function0[Unit]] = js.native
}

object Observer {
//  @inline
//  def create[T](onNext: js.Function1[T,Any]) : IObserver[T] =
//    js.Dynamic.global.Rx.Observer.create(onNext).asInstanceOf[IObserver[T]]
//  @inline
//  def create[T](onNext: js.Function1[T,Any], onComplete: js.Function0[Unit]) : IObserver[T] =
//    js.Dynamic.global.Rx.Observer.create(onNext,onComplete).asInstanceOf[IObserver[T]]
//
//  @inline
//  def apply[T](onNext: js.Function1[T,Any],
//               onComplete: js.Function0[Unit] = null) : IObserver[T] = create(onNext)

}

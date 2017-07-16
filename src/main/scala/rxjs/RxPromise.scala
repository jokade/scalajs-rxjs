//     Project: scalajs-rxjs
//      Module: RxPromise
// Description: Provides an extension of js.Promise with simplified event handling

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSName}
import scala.language.implicitConversions

@js.native
trait RxPromise[T] extends js.Promise[T] {

  @JSName("then")
  def andThen[R](onFulfilled: js.Function1[T,R]): RxPromise[R] = js.native

  @JSName("then")
  def andThen[R](onFulfilled: js.Function1[T,R],
                 onRejected: js.UndefOr[js.Function1[js.Any,R]]): RxPromise[R] = js.native

  @JSName("catch")
  def orCatch(onError: js.Function1[js.Any,_]): RxPromise[T] = js.native
}

object RxPromise {
  @inline
  implicit def toObservable[T](p: RxPromise[T]): Observable[T] = Observable.fromPromise(p)

  type ResolveFun[T] = Function1[T,js.Promise[T]]
  type RejectFun = Function1[Any,js.Promise[Nothing]]

  @JSGlobal("Promise")
  @js.native
  private class Impl[T](executor: js.Function2[js.Function1[T,Unit],js.Function1[Any,Unit],Any]) extends js.Object

  def apply[T](executor: Function2[js.Function1[T,Unit],js.Function1[Any,Unit],Any]): RxPromise[T] = new Impl(executor).asInstanceOf[RxPromise[T]]
  def resolve[T](value: T): RxPromise[T] = js.Promise.resolve[T](value).asInstanceOf[RxPromise[T]]
  def reject(reason: Any): RxPromise[Nothing] = js.Promise.reject(reason).asInstanceOf[RxPromise[Nothing]]

  implicit final class RichRxPromise[T](val p: RxPromise[T]) extends AnyVal {
    @inline
    def map[R](f: T=>R): RxPromise[R] = p.andThen(f)
    @inline
    @deprecated("Use map() instead","0.0.2")
    def onFulfilled[R](f: T=>R): RxPromise[R] = p.andThen(f)
    @inline
    def onError(f: js.Any=>_): RxPromise[T] = p.orCatch(f)
  }
}

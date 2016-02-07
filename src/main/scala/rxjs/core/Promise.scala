//     Project: scalajs-rxjs
//      Module:
// Description: Façade trait for Promises

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs.core

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
trait IPromise[T] extends js.Object {
  @JSName("then")
  def andThen[U](onFulfilled: js.Function1[T,U], onRejected: js.Function1[js.Any,_]): IPromise[U]
}

object IPromise {
  implicit class RichIPromise[T](val p: IPromise[T]) extends AnyVal {
    @inline
    final def andThen[U](onFulfilled: T=>U, onRejected: js.Any=>_): IPromise[U] = p.andThen[U](
      onFulfilled:js.Function1[T,U],
      onRejected: js.Function1[js.Any,_]
    )

    @inline
    final def onSuccess[U](f: T=>U): IPromise[U] = p.andThen[U](f,null)
  }
}

@js.native
@JSName("Promise")
object Promise extends js.Object {
  def resolve[T](value: T): IPromise[T] = js.native
  def reject[T](value: T): IPromise[T] = js.native
}

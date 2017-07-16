//     Project: scalajs-rxjs
//      Module:
// Description: Façade trait for Promises

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs.core

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSName}

@js.native
@JSGlobal("Promise")
class IPromise[T](f: js.Function2[js.Function1[T,Unit],js.Function1[T,Unit],_]) extends js.Object {
  @JSName("then")
  def andThen[U](onFulfilled: js.Function1[T,U], onRejected: js.Function1[js.Any,_]): IPromise[U] = js.native
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

//  def apply[T](resolve: =>T): IPromise[T] = new IPromise[T]((resolve:js.Function1[T,Unit],reject:js))
}

@js.native
@JSGlobal("Promise")
object Promise extends js.Object {
  def resolve[T](value: T): IPromise[T] = js.native
  def reject[T](value: T): IPromise[T] = js.native
}

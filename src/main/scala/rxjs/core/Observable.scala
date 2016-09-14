//     Project: scalajs-rxjs
// Description: Scala.js façade for RxJS core.Observable

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs.core

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
trait Observable[T] extends js.Object {
  def map[U](selector: js.Function1[T,U]): Observable[U] = js.native
  def map[U](selector: Selector[T,U]): Observable[U] = js.native
  // TODO: what is the return type of subscribe?
  def subscribe[U<:T](observer: Observer[U]): js.Dynamic = js.native
  def subscribe[U<:T](onNext: js.Function1[U,Any],
                onError: js.Function1[js.Dynamic,Any] = null,
                onCompleted: js.Function0[Any] = null) = js.native

  def toPromise(): js.Promise[T] = js.native
}

@JSName("Rx.Observable")
@js.native
object Observable extends js.Object {
  def just[T<:Any](value: T): Observable[T] = js.native
  @JSName("throw")
  def throwError[T<:Any](exception: js.Any): Observable[T] = js.native
}

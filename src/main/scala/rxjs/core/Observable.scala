//     Project: scalajs-rxjs
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs.core

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
trait IObservable[T] extends js.Object {
  @JSName("catch")
  def catchJS[U](handler: js.Function1[_,IObservable[U]]): IObservable[U] = js.native
  @JSName("catch")
  def catchJS[U](obs: IObservable[U]): IObservable[U] = js.native
  @JSName("map")
  def mapJS[U](selector: js.Function1[T,U]): IObservable[U] = js.native
  @JSName("map")
  def mapJS[U](selector: Selector[T,U]): IObservable[U] = js.native
  // TODO: what is the return type of subscribe?
  @JSName("subscribe")
  def subscribeJS(observer: Observer[T]): js.Dynamic = js.native
  @JSName("subscribe")
  def subscribeJS(onNext: js.Function1[T,_],
                onError: js.Function1[js.Dynamic,_],
                onCompleted: js.Function0[_]): js.Dynamic = js.native
}

object IObservable {

  implicit class RichIObservable[T](val o: IObservable[T]) extends AnyVal {
    def map[U](selector: T=>U): IObservable[U] = o.mapJS(selector:js.Function1[T,U])

    def subscribe(onNext: T => Any): js.Dynamic =
      o.subscribeJS(onNext: js.Function1[T, _], null, null)

    def orElse[U](f: =>U): IObservable[U] = o.catchJS( (_:Any) => Observable.of(f) )
  }

}

@JSName("Rx.Observable")
@js.native
object Observable extends js.Object {
  def of[T](value: T): IObservable[T] = js.native
  @JSName("throw")
  def throwError[T](exception: T): IObservable[T] = js.native

}


//     Project: scalajs-rxjs
//      Module: rxjs/Observable.ts
// Description: Façade traits for RxJS5 Observable

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs

import rxjs.core.Subscription

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, JSName}


@js.native
trait Observable[T] extends js.Object {

  @JSName("subscribe")
  def subscribeJS(): Subscription = js.native
  @JSName("subscribe")
  def subscribeJS(observer: Observer[T]): Subscription = js.native
  @JSName("subscribe")
  def subscribeJS(next: js.UndefOr[js.Function1[T,_]] = js.undefined,
                  error: js.UndefOr[js.Function1[js.Dynamic,_]] = js.undefined,
                  complete: js.UndefOr[js.Function0[_]] = js.undefined): Subscription = js.native
//  @JSName("forEach")
//  def forEachJS(next: js.Function1[T,_]): Observable[T] = js.native
}


object Observable {

  implicit final class RichIObservable[T](val o: Observable[T]) extends AnyVal {

    @inline
    def debounceTime(dueTime: Int): Observable[T] = Operators.debounceTime(o,dueTime)

    @inline
    def distinctUntilChanged(compare: js.UndefOr[js.Function] = js.undefined): Observable[T] = Operators.distinctUntilChanged(o,compare)

//    @inline
//    def forEach(next: T=>Any): Observable[T] = o.forEachJS(next:js.Function1[T,_])

    @inline
    def map[R](project: (T,Int) =>R): Observable[R] = Operators.map(o,project)

    @inline
    def onError[R](selector: (js.Any,Observable[T])=>Observable[R]): Observable[R] = Operators._catch(o,selector)

    @inline
    def onError[R](onError: js.Any=>Any)(default: =>R): Observable[R] = Operators._catch(o,(error:js.Any,obs:Observable[_])=>{onError(error);Observable.of(default)})

    @inline
    def subscribe[R](next: T=>R): Subscription = o.subscribeJS(next: js.Function1[T,_],js.undefined,js.undefined)

    @inline
    def switchMap[R](project: (T,Int)=>Observable[R]): Observable[R] = Operators.switchMap(o,project)

    @inline
    def toPromise: RxPromise[T] = Operators.toPromise(o)
  }

  @js.native
  @JSImport("rxjs/observable/fromPromise","fromPromise")
  object fromPromise extends js.Object {
    def apply[T](promise: js.Promise[T]): Observable[T] = js.native
  }

  @js.native
  @JSImport("rxjs/observable/interval","interval")
  object interval extends js.Object {
    def apply(period: Int = 0): Observable[Int] = js.native
  }

  @js.native
  @JSImport("rxjs/observable/of","of")
  object of extends js.Object {
    def apply[T](value: T): Observable[T] = js.native
  }
}



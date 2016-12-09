//     Project: scalajs-rxjs
//      Module: rxjs/Observable.ts
// Description: Façade traits for RxJS5 Observable

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs

import de.surfice.smacrotools.JSRef
import rxjs.core.Subscription

import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.js.annotation.JSName


@js.native
trait Observable[+T] extends js.Object {

  @JSName("subscribe")
  def subscribeJS(): Subscription = js.native
  @JSName("subscribe")
  def subscribeJS[U>:T](observer: Observer[U]): Subscription = js.native
  @JSName("subscribe")
  def subscribeJS(next: js.UndefOr[js.Function1[T,_]] = js.undefined,
                  error: js.UndefOr[js.Function1[js.Dynamic,_]] = js.undefined,
                  complete: js.UndefOr[js.Function0[_]] = js.undefined): Subscription = js.native
}


object Observable {

  implicit final class RichIObservable[T](val o: Observable[T]) extends AnyVal {

    @inline
    def count: Observable[Int] = Operators.count(o)

    @inline
    def count(predicate: (T,Int,Observable[T])=>Boolean): Observable[Int] = Operators.count(o,predicate:js.Function3[T,Int,Observable[T],Boolean])

    @inline
    def debounceTime(dueTime: Int): Observable[T] = Operators.debounceTime(o,dueTime)

    @inline
    def distinctUntilChanged(compare: js.UndefOr[js.Function] = js.undefined): Observable[T] = Operators.distinctUntilChanged(o,compare)

    @inline
    def `do`(f: T=>Any): Observable[T] = Operators._do(o,f)

    @inline
    def elementAt(index: Int): Observable[T] = Operators.elementAt(o,index)

    @inline
    def filter(predicate: (T,Int)=>Boolean): Observable[T] = Operators.filter(o,predicate)

    @inline
    def find(predicate: (T,Int)=>Boolean): Observable[T] = Operators.find(o,predicate)

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

    def subscribe[R](next: T=>R, error: js.Any=>_, complete: ()=>_): Subscription =
      o.subscribeJS(next: js.Function1[T,_],error: js.Function1[js.Any,_],complete: js.Function0[_])

    @inline
    def switchMap[R](project: (T,Int)=>Observable[R]): Observable[R] = Operators.switchMap(o,project)

    @inline
    def take(count: Int): Observable[T] = Operators.take(o,count)

    @inline
    def toPromise: RxPromise[T] = Operators.toPromise(o)

    @inline
    def toFuture: Future[T] = Operators.toPromise(o).toFuture
  }

  implicit final class RichHigherObservable[T](val o: Observable[Observable[T]]) extends AnyVal {
    @inline
    def concatAll(): Observable[T] = Operators.concatAll(o)
  }

  @js.native
  @JSRef("Rx.Observable.concat","rxjs/observable/concat","concat")
  object concat extends js.Object {
    def apply[T](inputs: Observable[T]*): Observable[T] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.fromPromise","rxjs/observable/fromPromise","fromPromise")
  object fromPromise extends js.Object {
    def apply[T](promise: js.Promise[T]): Observable[T] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.interval","rxjs/observable/interval","interval")
  object interval extends js.Object {
    def apply(period: Int = 0): Observable[Int] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.of","rxjs/observable/of","of")
  object of extends js.Object {
    def apply[T](values: T*): Observable[T] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.throw","rxjs/observable/throw","throw")
  object throwError extends js.Object {
    def apply[T](msg: T): Observable[T] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.range","rxjs/observable/range","range")
  object range extends js.Object {
    def apply(start: Int = 0, count: Int = 0, scheduler: js.UndefOr[Scheduler] = js.undefined): Observable[Int] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.zip","rxjs/observable/zip","zip")
  object zip extends js.Object {
    def apply[T](observables: Observable[T]*): Observable[js.Array[T]] = js.native
    def apply[T1,T2,R](
        observable1: Observable[T1],
        observable2: Observable[T2], 
        fn:js.Function2[T1,T2,R]):Observable[R] = js.native
    def apply[T1,T2,T3,R](
        observable1: Observable[T1],
        observable2: Observable[T2],
        observable3: Observable[T3], 
        fn:js.Function3[T1,T2,T3,R]):Observable[R] = js.native
    def apply[T1,T2,T3,T4,R](
        observable1: Observable[T1],
        observable2: Observable[T2],
        observable3: Observable[T3],
        observable4: Observable[T4], 
        fn:js.Function4[T1,T2,T3,T4,R]):Observable[R] = js.native
    def apply[T1,T2,T3,T4,T5,R](
        observable1: Observable[T1],
        observable2: Observable[T2],
        observable3: Observable[T3],
        observable4: Observable[T4], 
        observable5: Observable[T5], 
        fn:js.Function5[T1,T2,T3,T4,T5,R]):Observable[R] = js.native
    def apply[T1,T2,T3,T4,T5,T6,R](
        observable1: Observable[T1],
        observable2: Observable[T2],
        observable3: Observable[T3],
        observable4: Observable[T4], 
        observable5: Observable[T5], 
        observable6: Observable[T6], 
        fn:js.Function6[T1,T2,T3,T4,T5,T6,R]):Observable[R] = js.native

  }

}



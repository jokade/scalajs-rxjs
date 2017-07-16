//     Project: Default (Template) Project
//      Module: rxjs/operator/*
// Description: Façades for the RxJS5 oparators

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, JSName}

object Operators {

  @js.native
  @JSImport("rxjs/operator/buffer","buffer","Rx.Observable.prototype.buffer")
  object buffer extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], closingNotifier: Observable[Any]): Observable[js.Array[T]] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/catch","_catch","Rx.Observable.prototype._catch")
  object _catch extends js.Object {
    @JSName("call")
    def apply[T,R](observable: Observable[T], selector: js.Function2[js.Any,Observable[T],Observable[R]]): Observable[R] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/concatAll","concatAll","Rx.Observable.prototype.concatAll")
  object concatAll extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[Observable[T]]): Observable[T] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/count","count","Rx.Observable.prototype.count")
  object count extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], predicate: js.UndefOr[js.Function3[T,Int,Observable[T],Boolean]] = js.undefined): Observable[Int] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/delay","delay","Rx.Observable.prototype.delay")
  object delay extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], delay: Int): Observable[T] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/do","_do","Rx.Observable.prototype._do")
  object _do extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], f: js.Function1[T,_]): Observable[T] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/debounceTime","debounceTime","Rx.Observable.prototype.debounceTime")
  object debounceTime extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], dueTime: Int): Observable[T] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/distinctUntilChanged","distinctUntilChanged","Rx.Observable.prototype.distinctUntilChanged")
  object distinctUntilChanged extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], compare: js.UndefOr[js.Function] = js.undefined): Observable[T] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/elementAt","elementAt","Rx.Observable.prototype.elementAt")
  object elementAt extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], index: Int): Observable[T] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/filter","filter","Rx.Observable.prototype.filter")
  object filter extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], predicate: js.Function2[T,Int,Boolean]): Observable[T] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/find","find","Rx.Observable.prototype.find")
  object find extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], predicate: js.Function2[T,Int,Boolean]): Observable[T] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/first","first","Rx.Observable.prototype.first")
  object first extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], predicate: js.UndefOr[js.Function3[T,Int,Observable[T],Boolean]] = js.undefined): Observable[T] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/map", "map","Rx.Observable.prototype.map")
  object map extends js.Object {
    @JSName("call")
    def apply[T,R](observable: Observable[T], project: js.Function2[T, Int, R]): Observable[R] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/switchMap","switchMap","Rx.Observable.prototype.switchMap")
  object switchMap extends js.Object {
    @JSName("call")
    def apply[T,R](observable: Observable[T], project: js.Function2[T, Int, Observable[R]]): Observable[R] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/take","take","Rx.Observable.prototype.take")
  object take extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], count: Int): Observable[T] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/toPromise","toPromise","Rx.Observable.prototype.toPromise")
  object toPromise extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T]): RxPromise[T] = js.native
  }

}

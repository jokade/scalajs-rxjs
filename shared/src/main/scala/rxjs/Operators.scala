//     Project: Default (Template) Project
//      Module: rxjs/operator/*
// Description: Façades for the RxJS5 oparators

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs

import de.surfice.smacrotools.{JSRef, debug}

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, JSName}

object Operators {

  @js.native
  @JSRef("Rx.Observable.prototype._catch","rxjs/operator/catch","_catch")
  object _catch extends js.Object {
    @JSName("call")
    def apply[T,R](observable: Observable[T], selector: js.Function2[js.Any,Observable[T],Observable[R]]): Observable[R] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.prototype.concatAll","rxjs/operator/concatAll","concatAll")
  object concatAll extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[Observable[T]]): Observable[T] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.prototype.count","rxjs/operator/count","count")
  object count extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], predicate: js.UndefOr[js.Function3[T,Int,Observable[T],Boolean]] = js.undefined): Observable[Int] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.prototype.do","rxjs/operator/do","do")
  object _do extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], f: js.Function1[T,_]): Observable[T] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.prototype.debounceTime","rxjs/operator/debounceTime","debounceTime")
  object debounceTime extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], dueTime: Int): Observable[T] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.prototype.distinctUntilChanged","rxjs/operator/distinctUntilChanged","distinctUntilChanged")
  object distinctUntilChanged extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], compare: js.UndefOr[js.Function] = js.undefined): Observable[T] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.prototype.elementAt","rxjs/operator/elementAt","elementAt")
  object elementAt extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], index: Int): Observable[T] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.prototype.filter","rxjs/operator/filter","filter")
  object filter extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], predicate: js.Function2[T,Int,Boolean]): Observable[T] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.prototype.find","rxjs/operator/find","find")
  object find extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], predicate: js.Function2[T,Int,Boolean]): Observable[T] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.prototype.map","rxjs/operator/map", "map")
  object map extends js.Object {
    @JSName("call")
    def apply[T,R](observable: Observable[T], project: js.Function2[T, Int, R]): Observable[R] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.prototype.switchMap","rxjs/operator/switchMap","switchMap")
  object switchMap extends js.Object {
    @JSName("call")
    def apply[T,R](observable: Observable[T], project: js.Function2[T, Int, Observable[R]]): Observable[R] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.prototype.take","rxjs/operator/take","take")
  object take extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], count: Int): Observable[T] = js.native
  }

  @js.native
  @JSRef("Rx.Observable.prototype.toPromise","rxjs/operator/toPromise","toPromise")
  object toPromise extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T]): RxPromise[T] = js.native
  }
  
  @js.native
  @JSRef("Rx.Observable.prototype.zip","rxjs/operator/zip","zip")
  object zip extends js.Object {
    @JSName("call")
    def apply[T1,T2,R](observable1: Observable[T1],observable2: Observable[T2], project: js.Function2[T1,T2,R]): Observable[R] = js.native
  }

}

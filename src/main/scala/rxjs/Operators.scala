//     Project: Default (Template) Project
//      Module: rxjs/operator/*
// Description: Façades for the RxJS5 oparators

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, JSName}

object Operators {

  @js.native
  @JSImport("rxjs/operator/catch","_catch")
  object _catch extends js.Object {
    @JSName("call")
    def apply[T,R](observable: Observable[T], selector: js.Function2[js.Any,Observable[T],Observable[R]]): Observable[R] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/debounceTime","debounceTime")
  object debounceTime extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], dueTime: Int): Observable[T] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/distinctUntilChanged","distinctUntilChanged")
  object distinctUntilChanged extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T], compare: js.UndefOr[js.Function] = js.undefined): Observable[T] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/map", "map")
  object map extends js.Object {
    @JSName("call")
    def apply[T,R](observable: Observable[T], project: js.Function2[T, Int, R]): Observable[R] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/switchMap","switchMap")
  object switchMap extends js.Object {
    @JSName("call")
    def apply[T,R](observable: Observable[T], project: js.Function2[T, Int, Observable[R]]): Observable[R] = js.native
  }

  @js.native
  @JSImport("rxjs/operator/toPromise","toPromise")
  object toPromise extends js.Object {
    @JSName("call")
    def apply[T](observable: Observable[T]): RxPromise[T] = js.native
  }
}

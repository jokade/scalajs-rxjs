//     Project: scalajs-rxjs
// Description: Types and utility functions for package rxjs.core

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs

import scala.scalajs.js

package object core {
  type Selector[T,U] = js.Function3[T,Int,Observable[T],U]

//  implicit class RichObservable[T](val obv: IObservable[T]) {
//    def toFuture: Future[T] = obv.toPromise().toFuture
//  }
}

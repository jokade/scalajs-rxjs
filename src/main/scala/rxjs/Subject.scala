//     Project: scalajs-rxjs
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("rxjs/Subject","Subject")
class Subject[T] extends Observable[T] {
  def next(value: T): Unit = js.native
}

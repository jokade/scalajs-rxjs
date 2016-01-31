//     Project: scalajs-rxjs
// Description: Tests for core.Observable

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs.core.test

import rxjs.core.{Observer, Observable}
import utest._
import rxjs.TestBase

object ObservableTest extends TestBase {
  val tests = TestSuite {
    'object-{
      'just-{
        future( Observable.just("hello") ) map { res =>
          assert(res.size == 1, res(0) == "hello" )
        }
      }
    }
  }
}

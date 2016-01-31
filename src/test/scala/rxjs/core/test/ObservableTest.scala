//     Project: scalajs-rxjs
// Description: Tests for core.Observable

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package rxjs.core.test

import rxjs.TestBase
import rxjs.core.Observable
import utest._

import scala.concurrent.Promise
import scala.scalajs.js

object ObservableObjectTest extends TestBase {
  val tests = TestSuite {
    'just-{
      future( Observable.just("hello") ) map { res =>
        assert(res.size == 1, res(0) == "hello" )
      }
      'throwError-{
        future( Observable.throwError("error") ).expectFailure( x => assert(x.getMessage == "error") )
      }
    }
  }
}


trait ObservableInstanceBehaviour extends TestBase {
  def just[T](value: T): Observable[T]
  def throwError[T](msg: js.Any): Observable[T]

  val tests = TestSuite {
    'subscribe-{
      val p = Promise[Int]()
      'next-{
        just(42).subscribe((x: Int) => p.success(x))
        p.future.map(x => assert(x == 42))
      }
      'err-{
        //          throwError[String]("error").subscribe((_: String) => {}, (err: js.Any) => {})
      }
    }

    'map-{
      'a-{
        future( just(42).map( (x:Int) => x+1 ))
          .map{ res => assert(
            res.size == 1,
            res(0) == 43
          )}
      }
    }
  }
}


object ObservableInstanceTest extends ObservableInstanceBehaviour {
  override def just[T](value: T): Observable[T] = Observable.just(value)
  override def throwError[T](msg: js.Any): Observable[T] = Observable.throwError(msg)
}

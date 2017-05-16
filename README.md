scalajs-rxjs
============
[![Scala.js](https://www.scala-js.org/assets/badges/scalajs-0.6.13.svg)](https://www.scala-js.org)
[![Build Status](https://travis-ci.org/jokade/scalajs-rxjs.svg?branch=master)](https://travis-ci.org/jokade/scalajs-rxjs)

Scala.js façade traits for [RxJS 5](https://github.com/ReactiveX/rxjs).

### SBT Settings
If you use Scala.js with global scope, add this to your `build.sbt`
```scala
libraryDependencies += "de.surfice" %%% "scalajs-rxjs" % "0.0.2"
```

Alternativley, if you compile your [Scala.js code to a CommonJS module](https://www.scala-js.org/doc/project/module.html) (i.e. `scalaJSModuleKind := ModuleKind.CommonJSModule`), you must use `scalajs-rxjs_cjsm` instead:
```scala
libraryDependencies += "de.surfice" %%% "scalajs-rxjs_cjsm" % "0.0.2"
```

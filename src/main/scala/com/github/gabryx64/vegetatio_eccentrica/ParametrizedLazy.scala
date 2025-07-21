package com.github.gabryx64.vegetatio_eccentrica

object ParamLazy {
  private object ParamLazyParam {
    class Instance[T] {
      private var param: T = _

      def set(x: => T): Unit = { param = x }
      def get(): T = param
    }

    private val cache =
      collection.mutable.HashMap[Class[_], Instance[_]]()

    def apply[T]()(implicit m: Manifest[T]): Instance[T] =
      cache.getOrElseUpdate(m.runtimeClass, new Instance[T]).asInstanceOf[Instance[T]]
  }

  def apply[T1, T2](f: T2 => T1)(implicit m: Manifest[T2]): T1 = {
    f(ParamLazyParam[T2].get())
  }

  def init[T1, T2](toInit: => T1, param: => T2)(implicit m: Manifest[T2]): T1 = {
    ParamLazyParam[T2].set(param)
    toInit
  }
}

package com.github.gabryx64.lifesynth
import java.util.function.{Function => JavaFunction}

object Conversions {
  implicit def scalaFunctionToJavaFunction[From, To](function: (From) => To): JavaFunction[From, To] = {
    new java.util.function.Function[From, To] {
      override def apply(input: From): To = function(input)
    }
  }
}

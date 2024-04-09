package com.example

import java.io.File
import javax.sql.DataSource

// Create a sealed interface
sealed interface Error

// Create a sealed class that implements sealed interface Error
sealed class IOError(): Error

// Define subclasses that extend sealed class 'IOError'
class FileReadError(val file: File): IOError()
class DatabaseError(val source: DataSource): IOError()

// Create a singleton object implementing the 'Error' sealed interface
object RuntimeError : Error

fun log(e: Error) = when(e) {
  is FileReadError -> println("Error while reading file ${e.file}")
  is DatabaseError -> println("Error while reading from database ${e.source}")
  RuntimeError -> println("Runtime error")
}
package models

case class Date(
                 date: String
               )

object Date {
  val today: Date = Date("20210219")
  val tomorrow: Date = Date("20210220")
}
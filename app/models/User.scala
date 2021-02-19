package models

case class User(
                 email: String,
                 name: String
               )

object User {
  val sunni: User = User("sunni@com", "Sunni")
  val chris: User = User("chris@.com", "Chris")
}

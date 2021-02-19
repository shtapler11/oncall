package models

case class UserOnCall(
                       user: User,
                       date: Date
                     )

object UserOnCall {
  val usersOnCall: List[UserOnCall] = List(
    UserOnCall(User.sunni, Date.today),
    UserOnCall(User.chris, Date.tomorrow)
  )
}
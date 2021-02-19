package controllers

import models.{Date, UserOnCall}

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class OnCallController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def getName: Action[AnyContent] = Action { Ok("Hi there") }

  def getDate(dateId: String): Action[AnyContent] = Action { Ok(s"Hi there $dateId") }

  def getDateInfo(dates: List[String]): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    dates match {
      case Nil =>
        val today: String = Date.today.date

        // Find an on-call user on this date
        val result: Option[UserOnCall] = UserOnCall.usersOnCall.find(userOnCall =>
          userOnCall.date.date.contentEquals(today))

        result match {
          case Some(value) => Ok(value.toString)
          case None => Ok("No user allocated")
        }

      case _ => Ok(dates.mkString(","))
    }
  }
}
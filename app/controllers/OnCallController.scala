package controllers

import models.{Date, User, UserOnCall}

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class OnCallController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def getName: Action[AnyContent] = Action { Ok("Hi there") }

  def getDate(dateId: String): Action[AnyContent] = Action { Ok(s"Hi there $dateId") }

  def getOnCallUserFromDate(date: String): Option[UserOnCall] = {
    UserOnCall.usersOnCall.find(userOnCall => userOnCall.date.date.contentEquals(date))
  }

  def getApiResponse(user: List[Option[UserOnCall]]): Result = {
    user match {
      case List(values@_*) => Ok(values.flatMap(x => x.asInstanceOf[UserOnCall].toString).toString)
      case Nil => Ok("No user allocated")
    }
  }

  def getDateInfo(dates: List[String]): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    dates match {
      case Nil =>
        val today: String = Date.today.date
        // Find an on-call user on this date
        getApiResponse(List(getOnCallUserFromDate(today)))

      case List(dates@_*) => Ok(dates.flatMap(getOnCallUserFromDate).toString)
    }
  }
}
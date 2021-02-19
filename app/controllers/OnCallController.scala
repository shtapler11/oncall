package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class OnCallController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def getName: Action[AnyContent] = Action { Ok("Hi there") }

  def getDate(dateId: String): Action[AnyContent] = Action { Ok(s"Hi there $dateId") }

  def getDateInfo(dates: List[String]): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    println(s"Dates: ${dates}")
    Ok
  }
}
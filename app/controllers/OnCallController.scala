package controllers

import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class OnCallController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def getName: Action[AnyContent] = Action { Ok("Hi there") }
}
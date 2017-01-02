package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import dbspike._

class DbSpikeController extends Controller {
  
 def index: Action[AnyContent] = Action { implicit request =>
    val users = UserService.listAllUsers
    Ok(views.html.index(UserForm.form, users))
  }

  def addUser() = Action { implicit request =>
    UserForm.form.bindFromRequest.fold(
      // if any error in submitted data
      errorForm => Ok(views.html.index(errorForm, Seq.empty[User])),
      data => {
        val newUser = User(0, data.firstName, data.lastName, data.mobile, data.email)
        val res = UserService.addUser(newUser)
        Redirect(routes.DbSpikeController.index())
      })
  }

  def deleteUser(id: Long) = Action { implicit request =>
    UserService.deleteUser(id)
    Redirect(routes.DbSpikeController.index())
  }
  
}
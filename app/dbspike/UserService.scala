package dbspike

import scala.concurrent.Future
import scala.concurrent.ExecutionContext
import concurrent.ExecutionContext.Implicits.global

object UserService {
  
  def addUser(user: User): String = {
      Users.add(user)
  }

  def deleteUser(id: Long): Option[Int] = {
      Users.delete(id)
  }

  def getUser(id: Long): Option[User] = {
      Users.get(id)
  }

  def listAllUsers: Seq[User] = {
      Users.listAll
  }
  
}
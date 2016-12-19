package com.dmac.basic

/**
 * Elucidating the use of mixin
 */
object TraitSSO extends App {
  
  val ssoClient = new OpenSSOClient
  ssoClient.notify("sss")
}


trait Authentication {
  
  def login(userName : String, password : String) : Boolean
  
  def logout(userName: String) : Boolean
  
  def checkForLogin()
  
  def protocol = {
    "_NO_PROTOCOL_IMPLEMENTED_"
  }
}


class OpenSSO extends Authentication {
  
  def login(userName : String, password : String) = {
    true
  }
  
  def logout(userName: String) = {
    true
  }
  
  def checkForLogin() = {
    println("login check using opensso library")
  }
  
  override def protocol = {
    "OPEN_SSO"
  }
}


class OpenLDAP extends Authentication {
  
  def login(userName : String, password : String) = {
    true
  }
  
  def logout(userName: String) = {
    true
  }
  
  def checkForLogin() = {
    println("login check using ldap library")
  }
  
  override def protocol = {
    "OPEN_LDAP"
  }
}

trait AuthenticatioHBASELoggingTrait {

  def logIntoElasticSearch(userName : String) = {
    println("Logging into HBASE")
  }
}

trait NotifyThirdPartyTrait {

  def notify(userName : String) = {
    println(s"Notifying that $userName has logged in")
  }
}

class OpenSSOClient extends OpenSSO with AuthenticatioHBASELoggingTrait 
                                    with NotifyThirdPartyTrait 
{
  
}
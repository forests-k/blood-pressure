package jp.co.musako.presentaion.handler

import org.slf4j.*
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import javax.servlet.http.*

class ExceptionHandler {

  companion object {
    private val log = LoggerFactory.getLogger(ExceptionHandler::class.java)
  }

  @ResponseStatus(INTERNAL_SERVER_ERROR)
  @org.springframework.web.bind.annotation.ExceptionHandler(Exception::class)
  @ResponseBody
  fun handleError(e: Exception, response: HttpServletResponse): Map<String, Any> {
    val errorMap = HashMap<String, Any>()
    errorMap["message"] = e.localizedMessage
    errorMap["status"] = INTERNAL_SERVER_ERROR

    log.error(e.localizedMessage);

    return errorMap;
  }
}
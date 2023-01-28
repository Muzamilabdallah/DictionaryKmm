package com.muzamil.dictionarykmm.domain

enum class GeneralError {
    SERVICE_UNVAILABLE,
   BAD_REQUEST,
    NOT_FOUND,
    SERVER_ERROR,
    UNKOWN_ERROR

}

class GeneralException(val error: GeneralError):Exception("ERROR OCCURED")
